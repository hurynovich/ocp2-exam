package ch1.fundamentals;

import org.junit.jupiter.api.Test;

public class InterfaceTest {

    @Test
    public void iheritMethod(){

    }
}

interface A {
    default void doSomething(){}
}

interface B extends A {
    default void doSomething(){
        A.super.doSomething();
        // super.doSomething(); //Compile error
    }
}

class C implements B {

}
