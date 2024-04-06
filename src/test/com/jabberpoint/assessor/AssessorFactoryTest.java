package com.jabberpoint.assessor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssessorFactoryTest
{

  private AssessorFactory assessorFactory;

  @BeforeEach
  void setUp()
  {
    assessorFactory = new AssessorFactory();
  }

  @Test
  void testCreateAssessorFactory_ShouldReturnDemoPresentation()
  {
    Accessor result = assessorFactory.createAssessorFactory("Demo");
    assertTrue(result instanceof DemoPresentation);
  }

  @Test
  void testCreateAssessorFactory_ShouldReturnXMLAccessor()
  {
    Accessor result = assessorFactory.createAssessorFactory("XML");
    assertTrue(result instanceof XMLAccessor);
  }
}
