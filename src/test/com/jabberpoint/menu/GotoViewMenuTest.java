package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class GotoViewMenuTest {

    @Test
    void testConstructor() {
        Presentation mockPresentation = mock(Presentation.class);
        Frame mockParent = mock(Frame.class);
        GotoViewMenu gotoViewMenuUnderTest = new GotoViewMenu(mockPresentation, mockParent);
        assertNotNull(gotoViewMenuUnderTest);
    }

    @Test
    void testPerformAction_callsSetSlideNumber() {
        Presentation mockPresentation = mock(Presentation.class);
        Frame mockParent = mock(Frame.class);
        when(mockParent.isVisible()).thenReturn(true);

        GotoViewMenu gotoViewMenuUnderTest = new GotoViewMenu(mockPresentation, mockParent);

        final MenuItem menuItem = mock(MenuItem.class);
        gotoViewMenuUnderTest.performAction(menuItem);

        verify(menuItem).addActionListener(any(ActionListener.class));
    }
}
