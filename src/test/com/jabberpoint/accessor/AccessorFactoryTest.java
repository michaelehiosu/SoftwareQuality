package com.jabberpoint.accessor;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    assertTrue(result instanceof DemoPresentation);
  }

  @Test
  void testCreateAssessorFactory_ShouldReturnXMLAccessor()
  {
    Accessor result = accessorFactory.createAccessor("XML", presentation);
    assertTrue(result instanceof XMLAccessor);
  }
}
