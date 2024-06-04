package com.jabberpoint.components;

import com.jabberpoint.presentation.Presentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SlideViewerFrameTest {

    private Presentation presentation;
    private SlideViewerFrame slideViewerFrame;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        slideViewerFrame = new SlideViewerFrame("Test", presentation);
    }

    @AfterEach
    void tearDown() {
        slideViewerFrame.dispose();
    }

    @Test
    void testSetupWindow() {
        assertDoesNotThrow(() -> slideViewerFrame.setupWindow(new SlideViewerComponent(presentation, slideViewerFrame), presentation));
    }
}
