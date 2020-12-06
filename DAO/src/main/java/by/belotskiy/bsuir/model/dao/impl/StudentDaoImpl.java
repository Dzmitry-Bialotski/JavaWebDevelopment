package by.belotskiy.bsuir.model.dao.impl;

import by.belotskiy.bsuir.exception.DaoException;
import by.belotskiy.bsuir.exception.StorageException;
import by.belotskiy.bsuir.model.dao.StudentDao;
import by.belotskiy.bsuir.model.dao.repository.StudentRepository;
import by.belotskiy.bsuir.model.entity.Faculty;
import by.belotskiy.bsuir.model.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao {

    private static Logger logger = LogManager.getLogger();
    private static StudentDaoImpl studentDaoInstance;
    private static StudentRepository studentRepository = StudentRepository.getInstance();

    private StudentDaoImpl() {

    }

    public static StudentDaoImpl getInstance(){
        if(studentDaoInstance == null) {
            studentDaoInstance = new StudentDaoImpl();
        }
        return studentDaoInstance;
    }
    @Override
    public List<Student> findAll() {
        List<Student> result = new ArrayList<>();
        for(int i =0; i < studentRepository.getSize();i++){
            result.add(studentRepository.getStudent(i));
        }
        logger.info("return all students");
        return result;
    }

    @Override
    public Optional<Student> findById(int id) {
        Optional<Student> result = Optional.empty();
        for(int i =0; i < studentRepository.getSize();i++){
            if(studentRepository.getStudent(i).getId() == id){
                result = Optional.of(studentRepository.getStudent(i));
                break;
            }
        }
        logger.info("search by Id ended");
        return result;
    }

    @Override
    public List<Student> findByFaculty(Faculty faculty) {
        List<Student> result = new ArrayList<>();
        for(int i =0; i < studentRepository.getSize();i++){
            Student student = studentRepository.getStudent(i);
            if(faculty.equals(student.getFaculty())) {
                result.add(student);
            }
        }
        logger.info("return students by faculty");
        return result;
    }

    @Override
    public List<Student> findByFacultyAndCourse(Faculty faculty, int course) {
        List<Student> result = new ArrayList<>();
        for(int i =0; i < studentRepository.getSize();i++){
            Student student = studentRepository.getStudent(i);
            if(faculty.equals(student.getFaculty()) && course == student.getCourse()) {
                result.add(student);
            }
        }
        logger.info("return students by faculty and course");
        return result;
    }

    @Override
    public List<Student> findByGroup(int group) {
        List<Student> result = new ArrayList<>();
        for(int i =0; i < studentRepository.getSize();i++){
            Student student = studentRepository.getStudent(i);
            if(group == student.getGroup()) {
                result.add(student);
            }
        }
        logger.info("return students by group");
        return result;
    }

    @Override
    public boolean update(int id, Student student) {
        boolean isUpdated = false;
        for(int i =0; i < studentRepository.getSize(); i++){
            if(id == studentRepository.getStudent(i).getId()){
                studentRepository.setStudent(i, student);
                isUpdated = true;
                break;
            }
        }
        logger.info("update element", id);
        return isUpdated;
    }

    @Override
    public boolean delete(int id) throws DaoException, StorageException {
        if(!findById(id).isPresent()) {
            throw new DaoException("no student with id " + id);
        }
        boolean isDeleted = false;
        for(int i = 0; i < studentRepository.getSize(); i++) {
            if(id == studentRepository.getStudent(i).getId()) {
                studentRepository.removeStudent(i);
                isDeleted = true;
                break;
            }
        }
        logger.info("delete element ", id);
        return isDeleted;
    }

    @Override
    public void add(Student student) throws DaoException {
        if(studentRepository.contains(student)) {
            throw new DaoException("The object is already in the collection (add(Car car))");
        }
        logger.info("add student ", student.toString());
        studentRepository.addStudent(student);
    }

}
