package slides;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;


public class BitmapItem extends SlideItem {
  protected static final String FILE = "File ";
  protected static final String NOTFOUND = " not found";
  private final String imageName;
  private BufferedImage bufferedImage;


  public BitmapItem(int level, String imageName) {
    super(level);
    this.imageName = imageName;
    setBufferedImage();
  }

  public BitmapItem() {
    this(0, null);
  }

  private void setBufferedImage() {
    try {
      this.bufferedImage = ImageIO.read(new File(imageName));
    } catch (IOException e) {
      System.err.println(FILE + imageName + NOTFOUND);
    }

  }

  public String getName() {
    return this.imageName;
  }


  @Override
  public Rectangle getBoundingBox(Graphics graphics, ImageObserver imageObserver, float scale, Style style) {
    return new Rectangle((int) (style.indent * scale), 0, (int) (bufferedImage.getWidth(imageObserver) * scale),
      ((int) (style.leading * scale)) + (int) (bufferedImage.getHeight(imageObserver) * scale));
  }

  @Override
  public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver imageObserver) {
    int width = x + (int) (style.indent * scale);
    int height = y + (int) (style.leading * scale);
    graphics.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(imageObserver) * scale),
      (int) (bufferedImage.getHeight(imageObserver) * scale), imageObserver);
  }

  public String toString() {
    return "Slides.BitmapItem[" + getLevel() + "," + imageName + "]";
  }
}
