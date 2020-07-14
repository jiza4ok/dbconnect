package utils.api;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Convertions <T> {
    public List<T> convertJsonToObjects(Convertible<T> obj, String json){
        JSONArray jsonArr = new JSONArray(json);
        List<T> result = new ArrayList<>();
        for (int i = 0; i < jsonArr.length(); i++)
        {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            result.add(obj.convert(jsonObj));
        }
        return result;
    }

    public T convertJsonToObject(Convertible<T> obj, String json) {
        JSONArray jsonArr = new JSONArray(json);
        List<T> result = new ArrayList<>();
        for (int i = 0; i < jsonArr.length(); i++)
        {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            result.add(obj.convert(jsonObj));
        }
        return result.get(0);

    }

    public String getParameterValue(String json, String parameterName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        return jsonNode.get(parameterName).asText();
    }

    public void convertObjectToJson(List < Convertible<T> > list, File file) throws IOException {
        if (list!=null){
            ObjectMapper objectMapper = new ObjectMapper();
            for(int i=0; i<list.size(); i++) {
                objectMapper.writeValue(file, list.get(i));
            }
        }
    }

    public String JsonStringFromObject(List < Convertible<T> > list) throws IOException {
        if (list!=null){
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonInString = null;
            for(int i=0; i<list.size(); i++) {
                jsonInString += objectMapper.writeValueAsString(list.get(i));
            }
            return jsonInString;
        }
        return null;
    }


}
