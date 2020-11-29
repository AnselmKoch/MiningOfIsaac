package ak.isaac.theminingofisaac.helper;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//Übernimmt Rechnungen

public class MathHelper {


    Random random = new Random();

    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public double getRandomLocationX(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
    public double getRandomLocationY(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }
    public double getRandomLocationZ(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    public int getRandomColorRed() {
        return ThreadLocalRandom.current().nextInt(0,254+1);
    }
    public int getRandomColorGreen() {
        return ThreadLocalRandom.current().nextInt(0,254+1);
    }
    public int getRandomColorBlue() {
        return ThreadLocalRandom.current().nextInt(0,254+1);
    }
}
