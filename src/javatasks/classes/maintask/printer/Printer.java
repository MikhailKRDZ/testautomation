package javatasks.classes.maintask.printer;

import javatasks.classes.maintask.student.Student;

import java.util.ArrayList;

public class Printer {

    public static void printStudents(Student[] students) {
        System.out.println("Массив объектов");
        StringBuilder stringBuilder = new StringBuilder();
        int linesNumber = students.length;
        int columnsNumber = students[0].toString().length() - students[0].toString().replace("\t", "").length();
        String[][] arrayToPrint = new String[linesNumber + 1][columnsNumber];
        int[] maxSizeColumn = new int[columnsNumber];
        String headlineTest = students[0].getHeadlines();
        for (int lineTemp = 0; lineTemp <= linesNumber; lineTemp++) {
            stringBuilder.delete(0, stringBuilder.length());
            if (lineTemp == 0) {
                stringBuilder.append(headlineTest);
            } else {
                stringBuilder.append(students[lineTemp - 1].toString());
            }
            for (int columnTemp = 0; columnTemp < columnsNumber; columnTemp++) {
                int columnSize = 1 + stringBuilder.indexOf("\t");
                arrayToPrint[lineTemp][columnTemp] = stringBuilder.substring(0, columnSize - 1);
                stringBuilder.delete(0, columnSize);
                if (lineTemp == 0) {
                    maxSizeColumn[columnTemp] = columnSize + 1;
                } else if (maxSizeColumn[columnTemp] < columnSize + 1) {
                    maxSizeColumn[columnTemp] = columnSize + 1;
                }
            }
        }
        stringBuilder.delete(0, stringBuilder.length());
        for (int lineTemp = 0; lineTemp <= linesNumber; lineTemp++) {
            if (lineTemp == 0) {
                System.out.printf("%1$-7s", "№п.п");
            } else {
                System.out.printf("%1$-7s", lineTemp);
            }
            for (int columnTemp = 0; columnTemp < columnsNumber; columnTemp++) {
                stringBuilder.append("%1$-");
                stringBuilder.append(maxSizeColumn[columnTemp]);
                stringBuilder.append("s");
                if (columnTemp == columnsNumber - 1) {
                    stringBuilder.append("\n");
                }
                System.out.printf(stringBuilder.toString(), arrayToPrint[lineTemp][columnTemp]);
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        System.out.println();
    }

    public static void printStudents(ArrayList<String> arrayList) {
        System.out.println(arrayList.get(0));
        StringBuilder stringBuilder = new StringBuilder();
        int  linesNumber = arrayList.size()-1;
        int columnsNumber = arrayList.get(1).length() - arrayList.get(1).replace("\t", "").length();
        String[][] arrayToPrint = new String[linesNumber][columnsNumber];
        int[] maxSizeColumn = new int[columnsNumber];
        for (int lineTemp = 0; lineTemp < linesNumber; lineTemp++) {
            stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(arrayList.get(lineTemp + 1));
            for (int columnTemp = 0; columnTemp < columnsNumber; columnTemp++) {
                int columnSize = 1 + stringBuilder.indexOf("\t");
                arrayToPrint[lineTemp][columnTemp] = stringBuilder.substring(0, columnSize - 1);
                stringBuilder.delete(0, columnSize);
                if (lineTemp == 0) {
                    maxSizeColumn[columnTemp] = columnSize + 1;
                } else if (maxSizeColumn[columnTemp] < columnSize + 1) {
                    maxSizeColumn[columnTemp] = columnSize + 1;
                }
            }
        }
        stringBuilder.delete(0, stringBuilder.length());
        for (int lineTemp = 0; lineTemp < linesNumber; lineTemp++) {
            if (lineTemp == 0) {
                System.out.printf("%1$-7s", "№п.п");
            } else {
                System.out.printf("%1$-7s", lineTemp);
            }
            for (int columnTemp = 0; columnTemp < columnsNumber; columnTemp++) {
                    stringBuilder.append("%1$-");
                    stringBuilder.append(maxSizeColumn[columnTemp]);
                    stringBuilder.append("s");
                    if (columnTemp == columnsNumber - 1) {
                        stringBuilder.append("\n");
                    }
                System.out.printf(stringBuilder.toString(), arrayToPrint[lineTemp][columnTemp]);
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        System.out.println();
    }
}
