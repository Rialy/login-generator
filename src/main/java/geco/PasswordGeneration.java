package geco;

import java.util.UUID;

public class PasswordGeneration {

    public static String getRandomPassword(){
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8);
    }
}
