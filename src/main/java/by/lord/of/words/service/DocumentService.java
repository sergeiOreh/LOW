package by.lord.of.words.service;

import by.lord.of.words.model.Document;

public interface DocumentService {

    long getWordsAmount(Long id);

    String[] getAllWords(Long id);

    String[] getUniqueWords(Long id);

    long getAmountUnique(Long id);

    Document getById(Long id);
}
