package com.epam.collections.queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueCreatorTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                // Оба списка пустые
                Arguments.of("BothListsEmpty",
                        List.of(),
                        List.of(),
                        List.of()),

                // Первый список пуст, второй заполнен
                Arguments.of("FirstListEmptySecondFilled",
                        List.of(),
                        List.of("Objects", "are", "processed", "based", "on", "their", "priority"),
                        List.of("their", "processed", "priority", "on", "based", "are", "Objects")),

                // Первый заполнен, второй пуст
                Arguments.of("FirstFilledSecondEmpty",
                        List.of("The", "Java", "PriorityQueue", "class"),
                        List.of(),
                        List.of("class", "The", "PriorityQueue", "Java")),

                // Оба списка заполнены
                Arguments.of("BothListsFilled",
                        List.of("The", "Java", "PriorityQueue", "class"),
                        List.of("Objects", "are", "processed", "based", "on", "their", "priority"),
                        List.of("their", "processed", "priority", "on", "class", "based", "are", "The", "PriorityQueue", "Objects", "Java")),

                // Одинаковые элементы в списках
                Arguments.of("DuplicateElementsInLists",
                        List.of("Java", "Java", "PriorityQueue", "Queue"),
                        List.of("Queue", "PriorityQueue", "Java"),
                        List.of("Queue", "Queue", "PriorityQueue", "PriorityQueue", "Java", "Java", "Java")),

                // Смешанные символы (заглавные и строчные буквы)
                Arguments.of("MixedCaseElements",
                        List.of("apple", "Banana", "Cherry"),
                        List.of("apple", "banana", "cherry"),
                        List.of("cherry", "banana", "apple", "Cherry", "Banana", "apple"))
        );
    }

    @ParameterizedTest(name = " createPriorityQueue_{0}_Test")
    @MethodSource(value = "testCases")
    void createPriorityQueueTest(String name,
                                 List<String> firstList,
                                 List<String> secondList,
                                 List<String> expectedPriorityQueueValues) {

        PriorityQueueCreator creator = new PriorityQueueCreator();
        PriorityQueue<String> actualQueue = creator.createPriorityQueue(firstList, secondList);
        
        // Проверяем, что размер очереди соответствует ожидаемому
        assertEquals(expectedPriorityQueueValues.size(), actualQueue.size());

        // Проверяем, что каждый элемент соответствует ожидаемому значению
        expectedPriorityQueueValues.forEach(expectedQueueValue -> assertEquals(expectedQueueValue, actualQueue.poll()));
    }
}
