package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.MockitoAnnotations.openMocks;

class SaveFileMenuTest
{

    @Mock
    private Presentation mockPresentation;
    @Mock
    private Frame mockParent;

    private SaveFileMenu saveFileMenuUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() throws Exception
    {
        mockitoCloseable = openMocks(this);
        saveFileMenuUnderTest = new SaveFileMenu(mockPresentation, mockParent);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        mockitoCloseable.close();
    }

    @Test
    void testGetName() throws Exception
    {
        assertEquals("Save", saveFileMenuUnderTest.getName());
    }

    @Test
    void testGetMenu()
    {
        assertNull(saveFileMenuUnderTest.getMenu());
    }
}
