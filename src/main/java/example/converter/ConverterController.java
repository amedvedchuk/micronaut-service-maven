package example.converter;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller("/test")
public class ConverterController {

    private final ConverterService converterService;

    @Get
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Get(value = "/convert/{input}", produces = MediaType.TEXT_PLAIN)
    public String convert(String input) {
        return converterService.convert(input);
    }

    @Get(value = "/convert2/{input}", produces = MediaType.APPLICATION_JSON)
    public ConvertDto convert2(String input) {
        return converterService.convertToDto(input);
    }

}