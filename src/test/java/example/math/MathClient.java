package example.math;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

/**
 *
 */
@Client("/math")
public interface MathClient {

    @Get("/compute/{input}")
    Integer compute(Integer input);

}
