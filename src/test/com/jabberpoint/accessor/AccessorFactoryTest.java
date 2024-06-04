package com.jabberpoint.accessor;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccessorFactoryTest
{

  private AccessorFactory accessorFactory;
  private Presentation presentation;

  @BeforeEach
  void setUp()
  {
    presentation = new Presentation();
    accessorFactory = new AccessorFactory();
  }

  @Test
  void testCreateAssessorFactory_ShouldReturnDemoPresentation()
  {
    Accessor result = accessorFactory.createAccessor("Demo", presentation);
    assertInstanceOf(DemoPresentation.class, result);
  }

  @Test
  void testCreateAssessorFactory_ShouldReturnXMLAccessor()
  {
    Accessor result = accessorFactory.createAccessor("XML", presentation);
    assertTrue(result instanceof XMLAccessor);
  }

  @Test
void testCreateAccessor_nullInput_shouldReturnXMLAccessor() {
    Accessor result = accessorFactory.createAccessor(null, presentation);
    assertTrue(result instanceof XMLAccessor);
}

@Test
void testCreateAccessor_emptyStringInput_shouldReturnXMLAccessor() {
    Accessor result = accessorFactory.createAccessor("", presentation);
  assertInstanceOf(XMLAccessor.class, result);
}

@Test
void testCreateAccessor_unexpectedStringInput_shouldReturnXMLAccessor() {
    Accessor result = accessorFactory.createAccessor("unexpected", presentation);
  assertInstanceOf(XMLAccessor.class, result);
}
}
