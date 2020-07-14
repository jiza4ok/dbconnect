package api.requests;

import api.base_requests.Get;
import lombok.extern.slf4j.Slf4j;
import api.objects.Contributor;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import lombok.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Contributors extends AbstractRequest{
    private final String URL = "https://api.github.com/alhonchar/academylessons/contributors";
    //TestConfigurations.getApiUri()+"/"+getClass().getSimpleName()
    public String getRequestBody(){
        return get.withoutAuth( 200, URL).getBody().asString();
    }
    //TestConfigurations.getApiToken()
    public List< Contributor > getContributors(String jsonArray) throws IOException {
        if (jsonArray!=null) {
            ObjectMapper objectMapper = new ObjectMapper();
            List< Contributor > contributors = objectMapper.readValue(jsonArray,
                    new TypeReference< ArrayList< Contributor > >() {});
            return contributors;
        }
        return null;
    }

    public void logContributorsWithCommits(List<Contributor> contributors){
        if (contributors!=null) {
            for (int i = 0; i < contributors.size(); i++) {
                String name = contributors.get(i).getLogin();
                int contributions = contributors.get(i).getContributions();
                log.info("Contributor " + name + " has" + contributions + " commits");
            }
        }
        log.info("there is no contributors found");
    }
}
