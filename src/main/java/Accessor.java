import java.io.IOException;

public abstract class Accessor
{

    abstract public void loadFile(Presentation p, String filename) throws IOException;

    abstract public void saveFile(Presentation p, String filename) throws IOException;

}
