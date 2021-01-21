package by.lord.of.words.service.impl;

import by.lord.of.words.exception.DocumentNotFountException;
import by.lord.of.words.model.Document;
import by.lord.of.words.repository.DocumentRepository;
import by.lord.of.words.service.DocumentService;
import by.lord.of.words.utils.LOWUtils;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Cacheable(value = "wordsAmount")
    @Override
    public long getWordsAmount(Long documentId) {
        String[] wordArray = getById(documentId).getText().lines().collect(Collectors.joining(" ")).split(" ");
        return Arrays.stream(wordArray)
                .filter(Strings::isNotBlank)
                .map(LOWUtils::getWordWithoutPunctuation)
                .count();
    }

    @Cacheable(value = "allWords")
    @Override
    public String[] getAllWords(Long id) {
        String[] wordArray = getById(id).getText().lines().collect(Collectors.joining(" ")).split(" ");
        return Arrays.stream(wordArray)
                .filter(Strings::isNotBlank)
                .map(LOWUtils::getWordWithoutPunctuation)
                .toArray(String[]::new);
    }

    @Cacheable(value = "uniqueWords")
    @Override
    public String[] getUniqueWords(Long id) {
        String[] wordArray = getById(id).getText().lines().collect(Collectors.joining(" ")).split(" ");
        return Arrays.stream(wordArray)
                .filter(Strings::isNotBlank)
                .map(LOWUtils::getWordWithoutPunctuation)
                .distinct()
                .toArray(String[]::new);
    }

    @Cacheable(value = "wordsUnique")
    @Override
    public long getAmountUnique(Long id) {
        String[] wordArray = getById(id).getText().lines().collect(Collectors.joining(" ")).split(" ");
        return Arrays.stream(wordArray).map(LOWUtils::getWordWithoutPunctuation).filter(Strings::isNotBlank).distinct().count();
    }

    @Cacheable(value = "document")
    @Override
    public Document getById(Long documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> new DocumentNotFountException(documentId));
    }
}
