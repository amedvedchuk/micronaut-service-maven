package example.math;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;

/**
 *
 */
@Controller("/math")
@RequiredArgsConstructor
public class MathController {

    private final MathService mathService;

    @Get(uri = "/compute/{number}", processes = MediaType.TEXT_PLAIN)
    String compute(Integer number) {
        return String.valueOf(mathService.compute(number));
    }
}