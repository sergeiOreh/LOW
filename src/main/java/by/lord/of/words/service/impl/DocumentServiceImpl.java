package by.lord.of.words.service.impl;

import by.lord.of.words.model.Document;
import by.lord.of.words.repository.DocumentRepository;
import by.lord.of.words.service.DocumentService;
import by.lord.of.words.utils.LOWUtils;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<String> getUniqueWords(Long id) {
        return null;
    }

    @Cacheable(value = "wordsUnique")
    @Override
    public long getAmountUnique(Long id) {
        String[] wordArray = getById(id).getText().lines().collect(Collectors.joining(" ")).split(" ");
        return Arrays.stream(wordArray).map(LOWUtils::getWordWithoutPunctuation).filter(Strings::isNotBlank).distinct().count();
    }

    @Override
    public List<String> getAllWords(Long id) {
        return null;
    }

    @Cacheable(value = "documentById")
    @Override
    public Document getById(Long documentId) {
        return documentRepository.findById(documentId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Document with id: %s not found", documentId)));
    }
}
