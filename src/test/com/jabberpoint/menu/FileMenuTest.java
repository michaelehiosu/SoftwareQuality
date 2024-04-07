package com.jabberpoint.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileMenuTest
{

    private FileMenu fileMenuUnderTest;

    @BeforeEach
    void setUp()
    {
        fileMenuUnderTest = new FileMenu();
    }

    @Test
    void testGetName()
    {
        assertEquals("File", fileMenuUnderTest.getName());
    }
}
