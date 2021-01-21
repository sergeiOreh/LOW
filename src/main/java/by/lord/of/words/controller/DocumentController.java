package by.lord.of.words.controller;

import by.lord.of.words.model.Document;
import by.lord.of.words.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    private final static String WORDS_AMOUNT = "/{id}/words/amount";
    private final static String WORDS_AMOUNT_UNIQUE = "/{id}/words/amount/unique";
    private final static String WORDS = "/{id}/words";
    private final static String WORDS_UNIQUE = "/{id}/words/unique";

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Document get(@PathVariable Long id) {
        return documentService.getById(id);
    }

    @GetMapping(value = WORDS_AMOUNT, produces = MediaType.APPLICATION_JSON_VALUE)
    public long getWordsAmount(@PathVariable Long id) {
        return documentService.getWordsAmount(id);
    }

    @GetMapping(value = WORDS_AMOUNT_UNIQUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public long getUniqueWordsAmount(@PathVariable Long id) {
        return documentService.getAmountUnique(id);
    }

    @GetMapping(value = WORDS, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] getWords(@PathVariable Long id) {
        return documentService.getAllWords(id);
    }

    @GetMapping(value = WORDS_UNIQUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] getUniqueWords(@PathVariable Long id) {
        return documentService.getUniqueWords(id);
    }

}
