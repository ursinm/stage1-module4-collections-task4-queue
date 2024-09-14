package com.epam.collections.queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DishOrderDeterminerTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                // Без блюд (граничный случай)
                Arguments.of("WithNoDishes",
                        0,
                        3,
                        List.of()),

                // Стандартное количество блюд, пропуская каждое 4-е блюдо
                Arguments.of("WithDishes",
                        11,
                        4,
                        List.of(4, 8, 1, 6, 11, 7, 3, 2, 5, 10, 9)),

                // Одно блюдо (граничный случай)
                Arguments.of("WithOneDish",
                        1,
                        3,
                        List.of(1)),

                // Все блюда съедаются по порядку, так как пропуск = 1
                Arguments.of("WithStepOne",
                        5,
                        1,
                        List.of(1, 2, 3, 4, 5)),

                // Пропуск больше, чем количество блюд
                Arguments.of("StepGreaterThanDishes",
                        5,
                        10,
                        List.of(5, 1, 2, 3, 4))
        );
    }

    @ParameterizedTest(name = "determineDishOrder_{0}_Test")
    @MethodSource(value = "testCases")
    void determineDishOrderTest(String name,
                                int numberOfDishes,
                                int everyDishNumberToEat,
                                List<Integer> expectedDishOrder) {

        DishOrderDeterminer determiner = new DishOrderDeterminer();
        List<Integer> actualDishOrder = determiner.determineDishOrder(numberOfDishes, everyDishNumberToEat);
        assertEquals(expectedDishOrder, actualDishOrder);
    }
}
