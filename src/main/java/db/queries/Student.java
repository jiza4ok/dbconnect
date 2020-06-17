package db.queries;

import db.Convert;
import db.QueryResult;

import java.util.List;

public class Student implements Convert<Student> {
    Integer id;
    String name;
    String surname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public Student convert(List< String[] > result, int i) {
        Student student = new Student();
        student.setId(new Integer (result.get(i)[0]));
        student.setName(result.get(i)[1]);
        student.setSurname(result.get(i)[2]);
        return student;
    }

    /*@Override
    public Student convert(QueryResult qr, int i) {
        Student student = new Student();
        student.setId(new Integer (qr.getBody().get(i)[0]));
        student.setName(qr.getBody().get(i)[1]);
        student.setSurname(qr.getBody().get(i)[2]);
        return student;
    }*/
}
