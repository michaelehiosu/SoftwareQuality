package assessor;

import presentation.Presentation;
import slides.BitmapItem;
import slides.Slide;
import slides.SlideItem;
import slides.TextItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;


// Presentation.XMLAccessor, reads and writes XML files

public class XMLAccessor extends Accessor {
  protected static final String SHOWTITLE = "showtitle";
  protected static final String SLIDETITLE = "title";
  protected static final String SLIDE = "slide";
  protected static final String ITEM = "item";
  protected static final String LEVEL = "level";
  protected static final String KIND = "kind";
  protected static final String TEXT = "text";
  protected static final String IMAGE = "image";
  protected static final String PCE = "Parser Configuration Exception";
  protected static final String UNKNOWNTYPE = "Unknown Element type";
  protected static final String NFE = "Number Format Exception";
  private Presentation presentation;

  private String getTitle(Element element, String tagName) {
    NodeList titles = element.getElementsByTagName(tagName);
    return titles.item(0).getTextContent();

  }

  public void loadFile(Presentation presentation, String filename) {
    try {
      setPresentation(presentation);
      loadPresentationFile(filename);
    } catch (IOException iox) {
      System.err.println(iox);
    } catch (SAXException sax) {
      System.err.println(sax.getMessage());
    } catch (ParserConfigurationException pcx) {
      System.err.println(PCE);
    }
  }

  private void setPresentation(Presentation presentation) {
    this.presentation = presentation;
  }

  private void loadPresentationFile(String filename) throws ParserConfigurationException, SAXException, IOException {
    int slideNumber;
    int max;

    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document document = builder.parse(new File(filename));
    Element element = document.getDocumentElement();
    setPresentationTitle(element);


    NodeList slides = element.getElementsByTagName(SLIDE);
    max = slides.getLength();
    for (slideNumber = 0; slideNumber < max; slideNumber++) {
      loadSlideItems(slideNumber, slides);
    }
  }

  private void setPresentationTitle(Element element) {
    this.presentation.setTitle(getTitle(element, SHOWTITLE));
  }

  private void loadSlideItems(int slideNumber, NodeList slides) {
    int itemNumber;
    int maxItems;
    Element xmlSlide = (Element) slides.item(slideNumber);
    Slide slide = new Slide();
    slide.setTitle(getTitle(xmlSlide, SLIDETITLE));
    presentation.appendSlide(slide);

    NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
    maxItems = slideItems.getLength();
    for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
      Element item = (Element) slideItems.item(itemNumber);
      loadSlideItem(slide, item);
    }
  }

  protected void loadSlideItem(Slide slide, Element item) {
    int level = parseLevel(item);
    String type = parseType(item);
    createSlideItem(slide, level, type, item.getTextContent());
  }

  private int parseLevel(Element item) {
    int level = 1;
    NamedNodeMap attributes = item.getAttributes();
    String leveltext = attributes.getNamedItem(LEVEL).getTextContent();
    if (leveltext != null) {
      try {
        level = Integer.parseInt(leveltext);
      } catch (NumberFormatException x) {
        System.err.println(NFE);
      }
    }
    return level;
  }

  private String parseType(Element item) {
    NamedNodeMap attributes = item.getAttributes();
    return attributes.getNamedItem(KIND).getTextContent();
  }


  private void createSlideItem(Slide slide, int level, String type, String content) {
    switch (type) {
      case TEXT -> slide.appendSlideItem(new TextItem(level, content));
      case IMAGE -> slide.appendSlideItem(new BitmapItem(level, content));
      default -> System.err.println(UNKNOWNTYPE);
    }
  }


  public void saveFile(Presentation presentation, String filename) throws IOException {
    if (this.presentation == null) {
      setPresentation(presentation);
    }

    PrintWriter fileWriter = new PrintWriter(new FileWriter(filename));
    writeXMLHeader(fileWriter);
    writePresentationTitle(fileWriter, this.presentation.getTitle());
    writeSlides(fileWriter);
    writeXMLFooter(fileWriter);
    fileWriter.close();
  }

  private void writeXMLHeader(PrintWriter fileWriter) {
    fileWriter.println("<?xml version=\"1.0\"?>");
    fileWriter.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
    fileWriter.println("<presentation>");
  }

  private void writePresentationTitle(PrintWriter fileWriter, String title) {
    fileWriter.print("<showtitle>");
    fileWriter.print(title);
    fileWriter.println("</showtitle>");
  }

  private void writeSlides(PrintWriter fileWriter) {
    for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++) {
      Slide slide = presentation.getSlide(slideNumber);
      writeSlide(fileWriter, slide);
    }
  }

  private void writeSlide(PrintWriter fileWriter, Slide slide) {
    fileWriter.println("<slide>");
    fileWriter.println("<title>" + slide.getTitle() + "</title>");
    writeSlideItems(fileWriter, slide.getSlideItems());
    fileWriter.println("</slide>");
  }

  private void writeSlideItems(PrintWriter fileWriter, Vector<SlideItem> slideItems) {
    for (int itemNumber = 0; itemNumber < slideItems.size(); itemNumber++) {
      SlideItem slideItem = slideItems.elementAt(itemNumber);
      writeSlideItem(fileWriter, slideItem);
    }
  }

  private void writeSlideItem(PrintWriter fileWriter, SlideItem slideItem) {
    if (slideItem instanceof TextItem) {
      fileWriter.print("<item kind=\"text\" level=\"" + slideItem.getLevel() + "\">");
      fileWriter.print(((TextItem) slideItem).getText());
    } else if (slideItem instanceof BitmapItem) {
      fileWriter.print("<item kind=\"image\" level=\"" + slideItem.getLevel() + "\">");
      fileWriter.print(((BitmapItem) slideItem).getName());
    } else {
      System.out.println("Ignoring " + slideItem);
      return;
    }
    fileWriter.println("</item>");
  }

  private void writeXMLFooter(PrintWriter fileWriter) {
    fileWriter.println("</presentation>");
  }

}
