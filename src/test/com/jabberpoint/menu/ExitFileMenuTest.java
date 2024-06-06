package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class ExitFileMenuTest
{

  @Mock
  private Presentation mockPresentation;
  @Mock
  private Frame mockParent;

  private ExitFileMenu exitFileMenuUnderTest;

  private AutoCloseable mockitoCloseable;

  @BeforeEach
  void setUp()
  {
    mockitoCloseable = openMocks(this);
    exitFileMenuUnderTest = new ExitFileMenu(mockPresentation, mockParent);
  }

  @AfterEach
  void tearDown() throws Exception
  {
    mockitoCloseable.close();
  }

  @Test
  void testPerformAction()
  {
    final MenuItem menuItem = mock(MenuItem.class); // Mock
    exitFileMenuUnderTest.performAction(menuItem);

    verify(menuItem).addActionListener(any());
  }

  @Test
  void testGetName()
  {
    assertEquals("Exit", exitFileMenuUnderTest.getName());
  }

  @Test
  void testGetMenu()
  {
    assertNull(exitFileMenuUnderTest.getMenu());
  }
  @Test
  void testConstructor() {
    Assertions.assertNotNull(exitFileMenuUnderTest);
  }

  @Test
  void testPerformAction_callsExit() {
    final MenuItem menuItem = mock(MenuItem.class); // Mock
    exitFileMenuUnderTest.performAction(menuItem);

    ArgumentCaptor<ActionListener> argumentCaptor = ArgumentCaptor.forClass(ActionListener.class);
    verify(menuItem).addActionListener(argumentCaptor.capture());

    ActionListener actionListener = argumentCaptor.getValue();
    actionListener.actionPerformed(mock(ActionEvent.class));

    verify(mockPresentation).exit(0);
  }
}
