package com.jabberpoint.components;

import com.jabberpoint.presentation.Presentation;
import com.jabberpoint.slides.Slide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class SlideViewerComponentTest {

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
  void tearDown() throws Exception {
    mockitoCloseable.close();
  }

  @Test
  void testGetPreferredSize()
  {
    // Setup
    final Dimension expectedResult = new Dimension(1200, 800);

    // Run the test
    final Dimension result = slideViewerComponentUnderTest.getPreferredSize();

    // Verify the results
    assertEquals(expectedResult, result);
  }

  @Test
  void testUpdate()
  {
    // Setup
    final Slide data = new Slide();
    data.setTitle("newTitle");

    when(mockPresentation.getTitle()).thenReturn("title");

    // Run the test
    slideViewerComponentUnderTest.update(data);

    // Verify the results
    verify(mockFrame).setTitle("title");
  }

}
