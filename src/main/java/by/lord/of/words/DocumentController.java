package by.lord.of.words;

import by.lord.of.words.service.CounterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping(value = "/documents")
public class DocumentController {

//    TODO: https://javastudy.ru/spring-mvc/spring-mvc-load-files/

    private static final String FILE_PATH = "test.txt";
//    @Value("${path}")
//    private static String FILE_PATH;

    private final CounterService counterService;

    public DocumentController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping(value = "/words/amount", produces = "application/json")
    public long getWordsAmount() throws IOException {
        return counterService.getWordsAmount(FILE_PATH);
    }

    @GetMapping(value = "/words/amount/unique", produces = "application/json")
    public long getUniqueWords() throws IOException {
        return counterService.getAmountUnique(FILE_PATH);
    }

}
