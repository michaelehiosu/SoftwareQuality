package com.jabberpoint.assessor;

import java.util.Objects;

public class AssessorFactory
{
  public Accessor createAssessorFactory(String string)
  {
    if (Objects.equals(string, "Demo"))
    {
      return new DemoPresentation();
    }
    else {
      return new XMLAccessor();
    }
  }
}
