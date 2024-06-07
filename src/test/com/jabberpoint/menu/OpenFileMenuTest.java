package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.mockito.Mockito.*;

public class OpenFileMenuTest {

    private Presentation mockPresentation;
  private OpenFileMenu openFileMenuUnderTest;

    @BeforeEach
    void setUp() {
        mockPresentation = mock(Presentation.class);
      Frame mockFrame = mock(Frame.class);
        openFileMenuUnderTest = new OpenFileMenu(mockPresentation, mockFrame);
    }

    @Test
    void testPerformAction() {
        MenuItem mockMenuItem = mock(MenuItem.class);
        ActionListener[] actionListeners = new ActionListener[1];

        doAnswer(invocation -> {
            actionListeners[0] = invocation.getArgument(0);
            return null;
        }).when(mockMenuItem).addActionListener(any(ActionListener.class));

        openFileMenuUnderTest.performAction(mockMenuItem);

        actionListeners[0].actionPerformed(new ActionEvent(mockMenuItem, ActionEvent.ACTION_PERFORMED, ""));

        verify(mockPresentation).clear();
    }

    @Test
    void testGetName() {
        String name = openFileMenuUnderTest.getName();

        Assertions.assertEquals("Open", name);
    }

    @Test
    void testGetMenu() {
        Menu menu = openFileMenuUnderTest.getMenu();

        Assertions.assertNull(menu);
    }
}
