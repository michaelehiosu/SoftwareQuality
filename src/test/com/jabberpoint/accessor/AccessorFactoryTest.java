package com.jabberpoint.accessor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccessorFactoryTest
{

  private AccessorFactory accessorFactory;

  @BeforeEach
  void setUp()
  {
    accessorFactory = new AccessorFactory();
  }

  @Test
  void testCreateAssessorFactory_ShouldReturnDemoPresentation()
  {
    Accessor result = accessorFactory.createAccessorFactory("Demo");
    assertTrue(result instanceof DemoPresentation);
  }

  @Test
  void testCreateAssessorFactory_ShouldReturnXMLAccessor()
  {
    Accessor result = accessorFactory.createAccessorFactory("XML");
    assertTrue(result instanceof XMLAccessor);
  }
}
