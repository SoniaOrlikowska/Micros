package micros;

import java.security.MessageDigest;

public class PasswordHashing {

    String password;

    public String HashPassword(String password) throws Exception  {
        this.password = password;
        //Converting the byte array in to HexString format
        StringBuilder hexString = new StringBuilder();
try {

    MessageDigest md = MessageDigest.getInstance("SHA-256");

    //Passing data to the created MessageDigest Object
    md.update(password.getBytes());

    //Compute the message digest
    byte[] digest = md.digest();
    System.out.println(digest);



    for (byte b : digest) {
        hexString.append(Integer.toHexString(0xFF & b));
    }
    System.out.println("Hex format : " + hexString.toString() + "długość" + hexString.length());


}
catch (Exception e){
    e.printStackTrace();

}
        return hexString.toString();
    }


}
