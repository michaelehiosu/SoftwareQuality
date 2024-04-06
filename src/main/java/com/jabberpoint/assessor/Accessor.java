package com.jabberpoint.assessor;

import com.jabberpoint.presentation.Presentation;

import java.io.IOException;

/**
 * An abstract class representing an accessor for loading and saving presentation files.
 */
public abstract class Accessor
{
  public abstract void loadFile(Presentation presentation, String filename) throws IOException;


  public abstract void saveFile(Presentation presentation, String filename) throws IOException;
}