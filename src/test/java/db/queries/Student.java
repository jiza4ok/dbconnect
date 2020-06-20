package db.queries;

import db.Convert;
import lombok.Data;

import java.util.List;

@Data
public class Student implements Convert<Student> {
    Integer id;
    String name;
    String surname;

    @Override
    public Student convert(List<String[]> result, int i) {
        Student student = new Student();
        student.setId(new Integer(result.get(i)[0]));
        student.setName(result.get(i)[1]);
        student.setSurname(result.get(i)[2]);
        return student;
    }
}
