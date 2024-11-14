import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
        setLayout(new GridBagLayout());

        JLabel usernamLabel = new JLabel("Username:");
        add(usernamLabel);

        usernameField = new JTextField();
        add(usernameField);
        
    }
} 
