package by.lord.of.words.service.impl;

import by.lord.of.words.repository.DocumentRepository;
import by.lord.of.words.service.CounterService;
import by.lord.of.words.utils.LOWUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class CounterServiceImpl implements CounterService {

    private final DocumentRepository documentRepository;

    public CounterServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public long getWordsAmount(String filePath) throws IOException {
        List<String> words = Arrays.asList(documentRepository.getFile(filePath).collect(Collectors.joining(" ")).split(" "));
        return words.stream()
                .filter(Strings::isNotBlank)
                .map(LOWUtils::getWordWithoutPunctuation)
                .count();
    }

    @Override
    public List<String> getUniqueWords(String filePath) {

        return null;
    }

    @Override
    public long getAmountUnique(String filePath) throws IOException {
        String[] wordArray = documentRepository.getFile(filePath).collect(Collectors.joining(" ")).split(" ");
        return Arrays.stream(wordArray).distinct().count();
    }

    @Override
    public List<String> getAllWords(String filePath) {
        return null;
    }


}
