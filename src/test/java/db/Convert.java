package db;

import java.util.List;

public interface Convert<T> {
    public T convert(List<String[]> result, int i);
}
