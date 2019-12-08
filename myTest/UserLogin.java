package myTest;

import java.awt.Choice;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class UserLogin extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	
	FileReader fileReader;
	char[] c = new char[500];
	
	JTextField name;
	JTextField password;
	String subname = null;
	String subpwd=null;
	
	UserRegister userRegister=new UserRegister();
	
	
	
	public UserLogin(){
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("�û���¼");
		setBounds(500, 300, 400,200);
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		JLabel jl=new JLabel("�û�����");
		jl.setBounds(10, 10, 200, 18);
		name=new JTextField(10);
		name.setBounds(80, 10, 150, 18);
		
		JLabel jl2=new JLabel("���룺");
		jl2.setBounds(10, 50, 200, 18);
		password=new JTextField(10);
		password.setBounds(80, 50, 150, 18);
		
		cp.add(jl);
		cp.add(name);
		cp.add(jl2);
		cp.add(password);
		
		JButton jb=new JButton("ȷ��");
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				readFile();
			}
			
		});
		jb.setBounds(80, 80, 60, 18);
		cp.add(jb);

		final JButton button = new JButton();
		button.setText("����");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				password.setText("");
			}
		});
		button.setBounds(150, 80, 60, 18);
		getContentPane().add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void readFile(){
		try {
			fileReader = new FileReader("D:/info/userinfo.txt");
			int read = fileReader.read();
			subname=name.getText();
			subpwd=password.getText();
			
			while(read!=-1){
				//System.out.print((char)read);
				read = fileReader.read();
				}
			if(fileReader.toString().contains(subname)&&fileReader.toString().contains(subpwd)){
				
				ChoiceCourse choiceCourse=new ChoiceCourse();
			}
			
			
			else {
				JOptionPane.showMessageDialog(null, "�û������������");
			}
			
			
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
	}
