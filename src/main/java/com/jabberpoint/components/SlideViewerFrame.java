package com.jabberpoint.components;

import com.jabberpoint.menu.KeyController;
import com.jabberpoint.menu.MenuController;
import com.jabberpoint.presentation.Presentation;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// The application window for a slideviewcomponent

public class SlideViewerFrame extends JFrame
{
  public static final int WIDTH = 1200;
  public static final int HEIGHT = 800;
  private static final long serialVersionUID = 3227L;
  private static final String JABTITLE = "Jabberpoint 1.6 - OU";

  public SlideViewerFrame(String title, Presentation presentation)
  {
    super(title);
    SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
    presentation.setShowView(slideViewerComponent);
    setupWindow(slideViewerComponent, presentation);
  }


  public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation)
  {
    setTitle(JABTITLE);
    addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      {
        System.exit(0);
      }
    });
    getContentPane().add(slideViewerComponent);
    addKeyListener(new KeyController(presentation));
    setMenuBar(new MenuController(this, presentation));
    setSize(new Dimension(WIDTH, HEIGHT));
    setVisible(true);
  }
}
