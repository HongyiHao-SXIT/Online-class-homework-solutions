import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAPP extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    public LoginAPP(){
        setTitle("欢迎来到扫雷");
        setSize(500,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2));

        JLabel usernamLabel = new JLabel("Username:");
        add(usernamLabel);

        usernameField = new JTextField();
        add(usernameField);
        
        JLabel passwordLabel = new JLabel("Passwords:");
        add(passwordLabel);

        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Log in");
        add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                        }
        })
    }
} 
