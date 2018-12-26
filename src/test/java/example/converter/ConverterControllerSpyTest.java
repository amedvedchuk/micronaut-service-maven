package example.converter;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Test to display Spy service injected to Controller.
 */
@MicronautTest
public class ConverterControllerSpyTest {

    @Inject
    ConverterService converterService;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testHttpClientWithSpy() {

        when(converterService.calculateTime(anyLong())).thenReturn(1000L);

        ConvertDto response = client.toBlocking().retrieve("/test/convert2/ssss", ConvertDto.class);

        assertEquals("SSSS", response.getResult());
        assertEquals(Long.valueOf(1000L), response.getTime());

    }

    @Test
    public void testServiceWithSpy() {

        when(converterService.calculateTime(anyLong())).thenReturn(2000L);

        ConvertDto result = converterService.convertToDto("aaa");

        Assertions.assertEquals("AAA", result.getResult());
        Assertions.assertEquals(Long.valueOf(2000L), result.getTime());
    }

    @MockBean(ConverterServiceImpl.class)
    public ConverterService converterService() {
        return spy(new ConverterServiceImpl());
    }

}
