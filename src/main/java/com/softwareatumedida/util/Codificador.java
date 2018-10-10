package com.softwareatumedida.util;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import sun.misc.*;

public class Codificador {

    public static void Codificador() {
    }

    public void CodificadorX(byte[] keyBytes, byte[] ivBytes, String characterEncoding) throws Exception {
        SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        this.characterEncoding = characterEncoding;
        this.encryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding", "SunJCE");
        this.encryptCipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key, iv);
        this.decryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding", "SunJCE");
        this.decryptCipher.init(javax.crypto.Cipher.DECRYPT_MODE, key, iv);
    }

    synchronized public String encrypt(String password) throws Exception {
        byte[] passwordBytes = password.getBytes(characterEncoding);
        byte[] encryptedPasswordBytes = this.encryptCipher.doFinal(passwordBytes);
        String encodedEncryptedPassword = this.base64Encoder.encode(encryptedPasswordBytes);
        return encodedEncryptedPassword;
    }

    synchronized public String decrypt(String encodedEncryptedPassword) throws Exception {
        byte[] encryptedPasswordBytes = this.base64Decoder.decodeBuffer(encodedEncryptedPassword);
        byte[] passwordBytes = this.decryptCipher.doFinal(encryptedPasswordBytes);
        String recoveredPassword = new String(passwordBytes, characterEncoding);
        return recoveredPassword;
    }

    // Simple test 
    public String CODIDECO(String args, int tipo) {
        String encodedEncryptedPassword = "";
        try {
            // Aseguramos el proveedor de java
            Security.addProvider(new com.sun.crypto.provider.SunJCE());

            // The DES EDE Key - any 24 bytes will do though beware of weak keys.
            // This could be read from a file.
            final byte[] DESedeKeyBytes = {
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10,
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,};

            // IV For CBC mode
            // Again, could be read from a file.
            final byte[] ivBytes = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07};

            // Solos caracteres ASCII
            CodificadorX(DESedeKeyBytes, ivBytes, "ASCII");

            if (tipo == 1) {
                encodedEncryptedPassword = encrypt(args);
            }
            else if (tipo == 2) {
                encodedEncryptedPassword = decrypt(args);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return encodedEncryptedPassword;
    }
    private String characterEncoding;
    private Cipher encryptCipher;
    private Cipher decryptCipher;
    private BASE64Encoder base64Encoder = new BASE64Encoder();
    private BASE64Decoder base64Decoder = new BASE64Decoder();
}


