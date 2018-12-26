package example;

import javax.inject.Singleton;

@Singleton
public class SimpleService {

    public String upperWithTimestamp(String input) {
        return input.toUpperCase() + ":ts=" + getCurrentTime();
    }

    public Long getCurrentTime() {
        return System.currentTimeMillis();
    }

}