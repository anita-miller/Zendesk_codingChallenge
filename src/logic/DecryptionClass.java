package logic;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/**
 * @author anitanaseri
 *
 */
class DecryptionClass {

    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "ADBSJHJS12547896".getBytes();

    /**
     * @param args
     * @throws Exception
     */

    public String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);


        byte[] decordedValue = Base64.getDecoder().decode(encryptedValue.getBytes());
        
        String decryptedVal = new String(c.doFinal(decordedValue));
        
        
        return decryptedVal;
        
    }

    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }

}
