package experements;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

@Slf4j
public class StreamsTest {
    List<String> vals = List.of("a", "b", "c", "d", "e", "f", "g",
            "a", "b", "c", "d", "e", "f", "g",
            "a", "b", "c", "d", "e", "f", "g",
            "a", "b", "c", "d", "e", "f", "g");

    @Test
    public void parallelStreamReduceTwoThreads(){
        ForkJoinPool pool = new ForkJoinPool(1);
        Callable<String> task = () -> vals.stream()
            .parallel()
            .peek(log::info) //this shows how the elements are retrieved from the stream
            .reduce("_",
                    (a, b)->{
                        log.info("reducing "+a+" and "+b+" Thread: "+Thread.currentThread().getName());
                        return a.concat(b);
                    },
                    (a, b)->{
                        log.info("combining "+a+" and "+b+" Thread: "+Thread.currentThread().getName());
                        return a.concat(b);
                    }
            );

        String result = null;
        try {
            result = pool.submit(task).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info("Result: {}", result);
    }

    @Test
    public void parallelStreamReduce(){
        String join = vals.parallelStream()
                .peek(log::info) //this shows how the elements are retrieved from the stream
                .reduce("_",
                        (a, b)->{
                            log.info("reducing "+a+" and "+b+" Thread: "+Thread.currentThread().getName());
                            return a.concat(b);
                        },
                        (a, b)->{
                            log.info("combining "+a+" and "+b+" Thread: "+Thread.currentThread().getName());
                            return a.concat(b);
                        }
                );
        log.info(join);
    }
}
