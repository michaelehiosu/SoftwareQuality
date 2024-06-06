package com.jabberpoint.menu;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class HelpMenuTest {

    @Test
    void testConstructor() {
        HelpMenu helpMenuUnderTest = new HelpMenu();
        assertNotNull(helpMenuUnderTest);
    }

    @Test
void testPerformAction_addsChildren() {
    HelpMenu helpMenuUnderTest = new HelpMenu();

    MenuActions child = mock(MenuActions.class);
    when(child.getName()).thenReturn("Test");

    helpMenuUnderTest.addChildren(child);

    MenuItem menuItem = mock(MenuItem.class);
    helpMenuUnderTest.performAction(menuItem);

    verify(child).performAction(any(MenuItem.class));

    assertEquals(1, helpMenuUnderTest.getChildren().size());
    assertEquals(child, helpMenuUnderTest.getChildren().get(0));
}
}
