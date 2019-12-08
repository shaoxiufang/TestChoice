package myTest;

import java.awt.Choice;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UserRegister extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	
	FileWriter writer=null;
	StringBuffer stringBuffer=new StringBuffer();
	JTextField zhuname;
	JTextField zhupwd;
	
	public UserRegister(){
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("用户注册页面");
		setBounds(500, 300, 0, 0);
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		//用户名
		JLabel jl=new JLabel("用户名：");
		jl.setBounds(10, 10, 200, 18);
		zhuname=new JTextField(10);
		zhuname.setBounds(80, 10, 150, 18);
		
		cp.add(jl);
		cp.add(zhuname);
		
		//密码
		JLabel jl2=new JLabel("密码：");
		jl2.setBounds(10, 50, 200, 18);
		zhupwd=new JTextField(10);
		zhupwd.setBounds(80, 50, 150, 18);
		
		cp.add(jl2);
		cp.add(zhupwd);
		
		//注册按钮事件
		JButton jb=new JButton("注册");
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//当用户名或密码输入为空时，弹出提示信息
				if(zhuname.getText().trim().length()==0||zhupwd.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
					return;
				}
				if(zhuname.getText().trim().length()>=8||zhupwd.getText().trim().length()>=6){
					JOptionPane.showMessageDialog(null, "用户名不得超过八位，密码不得超过六位");
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "注册成功,点击确定后登录");
					writeFile();
					UserLogin userLogin=new UserLogin();
					return;
				}
				}
			});
		jb.setBounds(80, 150, 60, 18);
		cp.add(jb);

		//为重置按钮添加监听事件
		final JButton button = new JButton();
		button.setText("重置");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//动作触发时，将用户名和密码设置为空
				zhuname.setText("");
				zhupwd.setText("");
				//repassword.setText("");
				
			}
		});
		button.setBounds(150, 80, 60, 18);
		getContentPane().add(button);	
	}
	
	public void writeFile(){
		try {
			writer = new FileWriter("D:/info/userinfo.txt");// 创建文件输出流对象
			stringBuffer.append("用户信息为：\n").append("用户名："+zhuname.getText()).append(
					"密码："+zhupwd.getText());
            writer.write(stringBuffer.toString());// 
            writer.flush();
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

	}
