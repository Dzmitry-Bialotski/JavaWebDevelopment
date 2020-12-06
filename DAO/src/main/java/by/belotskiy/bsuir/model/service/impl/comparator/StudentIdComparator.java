package by.belotskiy.bsuir.model.service.impl.comparator;

import by.belotskiy.bsuir.model.entity.Student;

import java.util.Comparator;

public class StudentIdComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
