package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.awt.Frame;
import java.awt.MenuItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class AboutHelpMenuTest
{

  @Mock
  private Presentation mockPresentation;
  @Mock
  private Frame mockParent;

  private AboutHelpMenu aboutHelpMenuUnderTest;

  private AutoCloseable mockitoCloseable;

  @BeforeEach
  void setUp()
  {
    mockitoCloseable = openMocks(this);
    aboutHelpMenuUnderTest = new AboutHelpMenu(mockPresentation, mockParent);
  }

  @AfterEach
  void tearDown() throws Exception
  {
    mockitoCloseable.close();
  }

  @Test
  void testPerformAction()
  {
    final MenuItem menuItem = mock(MenuItem.class);
    aboutHelpMenuUnderTest.performAction(menuItem);

    verify(menuItem).addActionListener(any());
  }


  @Test
  void testGetName()
  {
    assertEquals("About", aboutHelpMenuUnderTest.getName());
  }

  @Test
  void testGetMenu()
  {
    assertNull(aboutHelpMenuUnderTest.getMenu());
  }
}
