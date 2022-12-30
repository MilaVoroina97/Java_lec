package lection4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashSet;
// import java.util.LinkedHashSet;
import java.util.Set;

public class arraydeq {
    public static void main(String[] args) {
            Deque<String> stack = new ArrayDeque<>();
            Deque<String> queue = new ArrayDeque<>(2);
            stack.push("A");//добавляет в начало списка
            stack.push("B");
            stack.push("C");
            stack.push("D");
            while(!stack.isEmpty()){
                System.out.println(stack.pollLast() + " ");
            }

            queue.add("A");
            queue.add("B");
            queue.add("C");
            queue.add("D");
            while (!queue.isEmpty()) {
                System.out.print(queue.remove() + " ");
        }

        Deque<String> people = new ArrayDeque<>();
        people.add("Tom");
        people.add("Sam");
        people.add("Roma");
        people.add("Boris");
        // for(String p : people){
        //     System.out.println(p.length());
        // }

        Queue<Integer> priorityQueue1 = new PriorityQueue<>();
        for(int i = 5 ; i > 0; i--){
            priorityQueue1.add(i);
        }
        while(!priorityQueue1.isEmpty()){
            System.out.println(priorityQueue1.poll());
        }

        // for(int j = 10; j > 5; j --){
        //     priorityQueue1.offer(j);
        // }
        // System.out.println("now the head of the queue = " + priorityQueue1.peek());

        PriorityQueue<String> r = new PriorityQueue<>(Comparator.comparingInt(String::length));
        r.add("Rob");
        r.add("Tom");
        r.add("Nilla");
        r.add("Nikita");
        r.add("Sashahahah");
        for( String g : r){
            System.out.println(g);
        }

        String[] friends = {"Stuart", "Ivy", "Johnny", "Alex", "Igor", "Tanya"};
        Set<String> mySet = new HashSet<>(Arrays.asList(friends));
        System.out.println(mySet);
        mySet.remove("Stuart");

    }
}
