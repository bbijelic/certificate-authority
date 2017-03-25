package com.github.bbijelic.ca.security.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Digest utils
 * 
 * @author Bojan Bijelić
 */
public class DigestUtils {

    /**
     * Calculates digest based on selected algorithm on the payload
     * 
     * @param algorithm the algorithm
     * @param payload the payload
     * 
     * @throws DigestUtilsException
     */
    public static String digest(SupportedDigestAlgorithms algorithm, String payload) throws DigestUtilsException {
        
        byte byteData[];
        
        try {
            
            MessageDigest md = MessageDigest.getInstance(algorithm.getValue());
            md.update(payload.getBytes());
            byteData = md.digest();
            
        } catch (NoSuchAlgorithmException nsae){           
            throw new DigestUtilsException("Digest failed: " + nsae.getMessage(), nsae);
        }
        
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        
        return sb.toString();
        
    }
    
}
