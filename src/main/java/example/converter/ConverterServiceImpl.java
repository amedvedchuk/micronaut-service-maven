package example.converter;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

@Singleton
@Slf4j
public class ConverterServiceImpl implements ConverterService {

    @Override
    public String convert(@NotNull String input) {

        log.info("start converting for input: [{}]", input);

        String result = input.toUpperCase();

        log.info("stop converting result: [{}]", result);

        return result;

    }

    @Override
    public ConvertDto convertToDto(String input) {
        Long start = System.nanoTime();
        return new ConvertDto(convert(input), calculateTime(start));
    }

    @Override
    public Long calculateTime(Long start) {
        return (System.nanoTime() - start) / 1000;
    }

}