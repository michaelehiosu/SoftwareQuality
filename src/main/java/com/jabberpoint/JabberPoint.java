package com.jabberpoint;

import com.jabberpoint.accessor.AccessorFactory;
import com.jabberpoint.components.SlideViewerFrame;
import com.jabberpoint.presentation.Presentation;
import com.jabberpoint.slides.Style;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 * MainProgram.JabberPoint Main Programme
 * This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.
 **/

public class JabberPoint
{
  protected static final String IOERR = "IO Error: ";
  protected static final String JABERR = "Jabberpoint Error ";
  protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";


  public static void main(String[] argv)
  {

    Style.createStyles();
    Presentation presentation = new Presentation();
    new SlideViewerFrame(JABVERSION, presentation);
    AccessorFactory factory = new AccessorFactory();
    try
    {
      if (argv.length == 0)
      {
        factory.createAccessor("Demo", presentation).loadFile("");
      }
      else
      {
        factory.createAccessor("XML", presentation).loadFile(argv[0]);
      }
      presentation.setSlideNumber(0);
    } catch (IOException ex)
    {
      JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
    }
  }
}
