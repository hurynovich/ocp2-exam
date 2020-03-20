package chapter3.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class QueueTest {

    private Deque<String> deque;
    private Queue<String> que;

    @BeforeEach
    public void init(){
        deque = new LinkedList<>();;
        que = deque;
        for (int i = 1; i < 10; i++) {
            que.add(String.valueOf(i));
        }
    }

    /**
     * Adding elements to the end (tail) of the queue.
     */
    @Test
    public void tailAdd(){
        que.clear();
        try {
            que.add("q.add");
            deque.addLast("dq.addLast");
        } catch (IllegalStateException e) {
            System.out.println("Failed to add element.");
        }

        if(!que.offer( "q.offer")){
            System.out.println("Failed to add element.");
        }

        if(!deque.offerLast( "dq.offerLast")){
            System.out.println("Failed to add element.");
        }

        print();
    }

    /**
     * Adding elements to the head of the queue.
     */
    @Test
    public void headAdd() {
        que.clear();
        try {
            deque.push("push");
            deque.addFirst("addFirst");
        } catch (IllegalStateException e) {
            System.out.println("Failed to add element.");
        }

        if(!deque.offerFirst("offerFirst")){
            System.out.println("Failed to add element.");
        }

        print();
    }

    @Test
    public void headRemove(){
        print();

        try {
            que.remove();
            deque.removeFirst();
            deque.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Failed to remove element.");
        }
        que.poll();
        deque.pollFirst();

        print();
    }

    @Test
    public void tailRemove(){
        print();

        try {
            deque.removeLast();
        } catch (NoSuchElementException e) {
            System.out.println("Failed to remove element.");
        }

        deque.pollLast();

        print();
    }

    @Test
    public void headGet(){
        print();

        try {
            System.out.println("q.element = " + que.element());
            System.out.println("dq.getFirst = " + deque.getFirst());
        } catch (NoSuchElementException e) {
            System.out.println("Failed to get head.");
        }

        System.out.println("q.peek = " + que.peek());
        System.out.println("dq.peekFirst = " + deque.peekFirst());
    }

    @Test
    public void tailGet(){

    }

    private void print(){
        System.out.printf("head-> %s <-tail%n", deque);
    }
}
