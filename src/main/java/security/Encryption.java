package logic;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author rando
 */

public class Encryption {
    
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        //Static getInstance methos is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        //digest() method called
        //to calculate message digest of an input
        //and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    
    public static String toHexString(byte[] hash) {
        //Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
        
        //Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
        
        //Pad with leading zeroes
        while(hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        
        return hexString.toString();
    }
        
    //One class version for the 512
    public static String encryptThisString(String input) throws NoSuchAlgorithmException {
        //getInstance() method is called with algorithm SHA-512
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        
        //digest() method is called
        //to calculate message digest of the input string
        //returned as array of byte
        byte[] messageDirect = md.digest(input.getBytes(StandardCharsets.UTF_8));
        
        //Convert byte array into signum representation
        BigInteger number = new BigInteger(1, messageDirect);
        
        //Convert message digest into hex value
        String hashtext = number.toString(16);
        
        //Add preceding 0s to make it 32 bit
        while(hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        
        //return hashtext
        return hashtext;
    }
}





