package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static String getRandomValueFromArray(String[] value) {
        int index = getRandomInt(0, value.length - 1);

        return value[index];
    }
}
