package by.lord.of.words.controller;

import by.lord.of.words.model.Document;
import by.lord.of.words.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService counterService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Document get(@PathVariable Long id) {
        return counterService.getById(id);
    }

    @GetMapping(value = "/{id}/words", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getWordsAmount(@PathVariable Long id) {
        return counterService.getWordsAmount(id);
    }

    @GetMapping(value = "/{id}/words/unique", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getUniqueWords(@PathVariable Long id) {
        return counterService.getAmountUnique(id);
    }

}
