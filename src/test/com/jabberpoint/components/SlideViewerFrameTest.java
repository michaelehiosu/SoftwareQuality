//package com.jabberpoint.components;
//
//import com.jabberpoint.presentation.Presentation;
//
//import java.awt.HeadlessException;
//import javax.swing.JFrame;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//class SlideViewerFrameTest {
//  /**
//   * Method under test:
//   * {@link SlideViewerFrame#SlideViewerFrame(String, Presentation)}
//   */
//  @Test
//  @Disabled("TODO: Complete this test")
//  void testNewSlideViewerFrame() {
//    // TODO: Diffblue Cover was only able to create a partial test for this method:
//    //   Reason: No inputs found that don't throw a trivial exception.
//    //   Diffblue Cover tried to run the arrange/act section, but the method under
//    //   test threw
//    //   java.awt.HeadlessException
//    //       at java.desktop/java.awt.GraphicsEnvironment.checkHeadless(GraphicsEnvironment.java:166)
//    //       at java.desktop/java.awt.Window.<init>(Window.java:553)
//    //       at java.desktop/java.awt.Frame.<init>(Frame.java:428)
//    //       at java.desktop/javax.swing.JFrame.<init>(JFrame.java:224)
//    //       at com.jabberpoint.components.SlideViewerFrame.<init>(SlideViewerFrame.java:23)
//    //   See https://diff.blue/R013 to resolve this issue.
//
//    // Arrange and Act
//    new SlideViewerFrame("Dr", new Presentation());
//
//  }
//
//  /**
//   * Method under test:
//   * {@link SlideViewerFrame#setupWindow(SlideViewerComponent, Presentation)}
//   */
//  @Test
//  @Disabled("TODO: Complete this test")
//  void testSetupWindow() throws HeadlessException {
//    // TODO: Diffblue Cover was only able to create a partial test for this method:
//    //   Reason: No inputs found that don't throw a trivial exception.
//    //   Diffblue Cover tried to run the arrange/act section, but the method under
//    //   test threw
//    //   java.awt.HeadlessException
//    //       at java.desktop/java.awt.GraphicsEnvironment.checkHeadless(GraphicsEnvironment.java:166)
//    //       at java.desktop/java.awt.Window.<init>(Window.java:553)
//    //       at java.desktop/java.awt.Frame.<init>(Frame.java:428)
//    //       at java.desktop/javax.swing.JFrame.<init>(JFrame.java:224)
//    //       at com.jabberpoint.components.SlideViewerFrame.<init>(SlideViewerFrame.java:23)
//    //   See https://diff.blue/R013 to resolve this issue.
//
//    // Arrange
//    SlideViewerFrame slideViewerFrame = new SlideViewerFrame("Dr", new Presentation());
//    Presentation presentation = new Presentation();
//    SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, new JFrame());
//
//    // Act
//    slideViewerFrame.setupWindow(slideViewerComponent, new Presentation());
//  }
//}
