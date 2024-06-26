package com.jabberpoint.menu;

import com.jabberpoint.presentation.Presentation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter
{
  private final Presentation presentation;
  public KeyController(Presentation presentation)
  {
    this.presentation = presentation;
  }

  public void keyPressed(KeyEvent keyEvent)
  {
    switch (keyEvent.getKeyCode())
    {
      case KeyEvent.VK_PAGE_DOWN:
      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_ENTER:
      case '+':
        presentation.nextSlide();
        break;
      case KeyEvent.VK_PAGE_UP:
      case KeyEvent.VK_UP:
      case '-':
        presentation.prevSlide();
        break;
      case 'q':
      case 'Q':
        System.exit(0);
        break;
      default:
        break;
    }
  }
}
