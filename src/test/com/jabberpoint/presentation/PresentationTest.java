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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class PresentationTest {
  /**
   * Method under test: {@link Presentation#getSize()}
   */
  @Test
  void testGetSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new Presentation()).getSize());
  }

  /**
   * Method under test: {@link Presentation#setShowView(PresentationObserver)}
   */
  @Test
  void testSetShowView() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new Presentation()).setShowView(mock(PresentationObserver.class));
  }

  /**
   * Method under test: {@link Presentation#setSlideNumber(int)}
   */
  @Test
  void testSetSlideNumber() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.setSlideNumber(10);

    // Assert
    assertNull(presentation.getCurrentSlide());
  }

  /**
   * Method under test: {@link Presentation#prevSlide()}
   */
  @Test
  void testPrevSlide() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.prevSlide();

    // Assert that nothing has changed
    assertEquals(0, presentation.getSize());
  }

  /**
   * Method under test: {@link Presentation#nextSlide()}
   */
  @Test
  void testNextSlide() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.nextSlide();

    // Assert that nothing has changed
    assertEquals(0, presentation.getSize());
  }

  /**
   * Method under test: {@link Presentation#nextSlide()}
   */
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

  /**
   * Method under test: {@link Presentation#clear()}
   */
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

  /**
   * Method under test: {@link Presentation#appendSlide(Slide)}
   */
  @Test
  void testAppendSlide() {
    // Arrange
    Presentation presentation = new Presentation();

    // Act
    presentation.appendSlide(new Slide());

    // Assert
    assertEquals(1, presentation.getSize());
  }

  /**
   * Method under test: {@link Presentation#getSlide(int)}
   */
  @Test
  void testGetSlide() {
    // Arrange, Act and Assert
    assertNull((new Presentation()).getSlide(10));
  }

  /**
   * Method under test: {@link Presentation#getSlide(int)}
   */
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

  /**
   * Method under test: {@link Presentation#getCurrentSlide()}
   */
  @Test
  void testGetCurrentSlide() {
    // Arrange, Act and Assert
    assertNull((new Presentation()).getCurrentSlide());
  }

  /**
   * Method under test: {@link Presentation#exit(int)}
   */
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

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link Presentation#setTitle(String)}
   *   <li>{@link Presentation#getSlideNumber()}
   *   <li>{@link Presentation#getTitle()}
   * </ul>
   */
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

  /**
   * Method under test: {@link Presentation#Presentation()}
   */
  @Test
  void testNewPresentation() {
    // Arrange and Act
    Presentation actualPresentation = new Presentation();

    // Assert
    assertNull(actualPresentation.getCurrentSlide());
    assertEquals(0, actualPresentation.getSize());
  }

  /**
   * Method under test: {@link Presentation#Presentation(PresentationObserver)}
   */
//  @Test
//  @Disabled("TODO")
//  void testNewPresentation2() {
//    //   java.lang.NullPointerException: Cannot invoke "java.util.Collection.add(Object)" because "that" is null
//    //       at com.jabberpoint.presentation.Presentation.setShowView(Presentation.java:49)
//    //       at com.jabberpoint.presentation.Presentation.<init>(Presentation.java:28)
//    //   See https://diff.blue/R013 to resolve this issue.
//
//    // Arrange and Act
//    new Presentation(mock(PresentationObserver.class));
//  }
}
