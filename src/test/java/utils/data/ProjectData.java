package utils.data;

public class ProjectData {
    public static String value(String key){
        return PropertyReader.get().readValue(key);
    }
}
