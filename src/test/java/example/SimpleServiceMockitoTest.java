package example;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Test Mockito Mock ans Spy behaviours without injecting service bean in target components.
 */
@MicronautTest
public class SimpleServiceMockitoTest {

    @Spy
    SimpleService simpleServiceSpy;

    @Mock
    SimpleService simpleServiceMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSimpleServiceSpy() {

        when(simpleServiceSpy.getCurrentTime()).thenReturn(1000L);

        assertEquals("AAA:ts=1000", simpleServiceSpy.upperWithTimestamp("aaa"));
        assertEquals(Long.valueOf(1000L), simpleServiceSpy.getCurrentTime());
    }

    @Test
    public void testSimpleServiceMock() {

        when(simpleServiceMock.upperWithTimestamp(anyString())).thenReturn("BBB");
        when(simpleServiceMock.getCurrentTime()).thenReturn(2000L);

        assertEquals("BBB", simpleServiceMock.upperWithTimestamp("aaa"));
        assertEquals(Long.valueOf(2000L), simpleServiceMock.getCurrentTime());
    }

}
