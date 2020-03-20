package chapter3.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    private Deque<String> deque;
    private Queue<String> que;

    @BeforeEach
    public void init(){
        deque = new LinkedList<>();;
        que = deque;
        deque.add("one");
        deque.add("two");
        deque.add("three");
    }

    /**
     * Adding elements to the end (tail) of the queue.
     */
    @Test
    public void tailAdd(){
        que.clear();
        try {
            que.add("One");
        } catch (IllegalStateException e) {
            System.out.println("Failed to add element.");
        }

        if(!que.offer( "Two")){
            System.out.println("Failed to add element.");
        }

        print();
    }

    /**
     * Adding elements to the head of the queue.
     */
    @Test
    public void headAdd() {
        print();
        try {
            deque.push("Joker");
            deque.addFirst("Mega Joker");
        } catch (IllegalStateException e) {
            System.out.println("Failed to add element.");
        }

        print();
    }

    private void print(){

        System.out.printf("head-> %s <-tail%n", deque);
    }
}
