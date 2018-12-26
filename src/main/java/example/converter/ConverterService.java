package example.converter;

import javax.validation.constraints.NotNull;

/**
 *
 */
public interface ConverterService {
    
    String convert(@NotNull String input);

    ConvertDto convertToDto(String input);

    Long calculateTime(Long start);
}
