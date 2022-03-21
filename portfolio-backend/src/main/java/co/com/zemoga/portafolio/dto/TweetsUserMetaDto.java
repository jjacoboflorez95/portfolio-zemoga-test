package co.com.zemoga.portafolio.dto;

import lombok.Data;

/**
 * Dto to manage the user's tweets meta.
 * @author jacoboflorez
 */
@Data
public class TweetsUserMetaDto {

    private String oldest_id;

    private String newest_id;

    private Integer result_count;
}
