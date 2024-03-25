import javax.swing.*;
import java.io.IOException;

/* JabberPoint Main Programma
 * This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file. */

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
        AssessorFactory factory = new AssessorFactory();
        try
        {
            if (argv.length == 0)
            {
                factory.createAssessorFactory("Demo").loadFile(presentation, "");
            }
            else
            {
                factory.createAssessorFactory("XML").loadFile(presentation, argv[0]);
            }
            presentation.setSlideNumber(0);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
