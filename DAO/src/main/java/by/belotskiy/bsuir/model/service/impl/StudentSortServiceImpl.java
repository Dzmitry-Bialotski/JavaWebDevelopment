package by.belotskiy.bsuir.model.service.impl;

import by.belotskiy.bsuir.model.dao.impl.StudentDaoImpl;
import by.belotskiy.bsuir.model.entity.Student;
import by.belotskiy.bsuir.model.service.StudentSortService;
import by.belotskiy.bsuir.model.service.impl.comparator.StudentIdComparator;
import by.belotskiy.bsuir.model.service.impl.comparator.StudentSurnameComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StudentSortServiceImpl implements StudentSortService {
    private static final Logger logger  = LogManager.getLogger();
    private static final StudentDaoImpl studentDao = StudentDaoImpl.getInstance();

    @Override
    public void sortById() {
        StudentIdComparator idComparator = new StudentIdComparator();
        List<Student> studentList = studentDao.findAll();
        studentList.sort(idComparator);
        for(int i =0; i < studentList.size();i++){
            studentDao.update(i, studentList.get(i));
        }
        logger.info("Student repository was sorted by Id");
    }

    @Override
    public void sortBySurname() {
        StudentSurnameComparator surnameComparator = new StudentSurnameComparator();
        List<Student> studentList = studentDao.findAll();
        studentList.sort(surnameComparator);
        for(int i =0; i < studentList.size();i++){
            studentDao.update(i, studentList.get(i));
        }
        logger.info("Student repository was sorted by Surname");
    }
}
