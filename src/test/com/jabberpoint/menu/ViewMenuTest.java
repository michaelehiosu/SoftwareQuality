package com.jabberpoint.menu;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ViewMenuTest {

  private ViewMenu viewMenu;

  @Before
  public void setUp() {
    viewMenu = new ViewMenu();
  }

  @Test
  public void testAddChildren() {
    // Create a mock MenuActions instance
    MenuActions child = mock(MenuActions.class);

    // Add the mock child to the viewMenu
    viewMenu.addChildren(child);

    // Check if the child was added successfully
    List<MenuActions> children = viewMenu.getChildren();
    assertEquals(1, children.size());
    assertEquals(child, children.get(0));
  }

  @Test
  public void testPerformAction() {
    // Create a mock MenuItem
    MenuItem menuItem = mock(MenuItem.class);

    // Create a mock MenuActions instance
    MenuActions child = mock(MenuActions.class);
    when(child.getName()).thenReturn("Child");

    // Add the mock child to the viewMenu
    viewMenu.addChildren(child);

    // Call performAction method
    viewMenu.performAction(menuItem);

    // Verify that child's performAction method was called with any MenuItem
    verify(child).performAction(any(MenuItem.class));
  }

  @Test
  public void testGetName() {
    assertEquals("View", viewMenu.getName());
  }

  @Test
  public void testMkMenuItem() {
    MenuItem menuItem = viewMenu.mkMenuItem("Test");
    assertEquals("Test", menuItem.getLabel());
    assertEquals(new MenuShortcut('T'), menuItem.getShortcut());
  }

  @Test
  public void testGetMenu() {
    Menu menu = viewMenu.getMenu();
    assertEquals("View", menu.getLabel());
  }
}
