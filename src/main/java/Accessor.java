import java.io.IOException;

public abstract class Accessor
{

    abstract public void loadFile(Presentation presentation, String filename) throws IOException;

    abstract public void saveFile(Presentation presentation, String filename) throws IOException;

}
