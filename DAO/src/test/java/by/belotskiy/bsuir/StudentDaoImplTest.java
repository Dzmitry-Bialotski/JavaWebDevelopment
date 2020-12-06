package by.belotskiy.bsuir;

import by.belotskiy.bsuir.exception.DaoException;
import by.belotskiy.bsuir.model.dao.impl.StudentDaoImpl;
import by.belotskiy.bsuir.model.entity.Student;
import by.belotskiy.bsuir.model.reader.StudentReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class StudentDaoImplTest
{
    private static StudentDaoImpl studentDao = StudentDaoImpl.getInstance();

    @Test
    public void testFindAll(){
        try {
            studentDao.add(new Student());
        } catch(DaoException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(studentDao.findAll().size(), 1);
    }
    @Test
    public void testFindById() {
        try {
            studentDao.add(new Student());
        } catch(DaoException e) {
            e.printStackTrace();
        }
        Optional<Student> student = studentDao.findById(1);
        Assert.assertEquals(student.get().getId(), 1);
    }
    @Test
    public void testFindByGroup() {
        StudentReader reader = new StudentReader();
        try{
            reader.readFromFile(null);
        }
        catch(DaoException e){
            e.printStackTrace();
        }
        Assert.assertEquals(studentDao.findByGroup(2).size(),4);
    }
}
