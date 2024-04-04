package Presentation;

import java.io.IOException;

/**
 * An abstract class representing an accessor for loading and saving presentation files.
 */
public abstract class Accessor {

    /**
     * Loads a presentation file.
     *
     * @param presentation The presentation object.
     * @param filename     The name of the file to load.
     * @throws IOException If an I/O error occurs while loading the file.
     */
    public abstract void loadFile(Presentation presentation, String filename) throws IOException;

    /**
     * Saves a presentation file.
     *
     * @param presentation The presentation object.
     * @param filename     The name of the file to save.
     * @throws IOException If an I/O error occurs while saving the file.
     */
    public abstract void saveFile(Presentation presentation, String filename) throws IOException;
}
