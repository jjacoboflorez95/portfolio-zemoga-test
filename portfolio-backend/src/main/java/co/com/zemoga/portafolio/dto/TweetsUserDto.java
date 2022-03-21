package co.com.zemoga.portafolio.dto;

import lombok.Data;

import java.util.List;

/**
 * Dto to manage the user's tweets.
 * @author jacoboflorez
 */
@Data
public class TweetsUserDto {

    private List<TweetsUserDataDto> data;

    private TweetsUserMetaDto meta;
}
