package org.finos.fluxnova.bpm.quarkus.engine.test.lookup;

import io.quarkus.test.QuarkusExtensionTest;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Specializes;
import jakarta.enterprise.inject.spi.DefinitionException;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.fail;

public class UnsupportedSpecializationTest {

  @RegisterExtension
  static final QuarkusExtensionTest unitTest = new QuarkusExtensionTest()
      .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
          .addClasses(TestBean.class, SpecializedTestBean.class))
      .setExpectedException(DefinitionException.class);

  @Test
  public void shouldRejectSpecialization() {
    fail("CDI Full specialization must be rejected during augmentation");
  }

  @Dependent
  public static class TestBean {
  }

  @Dependent
  @Specializes
  public static class SpecializedTestBean extends TestBean {
  }

}
