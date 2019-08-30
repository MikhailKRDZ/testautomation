package javatasks.fundamentals.maintask;

public class Task3 {
    //3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
    public static void main(String[] args) {
        int[] randomNumbers = {1, 2, 3, 4, 5};

        for (int i : randomNumbers) {
            System.out.println(i);
        }
        for (int i : randomNumbers) {
            System.out.print(i);
        }
    }
}