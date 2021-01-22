package by.lord.of.words.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The controller will use these class for sending message via HTTP responses
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseMessage {

    private String message;
}
