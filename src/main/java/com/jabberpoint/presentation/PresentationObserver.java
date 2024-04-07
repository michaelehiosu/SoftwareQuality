package com.jabberpoint.presentation;

import com.jabberpoint.slides.Slide;

public interface PresentationObserver
{
  void update(Slide slide);
}
