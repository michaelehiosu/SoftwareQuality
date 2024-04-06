package com.jabberpoint.assessor;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


class DemoPresentationTest
{
  Presentation presentation;
  DemoPresentation demoPresentation;

  @BeforeEach
  void setUp()
  {
    presentation = new Presentation();
    demoPresentation = new DemoPresentation();
  }

  @Test
  void testLoadFile_ShouldNotThrowIOException()
  {
    assertDoesNotThrow(() -> {
      demoPresentation.loadFile(new Presentation(), "filename");
    });
  }

  @Test
  void testSaveFile_ShouldThrowIOException()
  {
    assertThrows(IOException.class, () -> {
      demoPresentation.saveFile(new Presentation(), "unusedFilename");
    });
  }
}
