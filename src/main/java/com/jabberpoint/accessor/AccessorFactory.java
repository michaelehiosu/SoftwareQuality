package com.jabberpoint.accessor;

import com.jabberpoint.presentation.Presentation;

import java.util.Objects;

public class AccessorFactory
{
  public Accessor createAccessor(String string, Presentation presentation)
  {
    if (Objects.equals(string, "Demo"))
    {
      return new DemoPresentation(presentation);
    }
    else {
      return new XMLAccessor(presentation);
    }
  }

}
