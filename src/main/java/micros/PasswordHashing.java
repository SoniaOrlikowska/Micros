package micros;

import java.security.MessageDigest;
import java.util.Arrays;

public class PasswordHashing {

    String password;

    public String HashPassword(String password) {
        this.password = password;
        //Converting the byte array in to HexString format
        StringBuilder hexString = new StringBuilder();
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //Passing data to the created MessageDigest Object
            md.update(password.getBytes());

            //Compute the message digest
            byte[] digest = md.digest();
            System.out.println(Arrays.toString(digest));


            for (byte b : digest) {
                hexString.append(Integer.toHexString(0xFF & b));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return hexString.toString();
    }


}
