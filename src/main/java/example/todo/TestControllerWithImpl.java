package example.todo;

import example.converter.ConverterServiceImpl;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

/**
 * Test does not work for this controller. I've tried to inject mock without implementing Interface.
 */
@Controller("/testimpl")
public class TestControllerWithImpl {

    ConverterServiceImpl converterServiceImpl;

    @Get(value = "/convert/{input}", produces = MediaType.TEXT_PLAIN)
    public String convert(String input) {
        return converterServiceImpl.convert(input);
    }

}
