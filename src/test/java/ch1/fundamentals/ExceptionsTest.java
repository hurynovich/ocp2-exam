package ch1.fundamentals;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
public class ExceptionsTest {

    @Test
    public void suppressedException(){
        try {
            action();
        } catch (Exception e){
            log.info("Thrown exception: \"{}\"", e.getClass().getName());
            for(var s : e.getSuppressed()) log.info("Suppressed exceptions: \"{}\"", s.getClass());
        }
    }

    private void action() throws Exception {
        try(Ressource r = new Ressource()){
            throw new FileNotFoundException();
        }
    }
}

class Ressource implements Closeable {
    @Override
    public void close() throws IOException {
        throw new IOException("Close is failed.");
    }
}
