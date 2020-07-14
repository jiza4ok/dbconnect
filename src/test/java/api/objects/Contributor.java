package api.objects;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonProperty;

public class Contributor {
    @JsonProperty("login")
    @Setter @Getter String login;
    @JsonProperty("id")
    @Setter @Getter int id;
    @JsonProperty("node_id")
    @Setter @Getter String node_id;
    @JsonProperty("id")
    @Setter @Getter String avatar_url;
    @Setter @Getter String gavatar_url;
    @Setter @Getter String html_url;
    @Setter @Getter String followers_url;
    @Setter @Getter String following_url;
    @Setter @Getter String gists_url;
    @Setter @Getter String starred_url;
    @Setter @Getter String subscriptions_url;
    @Setter @Getter String organizations_url;
    @Setter @Getter String repos_url;
    @Setter @Getter String events_url;
    @Setter @Getter String received_events_url;
    @Setter @Getter String type;
    @Setter @Getter Boolean site_admin;
    @Setter @Getter int contributions;

    public Contributor(String login, int id, String node_id, String avatar_url, String gavatar_url,
                       String html_url, String followers_url, String following_url, String gists_url,
                       String starred_url, String subscriptions_url, String organizations_url, String repos_url,
                       String events_url, String received_events_url, String type, Boolean site_admin,
                       int contributions) {
        this.login = login;
        this.id = id;
        this.node_id = node_id;
        this.avatar_url = avatar_url;
        this.gavatar_url = gavatar_url;
        this.html_url = html_url;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.gists_url = gists_url;
        this.starred_url = starred_url;
        this.subscriptions_url = subscriptions_url;
        this.organizations_url = organizations_url;
        this.repos_url = repos_url;
        this.events_url = events_url;
        this.received_events_url = received_events_url;
        this.type = type;
        this.site_admin = site_admin;
        this.contributions = contributions;
    }
}
