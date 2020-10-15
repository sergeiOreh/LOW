package by.lord.of.words.repository.impl;

import by.lord.of.words.repository.DocumentRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    @Override
    public Stream<String> getFile(String path) throws IOException {
        return Files.lines(Paths.get(path), StandardCharsets.UTF_8);
    }
}
