package by.lord.of.words.dto;

import by.lord.of.words.model.FileDB;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The controller will use these class for sending message via HTTP responses
 */
@Setter
@Getter
@AllArgsConstructor
public class ResponseFile {

    private String name;
    private String url;
    private String type;
    private long size;

}
