package com.jabberpoint.presentation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

import com.jabberpoint.slides.Slide;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class PresentationTest {

  @Test
  void testGetSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new Presentation()).getSize());
  }


  @Test
  void testSetShowView() {

    // Arrange and Act
    (new Presentation()).addObserver(mock(PresentationObserver.class));
  }


  @Test
  void testSetSlideNumber() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.setSlideNumber(10);

    // Assert
    assertNull(presentation.getCurrentSlide());
  }


  @Test
  void testPrevSlide() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.prevSlide();

    // Assert that nothing has changed
    assertEquals(0, presentation.getSize());
  }


  @Test
  void testNextSlide() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.nextSlide();

    // Assert that nothing has changed
    assertEquals(0, presentation.getSize());
  }


  @Test
  void testNextSlide2() {
    // Arrange
    Presentation presentation = new Presentation();
    presentation.appendSlide(new Slide());

    // Act
    presentation.nextSlide();

    // Assert
    assertEquals(0, presentation.getSlideNumber());
  }


  @Test
  void testClear() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.clear();

    // Assert
    assertNull(presentation.getCurrentSlide());
    assertEquals(0, presentation.getSize());
  }


  @Test
  void testAppendSlide() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.appendSlide(new Slide());

    // Assert
    assertEquals(1, presentation.getSize());
  }


  @Test
  void testGetSlide() {
    // Arrange, Act and Assert
    assertNull((new Presentation()).getSlide(10));
  }


  @Test
  void testGetSlide2() {
    // Arrange
    Presentation presentation = new Presentation();
    presentation.appendSlide(new Slide());
    presentation.appendSlide(new Slide());
    presentation.appendSlide(new Slide());
    presentation.appendSlide(new Slide());
    presentation.appendSlide(new Slide());
    presentation.appendSlide(new Slide());
    presentation.appendSlide(new Slide());
    presentation.appendSlide(new Slide());
    presentation.appendSlide(new Slide());
    presentation.appendSlide(new Slide());
    Slide slide = new Slide();
    presentation.appendSlide(slide);

    // Act and Assert
    assertSame(slide, presentation.getSlide(10));
  }


  @Test
  void testGetCurrentSlide() {
    // Arrange, Act and Assert
    assertNull((new Presentation()).getCurrentSlide());
  }


  @Test
  void testExit() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      // Arrange
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      Presentation presentation = new Presentation();

      // Act
      presentation.exit(1);

      // Assert that nothing has changed
      verify(runtime).exit(eq(1));
      mockRuntime.verify(Runtime::getRuntime);
      assertEquals(0, presentation.getSize());
    }
  }


  @Test
  void testGettersAndSetters() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.setTitle("Dr");
    int actualSlideNumber = presentation.getSlideNumber();

    // Assert that nothing has changed
    assertEquals("Dr", presentation.getTitle());
    assertEquals(-1, actualSlideNumber);
  }


  @Test
  void testNewPresentation() {
    // Arrange and Act
    Presentation actualPresentation = new Presentation();

    // Assert
    assertNull(actualPresentation.getCurrentSlide());
    assertEquals(0, actualPresentation.getSize());
  }

}
