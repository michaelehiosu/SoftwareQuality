package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class NextViewMenuTest
{

    @Mock
    private Presentation mockPresentation;
    @Mock
    private Frame mockParent;

    private NextViewMenu nextViewMenuUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp()
    {
        mockitoCloseable = openMocks(this);
        nextViewMenuUnderTest = new NextViewMenu(mockPresentation, mockParent);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        mockitoCloseable.close();
    }

    @Test
    void testGetName()
    {
        assertEquals("Next", nextViewMenuUnderTest.getName());
    }

    @Test
    void testGetMenu()
    {
        assertNull(nextViewMenuUnderTest.getMenu());
    }
}
