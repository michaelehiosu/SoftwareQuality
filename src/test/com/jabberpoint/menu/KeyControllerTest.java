package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;

public class KeyControllerTest {

    private Presentation mockPresentation;
    private KeyController keyControllerUnderTest;

    @BeforeEach
    void setUp() {
        mockPresentation = mock(Presentation.class);
        keyControllerUnderTest = new KeyController(mockPresentation);
    }

    @Test
    void testKeyPressed_nextSlide() {
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_PAGE_DOWN);

        keyControllerUnderTest.keyPressed(mockKeyEvent);

        verify(mockPresentation).nextSlide();
    }

    @Test
    void testKeyPressed_prevSlide() {
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        when(mockKeyEvent.getKeyCode()).thenReturn(KeyEvent.VK_PAGE_UP);

        keyControllerUnderTest.keyPressed(mockKeyEvent);

        verify(mockPresentation).prevSlide();
    }
}
