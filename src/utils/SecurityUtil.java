/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter; // Java 8 Base64 alternative
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import javax.crypto.spec.IvParameterSpec;


/**
 *
 * @author John Patrick
 */
public class SecurityUtil {
    private final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private final int KEY_SIZE = 128; // Changed to 128 for better compatibility
    private final int IV_LENGTH = 16; // CBC mode uses 16 byte IV
    private final SecretKey key;

    public SecurityUtil() throws Exception {
        this.key = generateKey();
    }

    private SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(KEY_SIZE);
        return keyGenerator.generateKey();
    }

    private String encrypt(String plaintext) throws Exception {
        if (plaintext == null || plaintext.isEmpty()) {
            return "";
        }

        // Generate random IV
        byte[] iv = new byte[IV_LENGTH];
        new SecureRandom().nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        
        // Initialize cipher
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

        // Encrypt
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());

        // Combine IV and ciphertext
        ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + ciphertext.length);
        byteBuffer.put(iv);
        byteBuffer.put(ciphertext);
        
        // Convert to Base64
        return DatatypeConverter.printBase64Binary(byteBuffer.array());
    }

    private String decrypt(String encryptedText) throws Exception {
        if (encryptedText == null || encryptedText.isEmpty()) {
            return "";
        }

        // Decode from Base64
        byte[] decoded = DatatypeConverter.parseBase64Binary(encryptedText);

        // Extract IV
        ByteBuffer byteBuffer = ByteBuffer.wrap(decoded);
        byte[] iv = new byte[IV_LENGTH];
        byteBuffer.get(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        
        // Extract ciphertext
        byte[] ciphertext = new byte[byteBuffer.remaining()];
        byteBuffer.get(ciphertext);

        // Initialize cipher
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

        // Decrypt
        return new String(cipher.doFinal(ciphertext));
    }

    // Public methods
    public String encryptText(String text) throws Exception {
        return encrypt(text);
    }

    public String decryptText(String encryptedText) throws Exception {
        return decrypt(encryptedText);
    }
}
