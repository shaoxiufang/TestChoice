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
		setTitle("�û�ע��ҳ��");
		setBounds(500, 300, 0, 0);
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		//�û���
		JLabel jl=new JLabel("�û�����");
		jl.setBounds(10, 10, 200, 18);
		zhuname=new JTextField(10);
		zhuname.setBounds(80, 10, 150, 18);
		
		cp.add(jl);
		cp.add(zhuname);
		
		//����
		JLabel jl2=new JLabel("���룺");
		jl2.setBounds(10, 50, 200, 18);
		zhupwd=new JTextField(10);
		zhupwd.setBounds(80, 50, 150, 18);
		
		cp.add(jl2);
		cp.add(zhupwd);
		
		//ע�ᰴť�¼�
		JButton jb=new JButton("ע��");
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//���û�������������Ϊ��ʱ��������ʾ��Ϣ
				if(zhuname.getText().trim().length()==0||zhupwd.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null, "�û������벻����Ϊ��");
					return;
				}
				if(zhuname.getText().trim().length()>=8||zhupwd.getText().trim().length()>=6){
					JOptionPane.showMessageDialog(null, "�û������ó�����λ�����벻�ó�����λ");
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "ע��ɹ�,���ȷ�����¼");
					writeFile();
					UserLogin userLogin=new UserLogin();
					return;
				}
				}
			});
		jb.setBounds(80, 150, 60, 18);
		cp.add(jb);

		//Ϊ���ð�ť��Ӽ����¼�
		final JButton button = new JButton();
		button.setText("����");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//��������ʱ�����û�������������Ϊ��
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
			writer = new FileWriter("D:/info/userinfo.txt");// �����ļ����������
			stringBuffer.append("�û���ϢΪ��\n").append("�û�����"+zhuname.getText()).append(
					"���룺"+zhupwd.getText());
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
