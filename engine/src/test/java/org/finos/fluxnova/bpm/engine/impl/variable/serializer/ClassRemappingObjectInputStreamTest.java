package org.finos.fluxnova.bpm.engine.impl.variable.serializer;

import org.finos.fluxnova.TestProxyInterface;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * Tests for ClassRemappingObjectInputStream.
 *
 * Verifies that proxy resolution remaps legacy interface names from the
 * org.camunda namespace to the org.finos.fluxnova namespace and that
 * dynamic proxy classes implementing the expected interfaces are created.
 */
public class ClassRemappingObjectInputStreamTest {

    private static final int TEST_VALUE_LEGACY = 42;
    private static final int TEST_VALUE_NEW = 99;
    private static final String TEST_STRING = "Test String";

    /**
     * Produce a byte[] containing a valid ObjectStream header so the
     * ObjectInputStream constructor can be created for testing.
     */
    private static byte[] objectStreamHeader() throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.flush();
                return baos.toByteArray();
            }
    }

    /**
     * Ensure that a legacy interface name (org.camunda.TestProxyInterface)
     * is remapped to org.finos.fluxnova.TestProxyInterface and that the created
     * proxy implements the expected test interface.
     */
    @Test
    public void resolveProxyClassRemapsLegacyInterfaceNameToNewNamespace() throws Exception {
        byte[] header = objectStreamHeader();
        try (ClassRemappingObjectInputStream in = new ClassRemappingObjectInputStream(new java.io.ByteArrayInputStream(header))) {
            String legacyName = "org.camunda.TestProxyInterface";
            Class<?> proxyClass = in.resolveProxyClass(new String[]{legacyName});
            assertNotNull("Proxy class should be created", proxyClass);
            assertTrue("Result should be a dynamic proxy class", Proxy.isProxyClass(proxyClass));
            boolean implementsExpected = false;
            for (Class<?> iface : proxyClass.getInterfaces()) {
                if (iface.equals(TestProxyInterface.class)) {
                    implementsExpected = true;
                    break;
                }
            }
            assertTrue("Proxy should implement org.finos.fluxnova.TestProxyInterface after remapping", implementsExpected);
        }
    }

    /**
     * Ensure that an interface name already in the org.finos.fluxnova namespace
     * is accepted directly and the created proxy implements the expected interface.
     */
    @Test
    public void resolveProxyClassAcceptsNewNamespaceInterfaceNameDirectly() throws Exception {
        byte[] header = objectStreamHeader();
        try (ClassRemappingObjectInputStream in = new ClassRemappingObjectInputStream(new java.io.ByteArrayInputStream(header))) {
            String newName = "org.finos.fluxnova.TestProxyInterface";
            Class<?> proxyClass = in.resolveProxyClass(new String[]{newName});
            assertNotNull("Proxy class should be created", proxyClass);
            assertTrue("Result should be a dynamic proxy class", Proxy.isProxyClass(proxyClass));
            boolean implementsExpected = false;
            for (Class<?> iface : proxyClass.getInterfaces()) {
                if (iface.equals(TestProxyInterface.class)) {
                    implementsExpected = true;
                    break;
                }
            }
            assertTrue("Proxy should implement the test interface", implementsExpected);
        }
    }

    /**
     * Ensure that an object serialized as org.camunda.LegacySerialized is deserialized
     * as org.finos.fluxnova.LegacySerialized via ClassRemappingObjectInputStream.
     */
    @Test
    public void resolveClassRemapsLegacyClassNameToNewNamespace() throws Exception {
        // create legacy instance (fully-qualified to avoid import alias issues)
        org.camunda.LegacySerialized legacy = new org.camunda.LegacySerialized(TEST_VALUE_LEGACY);

        byte[] bytes;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(legacy);
            oos.flush();
            bytes = baos.toByteArray();
        }

        try (ClassRemappingObjectInputStream in = new ClassRemappingObjectInputStream(new java.io.ByteArrayInputStream(bytes))) {
            Object obj = in.readObject();
            assertNotNull("Deserialized object should not be null", obj);

            // verify that the object was resolved to the new package and retains the field
            assertEquals("Deserialized class name should be the new namespace",
                    "org.finos.fluxnova.LegacySerialized", obj.getClass().getName());

            // cast to target class and verify field preserved
            org.finos.fluxnova.LegacySerialized target = (org.finos.fluxnova.LegacySerialized) obj;
            assertEquals("Field value should be preserved after remapping", TEST_VALUE_LEGACY, target.value);
        }
    }

    /**
     * Verify that deserialization of an object whose class name does not require
     * remapping (e.g., java.lang.String) proceeds normally and preserves value.
     */
    @Test
    public void resolveClassWithNonRemappedNameWorksNormally() throws Exception {
        // create an instance of a class that doesn't require remapping
        String original = TEST_STRING;

        byte[] bytes;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original);
            oos.flush();
            bytes = baos.toByteArray();
        }

        try (ClassRemappingObjectInputStream in = new ClassRemappingObjectInputStream(new java.io.ByteArrayInputStream(bytes))) {
            Object obj = in.readObject();
            assertNotNull("Deserialized object should not be null", obj);
            assertTrue("Deserialized object should be a String", obj instanceof String);
            assertTrue("String value should match original", original.equals(obj));
        }
    }

    /**
     * Ensure that an object already serialized in the new namespace (org.finos.fluxnova)
     * deserializes normally without remapping and retains its state.
     */
    @Test
    public void resolveClassWithNewNamespaceNameWorksNormally() throws Exception {
        org.finos.fluxnova.LegacySerialized original = new org.finos.fluxnova.LegacySerialized(TEST_VALUE_NEW);

        byte[] bytes;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original);
            oos.flush();
            bytes = baos.toByteArray();
        }

        try (ClassRemappingObjectInputStream in = new ClassRemappingObjectInputStream(new java.io.ByteArrayInputStream(bytes))) {
            Object obj = in.readObject();
            assertNotNull("Deserialized object should not be null", obj);
            assertEquals("Should remain in the new namespace",
                    "org.finos.fluxnova.LegacySerialized", obj.getClass().getName());
            org.finos.fluxnova.LegacySerialized target = (org.finos.fluxnova.LegacySerialized) obj;
            assertEquals("Field value should be preserved", TEST_VALUE_NEW, target.value);
        }
    }

}
