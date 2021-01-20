package by.lord.of.words.service;

import by.lord.of.words.LowApplicationTests;
import by.lord.of.words.utils.LOWUtils;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class DevelopmentTest extends LowApplicationTests{

    public static Stream<String> getFileAsLines() throws IOException {
        return Files.lines(Paths.get("test.txt"), StandardCharsets.UTF_8);
    }

    public static String getStringFromFile() throws IOException {
        return getFileAsLines().collect(Collectors.joining(" "));
    }

    public static List<String> getListWordsFromFile() throws IOException {
        return Arrays.asList(getStringFromFile().split(" "));
    }

    public static List<String> getCleanList() throws IOException {
        return getListWordsFromFile().stream()
                .filter(Strings::isNotBlank)
                .map(LOWUtils::getWordWithoutPunctuation)
                .collect(Collectors.toList());
    }

    @Test
    void getWordsAmountTest() throws IOException {
        getCleanList().forEach(System.out::println);
    }
}