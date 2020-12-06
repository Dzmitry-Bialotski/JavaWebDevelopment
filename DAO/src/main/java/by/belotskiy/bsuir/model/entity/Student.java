package by.belotskiy.bsuir.model.entity;

import by.belotskiy.bsuir.util.IdGenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Student {
    private int id = IdGenerator.getId();
    private String name;
    private String surname;
    private String patronymic;
    private Calendar birthday;
    private String address;
    private String phoneNumber;
    private Faculty faculty;
    private int course;
    private int group;

    public Student() {

    }
    public Student(String name, String surname, String patronymic, Calendar birthday, String address,
                   String phoneNumber, Faculty faculty, int course, int group){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return  getId() == student.getId() &&
                getCourse() == student.getCourse() &&
                getGroup() == student.getGroup() &&
                getName().equals(student.getName()) &&
                getSurname().equals(student.getSurname()) &&
                getPatronymic().equals(student.getPatronymic()) &&
                getBirthday().equals(student.getBirthday()) &&
                getAddress().equals(student.getAddress()) &&
                getPhoneNumber().equals(student.getPhoneNumber()) &&
                getFaculty().equals(student.getFaculty());
    }

    @Override
    public int hashCode() {
        final int multiplier = 31;
        int result = id;
        result = multiplier * result + (name != null ? name.hashCode() : 0);
        result = multiplier * result + (surname != null ? surname.hashCode() : 0);
        result = multiplier * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = multiplier * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = multiplier * result + group;
        result = multiplier * result + (faculty != null ? faculty.hashCode() : 0);
        result = multiplier * result + course;
        result = multiplier * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", patronymic=").append(patronymic);
        sb.append(", birthday=").append(birthday);
        sb.append(", address=").append(address);
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", faculty=").append(faculty);
        sb.append(", course=").append(course);
        sb.append(", group='").append(group).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
