package example.math;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test to display different HTTP client approaches.
 */
@MicronautTest
class MathServiceInjectTest {

    @Inject
    MathService mathService;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Inject
    MathClient mathClient;

    @Test
    void testComputeProgrammatiHttpcClient() {

        when(mathService.compute(ArgumentMatchers.anyInt())).thenReturn(25);

        final Integer result = client.toBlocking()
                                     .retrieve(HttpRequest.GET("/math/compute/" + 32), Integer.class);

        assertEquals(Integer.valueOf(25), result);
        verify(mathService).compute(32);
    }

    @Test
    void testComputeDeclarativeHttpClient() {

        when(mathService.compute(ArgumentMatchers.anyInt())).thenReturn(25);

        final Integer result = mathClient.compute(32);

        assertEquals(Integer.valueOf(25), result);
        verify(mathService).compute(32);
    }

    @MockBean(MathServiceImpl.class)
    MathService mathService() {
        return mock(MathService.class);
    }

}
