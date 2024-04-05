package presentation;

import slides.BitmapItem;
import slides.Slide;

class DemoPresentation extends Accessor {
  public static final String DEMO_NAME = "Demonstration presentation";
  private Presentation presentation;

  @Override
  public void loadFile(Presentation presentation, String filename) {
    addPresentation(presentation);
    setPresentationTitle();
    createFirstSlide();
    createSecondSlide();
    createThirdSlide();
  }

  private void addPresentation(Presentation presentation) {
    this.presentation = presentation;
  }

  private void setPresentationTitle() {
    this.presentation.setTitle(DEMO_NAME);
  }

  private void createFirstSlide() {
    Slide slide = new Slide();
    slide.setTitle("MainProgram.JabberPoint");
    slide.appendText(1, "The Java Presentation.Presentation Tool");
    slide.appendText(2, "Copyright (c) 1996-2000: Ian Darwin");
    slide.appendText(2, "Copyright (c) 2000-now:");
    slide.appendText(2, "Gert Florijn andn Sylvia Stuurman");
    slide.appendText(4, "Starting MainProgram.JabberPoint without a filename");
    slide.appendText(4, "shows this presentation");
    slide.appendText(1, "Navigate:");
    slide.appendText(3, "Next slide: PgDn or Enter");
    slide.appendText(3, "Previous slide: PgUp or up-arrow");
    slide.appendText(3, "Quit: q or Q");
    presentation.appendSlide(slide);
  }


  private void createSecondSlide() {
    Slide slide = new Slide();
    slide.setTitle("Demonstration of levels and stijlen");
    slide.appendText(1, "Level 1");
    slide.appendText(2, "Level 2");
    slide.appendText(1, "Again level 1");
    slide.appendText(1, "Level 1 has style number 1");
    slide.appendText(2, "Level 2 has style number  2");
    slide.appendText(3, "This is how level 3 looks like");
    slide.appendText(4, "And this is level 4");
    presentation.appendSlide(slide);
  }

  private void createThirdSlide() {
    Slide slide = new Slide();
    slide.setTitle("The third slide");
    slide.appendText(1, "To open a new presentation,");
    slide.appendText(2, "use File->Open from the menu.");
    slide.appendText(1, " ");
    slide.appendText(1, "This is the end of the presentation.");
    BitmapItem bitmap = new BitmapItem(1, "MainProgram.JabberPoint.gif");
    slide.appendSlideItem(bitmap);
    presentation.appendSlide(slide);
  }

  @Override
  public void saveFile(Presentation presentation, String unusedFilename) throws IllegalStateException {
    throw new IllegalStateException("Save As->Demo! called");
  }
}
