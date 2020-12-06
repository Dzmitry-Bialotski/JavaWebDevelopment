package by.belotskiy.bsuir.model.dao.repository;

import by.belotskiy.bsuir.exception.StorageException;
import by.belotskiy.bsuir.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static StudentRepository studentRepositoryInstance;
    private final List<Student> studentList;

    private StudentRepository(){
        studentList = new ArrayList<>();
    }

    public static StudentRepository getInstance() {
        if(studentRepositoryInstance == null){
            studentRepositoryInstance = new StudentRepository();
        }
        return studentRepositoryInstance;
    }

    public boolean contains(Student student) {
        for (Student st : studentList){
            if(st.equals(student)){
                return true;
            }
        }
        return false;
    }

    public boolean addStudent(Student student){
        return studentList.add(student);
    }

    public Student getStudent(int index){
        return studentList.get(index);
    }

    public void setStudent(int index, Student student){
        studentList.set(index, student);
    }

    public int getSize() {
        return studentList.size();
    }

    public void removeStudent(int index) throws StorageException{
        if(index < 0 || index >= studentList.size()){
            throw new StorageException("Invalid index " + index);
        }
        studentList.remove(index);
    }
}
