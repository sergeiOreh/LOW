package by.lord.of.words.exception;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String id) {
        super(String.format("Could not find file with id: %s", id));
    }

}
