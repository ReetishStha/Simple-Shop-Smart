import org.mindrot.jbcrypt.BCrypt;

public class Main {
    public static void main(String[] args) {
        String password = "admin123";

        // Generate salt and hash password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        // Print the hashed password
        System.out.println("Plain Password: " + password);
        System.out.println("Hashed Password: " + hashedPassword);
    }
}
