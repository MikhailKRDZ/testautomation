package javatasks.fundamentals.maintask;

public class Task2 {
    public static void main(String[] args) {
        //    2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.

        if (args.length > 0) {
            System.out.print("Aргументы командной строки в обратном порядке : ");
            for (int i = args.length; i > 0; i--) {
                System.out.print(args[i - 1] + ", ");
            }
        }

    }
}
