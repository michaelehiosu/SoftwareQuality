package com.jabberpoint.menu;

import com.jabberpoint.components.AboutBox;
import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

class AboutHelpMenuTest
{

    @Mock
    private Presentation mockPresentation;
    @Mock
    private Frame mockParent;

    private AboutHelpMenu aboutHelpMenuUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp()
    {
        mockitoCloseable = openMocks(this);
        aboutHelpMenuUnderTest = new AboutHelpMenu(mockPresentation, mockParent);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        mockitoCloseable.close();
    }

  @Test
  void testPerformAction() {
    // Setup
    final MenuItem menuItem = mock(MenuItem.class); // Mock the MenuItem object

    // Run the test
    aboutHelpMenuUnderTest.performAction(menuItem);

    // Verify the results
    verify(menuItem).addActionListener(any()); // Use Mockito's any() method to match any ActionListener instance
  }


  @Test
    void testGetName()
    {
        assertEquals("About", aboutHelpMenuUnderTest.getName());
    }

    @Test
    void testGetMenu()
    {
        assertNull(aboutHelpMenuUnderTest.getMenu());
    }
}
