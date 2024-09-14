package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeCreator {

    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        
        // Первоначально каждый игрок добавляет по две карты в ArrayDeque
        arrayDeque.add(firstQueue.poll());
        arrayDeque.add(firstQueue.poll());
        arrayDeque.add(secondQueue.poll());
        arrayDeque.add(secondQueue.poll());
        
        // Игра продолжается, пока у обоих игроков есть карты
        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            // Игрок 1 берет верхнюю карту и добавляет её в конец своей очереди
            firstQueue.add(arrayDeque.poll());
            // Игрок 1 добавляет две карты в ArrayDeque
            arrayDeque.add(firstQueue.poll());
            arrayDeque.add(firstQueue.poll());
            
            // Игрок 2 берет верхнюю карту и добавляет её в конец своей очереди
            secondQueue.add(arrayDeque.poll());
            // Игрок 2 добавляет две карты в ArrayDeque
            arrayDeque.add(secondQueue.poll());
            arrayDeque.add(secondQueue.poll());
        }
        
        return arrayDeque;
    }
}
