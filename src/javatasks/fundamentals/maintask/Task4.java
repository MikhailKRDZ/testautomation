package javatasks.fundamentals.maintask;

public class Task4 {
//      Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

    public static void main(String[] args) {
        int sum = 0;
        int multiplication = 1;

        for (String a : args) {
            try {
                int currentNumber = Integer.parseInt(a);
                sum += currentNumber;
                multiplication = multiplication * currentNumber;
            } catch (NumberFormatException e) {
                System.out.println("Aргумент командной строки: " + a + " , не целое число.");
            }
        }
        if (sum != 0) {
            System.out.println("Cумма введённых чисел: " + sum);
            System.out.println("Произведение введённых чисел: " + multiplication);
        }
    }
}