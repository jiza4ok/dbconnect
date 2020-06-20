package db;
import java.util.ArrayList;
import java.util.List;

public class Queries<T>{
    public  List<T> select(List<String[]> body, Convert<T> converted){
        List<T> result = new ArrayList<>();
        for(int i=0; i<body.size(); i++){
            result.add(converted.convert(body, i));
        }
        return result;
    }

}
