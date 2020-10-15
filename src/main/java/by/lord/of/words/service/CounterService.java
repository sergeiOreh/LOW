package by.lord.of.words.service;


import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CounterService {

    long getWordsAmount(String filePath) throws IOException;

    List<String> getAllWords(String filePath);

    List<String> getUniqueWords(String filePath);

    long getAmountUnique(String filePath) throws IOException;

}
