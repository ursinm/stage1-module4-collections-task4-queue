package com.epam.collections.queue;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueCreator {

    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        // Создаем PriorityQueue с компаратором для обратного алфавитного порядка
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        
        // Добавляем все элементы из обоих списков в PriorityQueue
        priorityQueue.addAll(firstList);
        priorityQueue.addAll(secondList);
        
        return priorityQueue;
    }
}
