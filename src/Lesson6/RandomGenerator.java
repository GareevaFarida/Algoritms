package Lesson6;

import java.util.Random;

public class RandomGenerator {
    private static Random random;

    static {
        random = new Random();
    }

    public static int getIntValueInRange(int min, int max) {
        if (min > max)
            throw new IllegalArgumentException("Minimal value of random range: " + min + " can't be more than maximum value: " + max + ".");
        return min + (int) (random.nextFloat() * (max - min));
    }
}
