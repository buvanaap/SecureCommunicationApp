import java.sql.Connection;
import java.sql.PreparedStatement;

public class MessageSaver {
    public static void saveMessage(String encryptedMessage) {
        String insertSQL = "INSERT INTO messages (message) VALUES (?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, encryptedMessage);
            preparedStatement.executeUpdate();

            System.out.println("Message saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
