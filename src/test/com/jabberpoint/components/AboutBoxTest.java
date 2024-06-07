package com.jabberpoint.components;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Frame;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AboutBoxTest {

    private Frame frame;

    @BeforeEach
    void setUp() {
        frame = new Frame();
    }

    @AfterEach
    void tearDown() {
        frame.dispose();
    }

    @Test
    void testShowAboutBox() {
        assertDoesNotThrow(() -> AboutBox.show(frame));
    }
}
