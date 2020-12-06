package by.belotskiy.bsuir.model.service.impl.comparator;

import by.belotskiy.bsuir.model.entity.Student;

import java.util.Comparator;

public class StudentSurnameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
