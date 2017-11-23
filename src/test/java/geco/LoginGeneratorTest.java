package geco;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LoginGeneratorTest {

    String nomL = "accent",
        prenomL = "éxemple";
    String[] logins = new String[0];
    LoginService l = new LoginService(logins);

    /* Initialisation du login generator */
    LoginGenerator lTest = new LoginGenerator(l);

    @Test
    public void testGenerateLoginForNomAndPrenom() throws Exception {
        String sTest = lTest.generateLoginForNomAndPrenom(nomL, prenomL);
        assertThat(sTest, is("EACC"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenom2() throws Exception {
        l.addLogin("EACC");
        String sTest = lTest.generateLoginForNomAndPrenom(nomL, prenomL);
        assertThat(sTest, is("EACC1"));
    }

    @Test
    public void testPaulDurand() throws Exception {
        l = new LoginService(new String[]{"JROL", "BPER", "CGUR",  "JDUP", "JRAL", "JRAL1"});
        String sTest = lTest.generateLoginForNomAndPrenom("Durand", "Paul");
        assertThat(sTest, is("PDUR"));
    }

    @Test
    public void testJRAL2() throws Exception {
        l = new LoginService(new String[]{"JROL", "BPER", "CGUR",  "JDUP", "JRAL", "JRAL1"});
        LoginGenerator lTest = new LoginGenerator(l);
        String sTest = lTest.generateLoginForNomAndPrenom("Ralling", "John");
        assertThat(sTest, is("JRAL2"));
    }
}
