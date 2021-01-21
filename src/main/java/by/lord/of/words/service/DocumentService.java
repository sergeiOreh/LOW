package by.lord.of.words.service;

import by.lord.of.words.model.Document;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface DocumentService {

    long getWordsAmount(Long id);

    String[] getAllWords(Long id);

    String[] getUniqueWords(Long id);

    long getAmountUnique(Long id);

    Document getById(Long id);
}
