package db;

import db.queries.Student;

import java.util.ArrayList;
import java.util.List;

public class Execute {
    public static void main(String[] args) {
        List<String[]> data = new ArrayList<>();
        String[] a = {"1", "Joe", "Dou"};
        String[] b = {"2", "Susi", "Monro"};
        data.add(a);
        data.add(b);
        Queries< Student > queries = new Queries<Student>();
        List<Student> select = queries.select(data, new Student());
        System.out.println(select.get(0).getName());
    }
}
