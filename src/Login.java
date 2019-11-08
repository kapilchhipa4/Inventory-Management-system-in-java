import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private String password,username;
	private JLabel error;
	private String errorText="Invalid user name or password!";
	private JLabel lblCaddeyLogin;
	JButton btnLogin;
	private JLabel label;

	
	public static void main(String[] args) {

		
				try {

					
					Login frame = new Login();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	/**
	 * Create the frame.
	 */
	public Login()
	{
		//setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"/logo.png"));
		GUI();
	}
	void GUI()
	{
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 531, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(500, 500, 500, 500));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(154, 141, 91, 14);
		contentPane.add(lblUserName);
		
		usernameField = new JTextField();
		usernameField.setBounds(282, 140, 129, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password\r\n");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(154, 174, 91, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(282, 173, 129, 20);
		contentPane.add(passwordField);
		
		passwordField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					btnLogin.doClick();
				}
		});
		
		btnLogin = new JButton("Login");
	
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				password=passwordField.getText().toLowerCase();
				username=usernameField.getText().toLowerCase();
				passwordField.setText("");
				usernameField.setText("");
				if(password.equals("")||username.equals(""))
					error.setText(errorText);
				else
				{
					error.setText("");
					if(username.equals("admin"))
					{
						if(DB.varifyLogin(username,password))
							{
								error.setText("");
								AdminPanel p=new AdminPanel();
								p.setVisible(true);
							    
						                dispose();  
						          
							}
						else
							error.setText(errorText);
					}
					else
					{
						if(DB.varifyLogin(username,password))
						{
							error.setText("");
							generateInvoice g=new generateInvoice();
							g.setVisible(true);
						}
					else
						error.setText(errorText);
					}
					
				}
			}
		});
		btnLogin.setBounds(282, 227, 89, 23);
		contentPane.add(btnLogin);
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setBounds(104, 236, 220, 14);
		contentPane.add(error);
		
		lblCaddeyLogin = new JLabel(" Login");
		lblCaddeyLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCaddeyLogin.setBounds(204, 26, 167, 28);
		contentPane.add(lblCaddeyLogin);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Kapil\\Desktop\\New folder\\Billing\\logo.png"));
		label.setBounds(10, 11, 167, 91);
		//contentPane.add(label);
		
		
	}
	
}
