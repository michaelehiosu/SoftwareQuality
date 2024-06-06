package com.jabberpoint.menu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Menu;
import java.awt.MenuItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.MockitoAnnotations.openMocks;

class FileMenuTest {

    private FileMenu fileMenuUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
        fileMenuUnderTest = new FileMenu();
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testConstructor() {
        assertNotNull(fileMenuUnderTest);
    }

    @Test
    void testPerformAction() {
        final MenuItem menuItem = new MenuItem("Test");

        MenuActions child = new MenuActions() {
            @Override
            public void performAction(MenuItem menuItem) {
                fileMenuUnderTest.getMenu().add(menuItem);
            }

            @Override
            public String getName() {
                return "Test Child";
            }

            @Override
            public Menu getMenu() {
                return null;
            }
        };

        fileMenuUnderTest.addChildren(child);

        fileMenuUnderTest.performAction(menuItem);

        Menu menu = fileMenuUnderTest.getMenu();
        assertEquals(1, menu.getItemCount());
        assertEquals(child.getName(), menu.getItem(0).getLabel());
    }
    @Test
    void testGetMenu() {
        Menu menu = fileMenuUnderTest.getMenu();
        assertNotNull(menu);
        assertEquals("File", menu.getLabel());
    }

    @Test
    void testGetName() {
        assertEquals("File", fileMenuUnderTest.getName());
    }
}
