package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.awt.*;

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
        // Setup
        final MenuItem menuItem = mock(MenuItem.class); // Mock
        // Run the test
        exitFileMenuUnderTest.performAction(menuItem);

        // Verify the results
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
}
