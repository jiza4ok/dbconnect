package utils.api;

import org.json.JSONObject;

public interface Convertible<T>{
    T convert(JSONObject result);
}