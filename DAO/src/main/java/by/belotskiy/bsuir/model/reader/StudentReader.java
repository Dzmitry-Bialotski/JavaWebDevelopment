package by.belotskiy.bsuir.model.reader;

import by.belotskiy.bsuir.exception.DaoException;
import by.belotskiy.bsuir.model.dao.impl.StudentDaoImpl;
import by.belotskiy.bsuir.model.entity.Faculty;
import by.belotskiy.bsuir.model.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StudentReader {
    private static Logger logger = LogManager.getLogger();
    private static final String FILE_PATH = "res/data/Students.txt";
    private StudentDaoImpl studentDao = StudentDaoImpl.getInstance();
    public void readFromFile(String filepath) throws DaoException {
        if(filepath == null){
            filepath = FILE_PATH;
        }
        List<Student> result = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filepath));
            String name;
            String surname;
            String patronymic;
            Calendar birthday;
            String address;
            String phoneNumber;
            Faculty faculty;
            int course;
            int group;
            int year, month, day;
            while (scanner.hasNextLine()) {
                String studentInfo = scanner.nextLine();
                String[] studentFields = studentInfo.split(";");
                name = studentFields[0];
                surname = studentFields[1];
                patronymic = studentFields[2];
                year = Integer.parseInt(studentFields[3]);
                month = Integer.parseInt(studentFields[4]);
                day = Integer.parseInt(studentFields[5]);
                birthday = new GregorianCalendar(year, month, day);
                address = studentFields[6];
                phoneNumber = studentFields[7];
                faculty = Faculty.valueOf(studentFields[8]);
                course = Integer.parseInt(studentFields[9]);
                group = Integer.parseInt(studentFields[10]);
                Student student = new Student(name, surname, patronymic, birthday, address, phoneNumber, faculty,
                        course, group);
                result.add(student);
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found ", e);
        } finally {
            scanner.close();
        }
        logger.info("Generated list of students");
        for(Student st : result){
            studentDao.add(st);
        }
    }
}
