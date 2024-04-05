package presentation;

import slides.Slide;

import java.util.ArrayList;
import java.util.List;

/**
 * Presentation maintains the slides in the presentation.
 * There is only instance of this class.
 */

public class Presentation {
  private String showTitle;
  private ArrayList<Slide> showList;
  private int currentSlideNumber;
  private List<PresentationObserver> presentationObservers;

  public Presentation() {
    this.presentationObservers = new ArrayList<>();
    clear();
  }

  public Presentation(PresentationObserver observer) {
    setShowView(observer);
    clear();
  }

  public int getSize() {
    return showList.size();
  }

  public String getTitle() {
    return showTitle;
  }

  public void setTitle(String title) {
    showTitle = title;
  }

  public void setShowView(PresentationObserver observer) {
    this.presentationObservers.add(observer);
  }


  public int getSlideNumber() {
    return currentSlideNumber;
  }


  public void setSlideNumber(int number) {
    currentSlideNumber = number;
    updateObservers();
  }

  private void updateObservers() {
    for (PresentationObserver observer : presentationObservers) {
      observer.update(getCurrentSlide());
    }
  }


  public void prevSlide() {
    if (currentSlideNumber > 0) {
      setSlideNumber(currentSlideNumber - 1);
    }
  }


  public void nextSlide() {
    if (currentSlideNumber < (showList.size() - 1)) {
      setSlideNumber(currentSlideNumber + 1);
    }
  }


  public void clear() {
    showList = new ArrayList<Slide>();
    setSlideNumber(-1);
  }


  public void appendSlide(Slide slide) {
    showList.add(slide);
  }


  public Slide getSlide(int number) {
    if (number < 0 || number >= getSize()) {
      return null;
    }
    return showList.get(number);
  }


  public Slide getCurrentSlide() {
    return getSlide(currentSlideNumber);
  }

  public void exit(int status) {
    System.exit(status);
  }
}
