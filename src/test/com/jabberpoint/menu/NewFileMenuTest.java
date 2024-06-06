package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.mockito.Mockito.*;

public class NewFileMenuTest {

    private Presentation mockPresentation;
  private NewFileMenu newFileMenuUnderTest;

    @BeforeEach
    void setUp() {
        mockPresentation = mock(Presentation.class);
        Frame mockFrame = mock(Frame.class);
        newFileMenuUnderTest = new NewFileMenu(mockPresentation, mockFrame);
    }

    @Test
    void testPerformAction() {
        MenuItem mockMenuItem = mock(MenuItem.class);
        ActionListener[] actionListeners = new ActionListener[1];

        doAnswer(invocation -> {
            actionListeners[0] = invocation.getArgument(0);
            return null;
        }).when(mockMenuItem).addActionListener(any(ActionListener.class));

        newFileMenuUnderTest.performAction(mockMenuItem);

        actionListeners[0].actionPerformed(new ActionEvent(mockMenuItem, ActionEvent.ACTION_PERFORMED, ""));

        verify(mockPresentation).clear();
    }

    @Test
    void testGetName() {
        String name = newFileMenuUnderTest.getName();

        Assertions.assertEquals("New", name);
    }

    @Test
    void testGetMenu() {
        Menu menu = newFileMenuUnderTest.getMenu();

        Assertions.assertNull(menu);
    }
}
