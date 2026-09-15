import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedMonteCarlo {

    static MonteCarloTask MCT = new MonteCarloTask();

    public static final long totalPoints = 1_000_000;

    static void main() {
        Instant start = Instant.now();
        ExecutorService es = Executors.newFixedThreadPool(4);

        for(int i =0; i<4; i++){
            es.submit(new MonteCarloTask());
        }

        double pi = MCT.pointsInCircle/(double)totalPoints*4;


        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("pi="+pi);
        System.out.println("runtime="+timeElapsed);

        es.shutdown();
    }
}
