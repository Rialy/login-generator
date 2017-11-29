package geco;

import org.junit.Test;

import java.util.UUID;

import static geco.PasswordGeneration.getRandomPassword;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PasswordGenerationTest {

    @Test
    public void getRandomPasswordTest() throws Exception {
        String test = getRandomPassword();
        assertThat(test.length(), is(8));
    }
}