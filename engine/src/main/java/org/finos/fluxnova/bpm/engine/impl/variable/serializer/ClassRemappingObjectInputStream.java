package org.finos.fluxnova.bpm.engine.impl.variable.serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Proxy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An ObjectInputStream that remaps legacy serialized class names from a previous package
 * namespace to the current one during deserialization.
 *
 * Since we refactored package from org.camunda to org.finos.fluxnova, we have to make backward
 * compatible for org.finos.flxunova for objects that were seralized as org.camunda
 *
 * This remapping covers both regular class names and single-dimension object array descriptors.
 */
final class ClassRemappingObjectInputStream extends ObjectInputStream {
    public static final String LEGACY_NAMESPACE_PREFIX = "org.camunda.";
    public static final String NEW_NAMESPACE_PREFIX = "org.finos.fluxnova.";

    public ClassRemappingObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    /**
     * Read the class descriptor from the stream. Descriptor is preserved as read;
     * actual name remapping is applied when resolving the class for loading.
     */
    @Override
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        return super.readClassDescriptor();
    }

    /**
     * Resolve the class referenced by the stream descriptor, remapping legacy package
     * prefixes to the current namespace before loading the class.
     */
    @Override
    protected Class<?> resolveClass(ObjectStreamClass streamClass) throws IOException, ClassNotFoundException {
        String originalName = streamClass.getName();
        String remappedName = remapLegacyToNew(originalName);
        ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
        return Class.forName(remappedName, false, contextLoader);
    }

    /**
     * Resolve proxy interfaces, remapping any legacy interface names and attempting to
     * create a proxy class with the resulting interface types. Falls back to the
     * superclass implementation if proxy creation fails.
     */
    @Override
    public Class<?> resolveProxyClass(String[] interfaceNames) throws IOException, ClassNotFoundException {
        ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] resolvedInterfaces = new Class<?>[interfaceNames.length];
        for (int i = 0; i < interfaceNames.length; i++) {
            String remappedInterfaceName = remapLegacyToNew(interfaceNames[i]);
            resolvedInterfaces[i] = Class.forName(remappedInterfaceName, false, contextLoader);
        }
        try {
            return Proxy.getProxyClass(contextLoader, resolvedInterfaces);
        } catch (IllegalArgumentException e) {
            return super.resolveProxyClass(interfaceNames);
        }
    }

    /**
     * Translate a class name from the legacy namespace to the new namespace.
     * Names already in the new namespace are returned unchanged. Handles single-dimension
     * array descriptors that begin with "[L".
     */
    private static String remapLegacyToNew(String name) {
        if (name.startsWith(NEW_NAMESPACE_PREFIX) || name.startsWith("[L" + NEW_NAMESPACE_PREFIX)) {
            return name;
        }
        return name.replaceFirst("^(\\[L)?" + Pattern.quote(LEGACY_NAMESPACE_PREFIX),
                "$1" + Matcher.quoteReplacement(NEW_NAMESPACE_PREFIX));
    }
}