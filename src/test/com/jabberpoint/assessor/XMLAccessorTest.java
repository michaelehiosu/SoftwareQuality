package com.jabberpoint.assessor;

import com.jabberpoint.presentation.Presentation;
import com.jabberpoint.slides.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XMLAccessorTest
{
  private Presentation presentation;
  private XMLAccessor xMLAccessor;

  @BeforeEach
  void setUp()
  {
    this.presentation = new Presentation();
    this.xMLAccessor = new XMLAccessor();
  }

  @Test
  void testLoadFile_correctFileName_shouldNotThrowIOException()
  {
    assertDoesNotThrow(() -> {
      xMLAccessor.loadFile(new Presentation(), "test.xml");
    });
  }

  @Test
  void testLoadFile_incorrectFileName_shouldThrowIOException()
  {
    assertThrows(IOException.class,() -> {
      xMLAccessor.loadFile(new Presentation(), "tes.xml");
    });
  }


  @Test
  void testSaveFile_shouldNotThrowIOException()
  {
    assertDoesNotThrow(() -> {
      xMLAccessor.saveFile(presentation, "dump.xml");
    });
  }
}
