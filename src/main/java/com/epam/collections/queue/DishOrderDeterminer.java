package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {

    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> dishOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Заполняем очередь номерами всех блюд
        for (int i = 1; i <= numberOfDishes; i++) {
            queue.add(i);
        }

        // Пока все блюда не съедены
        while (!queue.isEmpty()) {
            // Пропускаем everyDishNumberToEat - 1 блюд
            for (int i = 1; i < everyDishNumberToEat; i++) {
                queue.add(queue.poll());  // Переносим блюдо в конец очереди
            }
            // Съедаем очередное блюдо
            dishOrder.add(queue.poll());
        }

        return dishOrder;
    }
}

