package by.lord.of.words.service;

import by.lord.of.words.model.Document;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DocumentService {

    long getWordsAmount(Long id);

    List<String> getAllWords(Long id);

    List<String> getUniqueWords(Long id);

    long getAmountUnique(Long id);

    Document getById(Long id);

}
