package javatasks.classes.maintask.university;

import javatasks.classes.maintask.student.Student;

class UniversityChecker {
    static boolean checkLength(Student[] students) {
        boolean flag = true;
        if (students[students.length - 1] != null) {
            flag = false;
        }
        return flag;
    }

    static int getPosition(Student[] students) {
        int position = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                position = i;
                break;
            }
        }
        return position;
    }
}
