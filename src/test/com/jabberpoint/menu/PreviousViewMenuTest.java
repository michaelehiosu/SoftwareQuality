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

class PreviousViewMenuTest
{

    @Mock
    private Presentation mockPresentation;
    @Mock
    private Frame mockParent;

    private PreviousViewMenu previousViewMenuUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() throws Exception
    {
        mockitoCloseable = openMocks(this);
        previousViewMenuUnderTest = new PreviousViewMenu(mockPresentation, mockParent);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        mockitoCloseable.close();
    }

    @Test
    void testGetName() throws Exception
    {
        assertEquals("Prev", previousViewMenuUnderTest.getName());
    }

    @Test
    void testGetMenu()
    {
        assertNull(previousViewMenuUnderTest.getMenu());
    }
}
