/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaweb.services;




import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EnDeCryption {

    static DESKeySpec keySpec;
    static SecretKeyFactory keyFac;
    static SecretKey key;

    static BASE64Encoder base64En;
    static BASE64Decoder base64De;

    public EnDeCryption(String pwd) {

        try {
            keySpec = new DESKeySpec(pwd.getBytes("UTF8"));
            keyFac = SecretKeyFactory.getInstance("DES");
            key = keyFac.generateSecret(keySpec);
            base64En = new BASE64Encoder();
            base64De = new BASE64Decoder();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException ex) {
            Logger.getLogger(EnDeCryption.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String encoding(String clearText) {
        String tmp = "";
        try {
            byte[] arrClearText = clearText.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            tmp = base64En.encode(cipher.doFinal(arrClearText));
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException ex) {
            Logger.getLogger(EnDeCryption.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return tmp;
        }

    }

    public String decoding(String cryptText) {
        String tmp = "";
        try {
            byte[] arrCryptText = base64De.decodeBuffer(cryptText);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] arrClearText = cipher.doFinal(arrCryptText);
            tmp = new String(arrClearText);
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IOException ex) {
            Logger.getLogger(EnDeCryption.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return tmp;
        }
    }

    public DESKeySpec getKeySpec() {
        return keySpec;
    }

    public SecretKeyFactory getKeyFac() {
        return keyFac;
    }

    public SecretKey getKey() {
        return key;
    }

    public BASE64Encoder getBase64En() {
        return base64En;
    }

    public BASE64Decoder getBase64De() {
        return base64De;
    }

    public void setKeySpec(DESKeySpec keySpec) {
        this.keySpec = keySpec;
    }

    public void setKeyFac(SecretKeyFactory keyFac) {
        this.keyFac = keyFac;
    }

    public void setKey(SecretKey key) {
        this.key = key;
    }

    public void setBase64En(BASE64Encoder base64En) {
        this.base64En = base64En;
    }

    public void setBase64De(BASE64Decoder base64De) {
        this.base64De = base64De;
    }
}