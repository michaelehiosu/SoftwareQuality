package com.jabberpoint.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Menu;
import java.awt.MenuItem;

import static org.mockito.Mockito.*;

public class ViewMenuTest {

    private ViewMenu viewMenuUnderTest;

    @BeforeEach
    void setUp() {
        viewMenuUnderTest = new ViewMenu();
    }

    @Test
    void testPerformAction() {
        MenuItem mockMenuItem = mock(MenuItem.class);
        MenuActions mockMenuActions = mock(MenuActions.class);

        when(mockMenuActions.getName()).thenReturn("Test");

        viewMenuUnderTest.addChildren(mockMenuActions);
        viewMenuUnderTest.performAction(mockMenuItem);

        verify(mockMenuActions).performAction(any(MenuItem.class));
    }
    @Test
    void testGetName() {
        String name = viewMenuUnderTest.getName();

        Assertions.assertEquals("View", name);
    }

    @Test
    void testGetMenu() {
        Menu menu = viewMenuUnderTest.getMenu();

        Assertions.assertEquals("View", menu.getLabel());
    }
}
