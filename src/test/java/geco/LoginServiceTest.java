package geco;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LoginServiceTest {

    String exempleLogin = "RAND";
    String[] logins = new String[0];
    LoginService l = new LoginService(logins);

    @Test
    public void loginExists() throws Exception {
        assertThat(l.loginExists(exempleLogin), is(false));
    }

    @Test
    public void addLogin() throws Exception {
        l.addLogin(exempleLogin);
        assertThat(l.loginExists(exempleLogin), is(true));
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {

        l.addLogin("RASP");
        l.addLogin("LTUR");
        l.addLogin(exempleLogin);

        List<String> expected = new ArrayList<String>();
        expected.add("RASP");
        expected.add(exempleLogin);

        ArrayList<String> actual = (ArrayList<String>) l.findAllLoginsStartingWith("RA");
        assertThat(actual, is(expected));

    }

    @Test
    public void findAllLogins() throws Exception {
        List<String> expected = new ArrayList<String>();
        expected.add("RASP");
        expected.add("LTUR");
        expected.add(exempleLogin);

        l.addLogin("RASP");
        l.addLogin("LTUR");
        l.addLogin(exempleLogin);

        ArrayList<String> actual = (ArrayList<String>) l.findAllLogins();
        assertThat(actual, is(expected));
    }

}