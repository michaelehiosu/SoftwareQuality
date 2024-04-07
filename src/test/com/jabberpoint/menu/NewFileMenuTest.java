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

class NewFileMenuTest
{

    @Mock
    private Presentation mockPresentation;
    @Mock
    private Frame mockParent;

    private NewFileMenu newFileMenuUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp()
    {
        mockitoCloseable = openMocks(this);
        newFileMenuUnderTest = new NewFileMenu(mockPresentation, mockParent);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        mockitoCloseable.close();
    }

    @Test
    void testGetName()
    {
        assertEquals("New", newFileMenuUnderTest.getName());
    }

    @Test
    void testGetMenu()
    {
        assertNull(newFileMenuUnderTest.getMenu());
    }
}
