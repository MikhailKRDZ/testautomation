package javatasks.classes.maintask;

import javatasks.classes.maintask.printer.Printer;
import javatasks.classes.maintask.student.*;
import javatasks.classes.maintask.university.University;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StudentRunner {

    public static void main(String[] args) {

        final int REQUIRED_STUDENTS_NUMBERS = 9;

        University university = new University(REQUIRED_STUDENTS_NUMBERS);
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        String[][] arrayStringPersons = new String[][]{
                new String[]{"1", "Иванов", "Иван", "Иванович", "20.02.2001", " Бирюзова ул., дом 17, кв. 31, Минск 220077", "207-03-42", "АТФ", "4", "625"},
                new String[]{"2", "Петров", "Андрей", "Петрович", "20.01.2001", " Бельского ул., дом 6, кв. 10, Минск 220077", "207-15-42", "АТФ", "3", "626"},
                new String[]{"3", "Иванов", "Сергей", "Иванович", "29.10.2000", " Казинца ул., дом 100, кв. 614, Минск 220015", "207-15-42", "ММФ", "4", "126"},
                new String[]{"4", "Сидоров", "Юрий", "Сидорович", "05.09.2000", " ул. Радужная, 150, Минск 220016", "207-15-42", "ММФ", "4", "126"},
                new String[]{"5", "Козлов", "Андрей", "Казимирович", "07.08.2001", " Текстильная, 14А, Барановичи 225409", "207-15-42", "АТФ", "3", "626"},
                new String[]{"6", "Колесник", "Владимир", "Андреевич", "07.07.2000", " пр-т Московский, 130-1, Витебск 210020", "207-15-42", "АТФ", "4", "625"},
                new String[]{"7", "Попов", "Константин", "Изяславович", "11.08.2001", " пр. Голодеда 15, Молодечно 222301", "207-15-42", "АТФ", "3", "626"},
                new String[]{"8", "Попов", "Константин", "Иванович", "11.08.2001", " пр. Голодеда 15, Молодечно 222301", "207-15-42", "АТФ", "4", "625"},
                new String[]{"9", "Дубов", "Сергей", "Иванович", "21.02.2000", " пр. Голодеда 15, Минск 220077", "207-15-42", "АТФ", "4", "625"},
                new String[]{"10", "Стрельцов", "Игорь", "Юрьевич", "01.05.2001", " пр. Голодеда 15, Минск 220077", "207-15-42", "АТФ", "3", "626"},};


        int i = 0;
        do {
            try {
                PersonBuilder builder = new PersonBuilder();
                Person personBuilder = builder.setId(arrayStringPersons[i][0])
                        .setSurname(arrayStringPersons[i][1])
                        .setName(arrayStringPersons[i][2])
                        .setPatronymicName(arrayStringPersons[i][3])
                        .setDateOfBirth(arrayStringPersons[i][4])
                        .setAddress(arrayStringPersons[i][5])
                        .setTelephoneNumber(arrayStringPersons[i][6])
                        .setFaculty(arrayStringPersons[i][7])
                        .setCourse(arrayStringPersons[i][8])
                        .setGroup(arrayStringPersons[i][9])
                        .build();
                Student student = new Person(personBuilder);

                university.addStudent(student);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } finally {
                i++;
            }
        } while (i < arrayStringPersons.length);

        try {
            final Faculty REQUIRED_FACULTY = Faculty.getFacultyValueByRealName("АТФ");
            final Group REQUIRED_GROUP = Group.getGroupValueByRealName("625");
            final Date REQUIRED_DATE = formatYear.parse("2001");

            Printer.printStudents(university.getStudents());
            Printer.printStudents(university.getListStudentsFaculty(REQUIRED_FACULTY));
            Printer.printStudents(university.getListStudentsAllFacultyAllCourses());
            Printer.printStudents(university.getListStudentsBornAfter(REQUIRED_DATE));
            Printer.printStudents(university.getListStudentsGroup(REQUIRED_GROUP));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}