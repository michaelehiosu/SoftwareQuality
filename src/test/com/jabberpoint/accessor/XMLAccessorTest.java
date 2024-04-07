package com.jabberpoint.accessor;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class XMLAccessorTest
{
  private Presentation presentation;
  private XMLAccessor xMLAccessor;

  @BeforeEach
  void setUp()
  {
    this.presentation = new Presentation();
    this.xMLAccessor = new XMLAccessor(presentation);
  }

  @Test
  void testLoadFile_correctFileName_shouldNotThrowIOException()
  {
    assertDoesNotThrow(() -> {
      xMLAccessor.loadFile("test.xml");
    });
  }

  @Test
  void testLoadFile_incorrectFileName_shouldThrowIOException()
  {
    assertThrows(IOException.class, () -> {
      xMLAccessor.loadFile("tes.xml");
    });
  }


  @Test
  void testSaveFile_shouldNotThrowIOException()
  {
    assertDoesNotThrow(() -> {
      xMLAccessor.saveFile("dump.xml");
    });
  }
}
