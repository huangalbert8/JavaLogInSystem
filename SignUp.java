import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {
    private JLabel EmailSU;
    private JLabel PasswordSU;
    private JLabel PasswordCSU;
    private JTextField EmailSUin;
    private JTextField PasswordSUin;
    private JTextField PasswordCSUin;
    private JButton signUp;
    private JPanel mainPanel;
    private JLabel Success;

    public SignUp(String title) {
        super(title);
        this.setContentPane(mainPanel);
        this.pack();


        signUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = EmailSUin.getText();
                String password = PasswordSUin.getText();
                String confirm_password = PasswordCSUin.getText();
                if(confirm_password.equals(password)&&email.contains("@"))
                if(LogIn.signUp(email,password))
                    Success.setText("Successful Sign Up.");
                else
                    Success.setText("Unsuccessful Sign Up.");
            }
        });
    }
}