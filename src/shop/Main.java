package shop;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Main {

    private static final List<String> NAMES = List.of(
            "Антонова Ольга",
            "Молчанова Виктория",
            "Гущина Ксения",
            "Романова Анна",
            "Петрова Мария",
            "Давыдов Александр",
            "Кузин Владимир",
            "Сорокин Олег",
            "Ковалева Алия",
            "Петрова Алёна",
            "Лазарева Вероника",
            "Семенова Елизавета",
            "Скворцова София",
            "Тимофеева Светлана",
            "Акимов Марк");
    private static final Random RANDOM = new Random();
    private static final int MAX_SIZE = 5;

    public static void main(String[] args) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        Queue<String> queue3 = new ArrayDeque<>();
        randomFilling(queue1);
        randomFilling(queue2);
        randomFilling(queue3);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println("Третяя очередь: " + queue3);
        System.out.println("###########");


        add("Филиппова Вероника", queue1, queue2,queue3);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println("Третяя очередь: " + queue3);
        System.out.println("###########");

        remove(queue1, queue2, queue3);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println("Третяя очередь: " + queue3);
        System.out.println("###########");
    }

    private static void add (String name,Queue<String> queue1,Queue<String> queue2,Queue<String> queue3) {
        if (queue1.size() == MAX_SIZE && queue2.size() == MAX_SIZE && queue3.size() == MAX_SIZE) {
            System.out.println("Нужно позвать Галю!");
        }
        if (queue1.size() < queue2.size() && queue1.size() < queue3.size()) {
            queue1.offer(name);
        } else if (queue2.size() < queue1.size() && queue2.size() < queue3.size()){
            queue2.offer(name);
        } else {
            queue3.offer(name);
        }
    }
    private static void remove (Queue<String> queue1,Queue<String> queue2,Queue<String> queue3) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else if (RANDOM.equals(queue1)){
            queue2.poll();
        } else {
            queue3.poll();
        }
    }
    private static void randomFilling(Queue<String> queue) {
        int size = RANDOM.nextInt(MAX_SIZE + 1);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }
}
