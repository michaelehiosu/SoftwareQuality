package com.jabberpoint.accessor;

import com.jabberpoint.presentation.Presentation;

import java.io.IOException;

/**
 * An abstract class representing an accessor for loading and saving presentation files.
 */

public abstract class Accessor
{
  protected Presentation presentation;

  public Accessor(Presentation presentation)
  {
    this.presentation = presentation;
  }

  public abstract void loadFile(String filename) throws IOException;


  public abstract void saveFile(String filename) throws IOException;
}
