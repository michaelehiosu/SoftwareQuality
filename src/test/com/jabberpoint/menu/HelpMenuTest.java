package com.jabberpoint.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class HelpMenuTest
{

    private HelpMenu helpMenuUnderTest;

    @BeforeEach
    void setUp()
    {
        helpMenuUnderTest = new HelpMenu();
    }

    @Test
    void testGetName()
    {
        assertEquals("Help", helpMenuUnderTest.getName());
    }

}
