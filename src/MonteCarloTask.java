import java.util.concurrent.ThreadLocalRandom;

public class MonteCarloTask implements Runnable {

    public long pointsInCircle;
    long taskTotalPoints = MultithreadedMonteCarlo.totalPoints/4;

    public void run() {
        for(long i = 0; i<taskTotalPoints; i++) {
            double x = ThreadLocalRandom.current().nextDouble(0, 2);
            double y = ThreadLocalRandom.current().nextDouble(0, 2);
            double distance = Math.sqrt((x - 1) * (x - 1) + (y - 1) * (y - 1));

            if (distance <= 1) {
                pointsInCircle++;
            }
        }
    }
}
