package by.belotskiy.bsuir.model.dao;

import by.belotskiy.bsuir.exception.DaoException;
import by.belotskiy.bsuir.exception.StorageException;
import by.belotskiy.bsuir.model.entity.Faculty;
import by.belotskiy.bsuir.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> findAll();
    Optional<Student> findById(int id);
    List<Student> findByFaculty(Faculty faculty);
    List<Student> findByFacultyAndCourse(Faculty faculty, int course);
    List<Student> findByGroup(int group);
    boolean update(int id, Student student) throws StorageException;
    boolean delete(int id) throws DaoException, StorageException;
    void add(Student student) throws DaoException;
}
