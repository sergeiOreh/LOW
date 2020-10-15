package by.lord.of.words.repository;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public interface DocumentRepository {

    Stream<String> getFile(String path) throws IOException;

}
