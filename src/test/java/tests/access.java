package tests;

import api.objects.UserSession;
import api.requests.Requests;
import org.testng.annotations.Test;

public class access {

    Requests request = new Requests();

    @Test
    public void check_access_refresh_token() throws InterruptedException {
        UserSession session = UserSession.createSession(request.login("user", "password"));
        Thread.sleep(2000);
        if(session.isExpired())
        {
            session.refresh(request.refreshAccess(session));
        }
    }

}
