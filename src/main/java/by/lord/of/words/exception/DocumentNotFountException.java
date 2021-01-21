package by.lord.of.words.exception;

public class DocumentNotFountException extends RuntimeException {

    public DocumentNotFountException(Long id) {
        super(String.format("Could not find document with id: %s", id));
    }
}
