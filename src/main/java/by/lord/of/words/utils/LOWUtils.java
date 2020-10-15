package by.lord.of.words.utils;

public class LOWUtils {

    public static String getWordWithoutPunctuation(String s) {
        return s.replaceAll(",", "")
                .replaceAll("!", "")
                .replaceAll("\\.", "")
                .replaceAll(":", "")
                .replaceAll(";", "")
                .replaceAll("!", "")
                .replaceAll("\\?", "")
                .replaceAll("-", "");

    }

}
