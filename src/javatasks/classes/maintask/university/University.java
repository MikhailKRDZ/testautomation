package javatasks.classes.maintask.university;

import javatasks.classes.maintask.student.Faculty;
import javatasks.classes.maintask.student.Group;
import javatasks.classes.maintask.student.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static javatasks.classes.maintask.university.UniversityCriterion.*;

public class University implements IUniversity {
    private Student[] students;

        public University(int studentsNumber) {
        students = new Student[studentsNumber];
    }

    public Student[] getStudents() {
        return students;
    }

    public ArrayList<String> getListStudentsFaculty(Faculty faculty) {
        ArrayList<Student> listStudentsRequiredFaculty = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                listStudentsRequiredFaculty.add(student);
            }
        }
        listStudentsRequiredFaculty.sort(new UniversityComparator(BY_SURNAME, BY_NAME, BY_PATRONYMIC_NAME));
        return prepareForPrinter(listStudentsRequiredFaculty, "Список студентов- Факультет:" + faculty.getFacultyRealName());
    }

    public ArrayList<String> getListStudentsAllFacultyAllCourses() {
        ArrayList<Student> listStudents = new ArrayList<>();
        Collections.addAll(listStudents, students);
        listStudents.sort(new UniversityComparator(BY_FACULTY, BY_COURSE, BY_GROUP, BY_SURNAME, BY_NAME, BY_PATRONYMIC_NAME));
        return prepareForPrinter(listStudents, "Список студентов всех фвкультетов и курсов,По факультетам и курсам");
    }

    public ArrayList<String> getListStudentsBornAfter(Date date) {
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
        ArrayList<Student> listStudentsBornAfter = new ArrayList<>();
        for (Student student : students) {
            if (student.getBirthDate().compareTo(date) >= 0) {
                listStudentsBornAfter.add(student);
            }
        }
        listStudentsBornAfter.sort(new UniversityComparator(BY_BIRTH_DATE, BY_SURNAME, BY_NAME, BY_PATRONYMIC_NAME));

        return prepareForPrinter(listStudentsBornAfter, "Список студентов родившихся после года:" + formatYear.format(date));
    }

    public ArrayList<String> getListStudentsGroup(Group group) {
        ArrayList<Student> listStudentsRequiredGroup = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup().equals(group)) {
                listStudentsRequiredGroup.add(student);
            }
        }
        listStudentsRequiredGroup.sort(new UniversityComparator(BY_SURNAME, BY_NAME, BY_PATRONYMIC_NAME));
        return prepareForPrinter(listStudentsRequiredGroup, "Список студентов Группы:" + group.getGroupRealName());
    }

    private ArrayList<String> prepareForPrinter(ArrayList<Student> students, String string) {
        ArrayList<String> studentsRequired = new ArrayList<>();
        studentsRequired.add(string);
        studentsRequired.add(students.get(0).getHeadlines());
        for (Student student : students) {
            studentsRequired.add(student.toString());
        }
        return studentsRequired;
    }


    @Override
    public void addStudent(Student student) {
        if (student.getGroup().isInGroup(student.getCourse(), student.getFaculty())) {
            if (UniversityChecker.checkLength(this.students)) {
                int position = UniversityChecker.getPosition(this.students);
                this.students[position] = student;
            } else {
                System.out.println("Error entering array size");
            }
        } else {
            System.out.println("input error Group( Course, Faculty)" + student.toString());
        }
    }
}