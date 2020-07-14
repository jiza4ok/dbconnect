package api.objects;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.json.JSONException;
import org.json.JSONObject;
import utils.api.Convertible;


@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "name",
            "section",
            "description",
            "color",
            "size",
            "price",
            "params"
    })
public class Result implements Convertible<Result> {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("section")
    private String section;
    @JsonProperty("description")
    private String description;
    @JsonProperty("color")
    private String color;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("params")
    private String params;
    @JsonIgnore
    private Map< String, Object > additionalProperties = new HashMap< String, Object >();

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("section")
        public String getSection() {
            return section;
        }

        @JsonProperty("section")
        public void setSection(String section) {
            this.section = section;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("color")
        public String getColor() {
            return color;
        }

        @JsonProperty("color")
        public void setColor(String color) {
            this.color = color;
        }

        @JsonProperty("size")
        public Integer getSize() {
            return size;
        }

        @JsonProperty("size")
        public void setSize(Integer size) {
            this.size = size;
        }

        @JsonProperty("price")
        public Double getPrice() {
            return price;
        }

        @JsonProperty("price")
        public void setPrice(String price) {
        this.price = new Double(price);
        }

        @JsonProperty("params")
        public String getParams() {
            return params;
        }

        @JsonProperty("params")
        public void setParams(String params) {
            this.params = params;
        }

        @JsonAnyGetter
        public Map< String, Object > getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public Result convert(JSONObject result) {
            Result good = new Result();
            good.setId(result.getString("id"));
            good.setName(result.getString("name"));
            good.setSection(result.getString("section"));
            try {
                good.setDescription(result.getString("description"));
            } catch (JSONException e) {}
            try {
                good.setColor(result.getString("color"));
            } catch (JSONException e) {}
            try {
                good.setSize(result.getInt("size"));
            } catch (JSONException e) {}
            try {
            good.setPrice(result.getString("price"));
            } catch (JSONException e){}
            try {
                good.setParams(result.getString("params"));
            } catch (JSONException e){}
            return good;
        }

}
