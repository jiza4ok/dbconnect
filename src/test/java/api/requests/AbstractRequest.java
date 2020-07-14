package api.requests;

import api.base_requests.Get;
import api.base_requests.Post;
import utils.api.Convertions;

public class AbstractRequest <T> {
    Get get = new Get();
    Post post = new Post();
}
