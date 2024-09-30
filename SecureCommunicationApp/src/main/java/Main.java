import javax.crypto.SecretKey;

import com.example.security.EncryptionUtil;

public class Main {
    public static void main(String[] args) {
        try {
            // Generate a secret key
            SecretKey secretKey = EncryptionUtil.generateKey();

            // Message to be encrypted
            String message = "This is a secret message.";

            // Encrypt the message
            String encryptedMessage = EncryptionUtil.encrypt(message, secretKey);

            // Save the encrypted message to the database
            MessageSaver.saveMessage(encryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
