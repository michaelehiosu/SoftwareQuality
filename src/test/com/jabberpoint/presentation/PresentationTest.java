package com.jabberpoint.presentation;

import com.jabberpoint.slides.Slide;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

class PresentationTest
{

  @Test
  void testGetSize()
  {
    assertEquals(0, (new Presentation()).getSize());
  }


  @Test
  void testSetShowView()
  {
    (new Presentation()).addObserver(mock(PresentationObserver.class));
  }


  @Test
  void testSetSlideNumber()
  {
    Presentation presentation = new Presentation();
    presentation.setSlideNumber(10);
    assertNull(presentation.getCurrentSlide());
  }


  @Test
  void testPrevSlide()
  {
    Presentation presentation = new Presentation();
    presentation.prevSlide();

    assertEquals(0, presentation.getSize());
  }


  @Test
  void testNextSlide()
  {
    Presentation presentation = new Presentation();
    presentation.nextSlide();

    assertEquals(0, presentation.getSize());
  }


  @Test
  void testNextSlide2()
  {
    Presentation presentation = new Presentation();
    presentation.appendSlide(new Slide());

    presentation.nextSlide();
    assertEquals(0, presentation.getSlideNumber());
  }


  @Test
  void testClear()
  {
    Presentation presentation = new Presentation();
    presentation.clear();

    assertNull(presentation.getCurrentSlide());
    assertEquals(0, presentation.getSize());
  }


  @Test
  void testAppendSlide()
  {
    Presentation presentation = new Presentation();
    presentation.appendSlide(new Slide());

    assertEquals(1, presentation.getSize());
  }


  @Test
  void testGetSlide()
  {
    assertNull((new Presentation()).getSlide(10));
  }


  @Test
  void testGetSlide2()
  {
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

    assertSame(slide, presentation.getSlide(10));
  }


  @Test
  void testGetCurrentSlide()
  {
    assertNull((new Presentation()).getCurrentSlide());
  }


  @Test
  void testExit()
  {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class))
    {
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      Presentation presentation = new Presentation();

      presentation.exit(1);

      verify(runtime).exit(eq(1));
      mockRuntime.verify(Runtime::getRuntime);
      assertEquals(0, presentation.getSize());
    }
  }


  @Test
  void testGettersAndSetters()
  {
    Presentation presentation = new Presentation();

    presentation.setTitle("Dr");
    int actualSlideNumber = presentation.getSlideNumber();

    assertEquals("Dr", presentation.getTitle());
    assertEquals(-1, actualSlideNumber);
  }


  @Test
  void testNewPresentation()
  {
    Presentation actualPresentation = new Presentation();

    assertNull(actualPresentation.getCurrentSlide());
    assertEquals(0, actualPresentation.getSize());
  }

}
