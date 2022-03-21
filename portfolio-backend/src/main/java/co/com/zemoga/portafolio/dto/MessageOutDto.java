package co.com.zemoga.portafolio.dto;

import lombok.Data;

/**
 * Dto to manage the Successful/Error data.
 * @author jacoboflorez
 */
@Data
public class MessageOutDto {

    private boolean error;

    private String answerDescription;
}
