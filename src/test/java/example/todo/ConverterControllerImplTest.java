package example.todo;

import example.converter.ConverterServiceImpl;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test does not work. I've tried to inject mock without implementing Interface.
 */
@Disabled
@MicronautTest
public class ConverterControllerImplTest {

    @Inject
    ConverterServiceImpl converterServiceImpl;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testConvertToJsonResultNoMock() {

//        doReturn("XXX").when(converterServiceImpl).convert("");

        when(converterServiceImpl.convert("sss")).thenReturn("XXX");
        when(converterServiceImpl.calculateTime(0L)).thenReturn(25L);

        String response = client.toBlocking().retrieve("/testimpl/convert/ssss", String.class);

        assertEquals("XXX", response);

    }

//    @MockBean(ConverterServiceImplMock.class)
    @Replaces(ConverterServiceImpl.class)
//    @Bean
    @MockBean
    public ConverterServiceImpl converterServiceImpl() {
//        return spy(new ConverterServiceImpl());
        return mock(ConverterServiceImpl.class);

    }

}
