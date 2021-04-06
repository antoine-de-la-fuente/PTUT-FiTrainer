package com.ptut.fitrainer;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;


/**
 * Created by javainterviewpoint.com at
 * https://www.javainterviewpoint.com/rsa-encryption-and-decryption/
 */

public class RSAPasswordEncryption {

    private PublicKey publicKey;
    private PrivateKey privateKey;
    private byte[] cipherTextArray;

    public RSAPasswordEncryption(String passwd) throws Exception {
        // Get an instance of the RSA key generator
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(4096);

        // Generate the KeyPair
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Get the public and private key
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();

        // Decryption
        String decryptedText = decrypt(cipherTextArray, privateKey);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");

        //Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, this.publicKey);

        //Perform Encryption
        this.cipherTextArray = cipher.doFinal(plainText.getBytes()) ;
        String encryptedText = Base64.getEncoder().encodeToString(this.cipherTextArray);

        return encryptedText;
    }

    public String decrypt(byte[] cipherTextArray, PrivateKey privateKey) throws Exception
    {
        //Get Cipher Instance RSA With ECB Mode and OAEPWITHSHA-512ANDMGF1PADDING Padding
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");

        //Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, this.privateKey);

        //Perform Decryption
        byte[] decryptedTextArray = cipher.doFinal(cipherTextArray);

        return new String(decryptedTextArray);
    }
}
