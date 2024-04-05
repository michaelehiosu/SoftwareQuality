package presentation;

import slides.Slide;

public interface PresentationObserver {
  void update(Slide data);
}
