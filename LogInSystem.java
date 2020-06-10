import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInSystem extends JFrame{
    private JPanel mainPanel;
    private JTextField EmailInput;
    private JButton SignIn;
    private JPasswordField PasswordInput;
    private JLabel EmailDisplay;
    private JLabel PasswordDisplay;
    private JButton SignUp;
    private JLabel Success;

    public LogInSystem(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        SignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = EmailInput.getText();
                String password = PasswordInput.getText();
                if(LogIn.logIn(email,password))
                    Success.setText("Successful Log In.");
                else
                    Success.setText("Unsuccessful Log In.");
            }
        });
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SignUp signUp = new SignUp("Sign Up");
               signUp.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new LogInSystem("Log In Authentication");
        frame.setVisible(true);
    }
}
