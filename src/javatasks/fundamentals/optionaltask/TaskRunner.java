package javatasks.fundamentals.optionaltask;

import java.util.ArrayList;
import java.util.List;

public class TaskRunner {
//    Для успешного выполнения задания достаточно реализовать 2-4 пункта.
//
//Задание. Ввести n чисел с консоли.
//1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
//
//2.     Вывести числа в порядке возрастания (убывания) значений их длины.
//
//3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
//

public static void main(String[] args) {
    //Задание. Ввести n чисел с консоли.
    List<String> numbers = new ArrayList<>();
    TaskPerformance taskPerformance = new TaskPerformance();

    taskPerformance.consoleInput(numbers);

    List<String> numbersSorted = taskPerformance.getArrayNumbersSortedByLength(numbers);
    List<String> shortestAndLongestNumbers = taskPerformance.getShortestAndLongestNumbers(numbersSorted);
    System.out.println("Самое короткое число: " + shortestAndLongestNumbers.get(0) + ", Самое длинное число: " + shortestAndLongestNumbers.get(1));

    System.out.println("Все числа в порядке возрастания значений их длины : " + numbersSorted);
    taskPerformance.showNumbersLessAverage(numbersSorted);
}
}
