package com.jabberpoint.components;

import com.jabberpoint.presentation.Presentation;
import com.jabberpoint.slides.Slide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.swing.JFrame;
import java.awt.Dimension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class SlideViewerComponentTest
{

  @Mock
  private Presentation mockPresentation;
  @Mock
  private JFrame mockFrame;

  private SlideViewerComponent slideViewerComponentUnderTest;

  private AutoCloseable mockitoCloseable;

  @BeforeEach
  void setUp()
  {
    mockitoCloseable = openMocks(this);
    slideViewerComponentUnderTest = new SlideViewerComponent(mockPresentation, mockFrame);
  }

  @AfterEach
  void tearDown() throws Exception
  {
    mockitoCloseable.close();
  }

  @Test
  void testGetPreferredSize()
  {
    final Dimension expectedResult = new Dimension(1200, 800);
    final Dimension result = slideViewerComponentUnderTest.getPreferredSize();

    assertEquals(expectedResult, result);
  }

  @Test
  void testUpdate()
  {
    final Slide data = new Slide();
    data.setTitle("newTitle");

    when(mockPresentation.getTitle()).thenReturn("title");
    slideViewerComponentUnderTest.update(data);
    verify(mockFrame).setTitle("title");
  }

}
