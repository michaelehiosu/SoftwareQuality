package com.jabberpoint.menu;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.util.List;

import com.jabberpoint.presentation.Presentation;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ViewMenuTest {

  private ViewMenu viewMenu;
  private NextViewMenu nextViewMenu;
  private Frame frame;


  @Before
  public void setUp() {
    viewMenu = new ViewMenu();
    nextViewMenu = new NextViewMenu(new Presentation(), frame);

  }

  @Test
  public void testAddChildren_shouldAddSuccessfully() {
    viewMenu.addChildren(nextViewMenu);
    List<MenuActions> children = viewMenu.getChildren();
    assertEquals(1, children.size());
  }

  @Test
  public void testPerformAction() {
    MenuItem menuItem = mock(MenuItem.class);

    MenuActions child = mock(MenuActions.class);
    when(child.getName()).thenReturn("Child");

    viewMenu.addChildren(child);
    viewMenu.performAction(menuItem);
    verify(child).performAction(any(MenuItem.class));
  }

  @Test
  public void testGetName() {
    assertEquals("View", viewMenu.getName());
  }


  @Test
  public void testMakeMenuItem() {
    MenuItem menuItem = viewMenu.makeMenuItem("Test");
    assertEquals("Test", menuItem.getLabel());
  }

  @Test
  public void testGetMenu() {
    Menu menu = viewMenu.getMenu();
    assertEquals("View", menu.getLabel());
  }

}
