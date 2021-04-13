package experements;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GenericsTest {

    @Test
    public void sortMethodSignature(){
        List<Object> list = List.of(3,2,1);
        // Collections.sort(list); //Compilation failure
    }

    @Test
    public void varAndDiamond(){
        var data = new ArrayList<>();
        data.add("A");
        data.add(100); //1
        data.add("C");
        data.set(0, 200); //2
        data.remove(2); //3
        data.set(2, 101L);//4

        System.out.println(data);
    }
}
