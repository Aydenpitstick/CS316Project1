import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedMonteCarlo{
    public static final long totalPoints = 10_000_000_000L;

    static void main() throws Exception{
        Instant start = Instant.now();
        ExecutorService es = Executors.newFixedThreadPool(4);


        Future<Long> t1 = es.submit(new MonteCarloTask());
        Future<Long> t2 = es.submit(new MonteCarloTask());
        Future<Long> t3 = es.submit(new MonteCarloTask());
        Future<Long> t4 = es.submit(new MonteCarloTask());

        long pointsInCircle = t1.get() + t2.get() + t3.get() + t4.get();



        double pi = pointsInCircle/(double)totalPoints*4;


        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("pi="+pi);
        System.out.println("runtime="+timeElapsed);

        es.shutdown();

    }
}
