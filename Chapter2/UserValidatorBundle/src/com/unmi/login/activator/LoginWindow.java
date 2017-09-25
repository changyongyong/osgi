package com.unmi.login.activator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.unmi.login.service.Validator;

public class LoginWindow extends JFrame {

	BundleContext bundleContext;
	private JTextField jftUser;
	private JPasswordField jpfPassword;
	JButton panicButton, okButton;
	JTextArea jta;
	JTextArea resultJta;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("Hello world!");

		LoginWindow frame = new LoginWindow();
		/*frame.setSize(800,600);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		frame.setBackground(Color.GREEN);  
		frame.setVisible(true);*/
	}

	public LoginWindow() {
		setTitle("登录窗口");

		jta = new JTextArea();
		resultJta = new JTextArea();
		jta.setText("登录结果：");
		JPanel resultPan = new JPanel();
		resultPan.setLayout(new GridLayout(2, 1));
		resultPan.add(jta);
		resultPan.add(resultJta);
		/*setBackground(Color.RED);  
		setForeground(Color.black);  
		  
		JPanel p1 = new JPanel();  
		p1.setLayout(new FlowLayout());  
		p1.add(new JLabel("用户名"));*/
		JPanel jpLables = new JPanel();
		jpLables.setLayout(new GridLayout(2, 1));
		jpLables.add(new JLabel("用户名"));
		jpLables.add(new JLabel("密码"));

		JPanel jpTextFields = new JPanel();
		jpTextFields.setLayout(new GridLayout(2, 1));
		jpTextFields.add(jftUser = new JTextField(10));
		jpTextFields.add(jpfPassword = new JPasswordField(10));

		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(jpLables, BorderLayout.WEST);
		p1.add(jpTextFields, BorderLayout.CENTER);

		JPanel jpButton = new JPanel();
		jpButton.setLayout(new GridLayout(1, 2));
		jpButton.add(okButton = new JButton("登录"));
		jpButton.add(panicButton = new JButton("重置"));

		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(jpButton, BorderLayout.CENTER);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(p1, BorderLayout.CENTER);
		getContentPane().add(p2, BorderLayout.SOUTH);
		getContentPane().add(resultPan, BorderLayout.NORTH);

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ServiceReference serviceRef =
						bundleContext.getServiceReference(Validator.class.getCanonicalName());
				System.out.println("ok");
				Validator validator = (Validator) bundleContext.getService(serviceRef);
				try {
					boolean result = validator.validate(jftUser.getText(), jpfPassword.getText());
					System.out.println("登录结果：" + result);
					if (result) {
						resultJta.setText("成功");
					} else {
						resultJta.setText("失败");
					}
				} catch (Exception e1) {
				}
			}

		});

		setSize(500, 300);
		setBackground(Color.GREEN);
		setVisible(true);
	}

	public BundleContext getBundleContext() {
		return bundleContext;
	}

	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
	}

}
