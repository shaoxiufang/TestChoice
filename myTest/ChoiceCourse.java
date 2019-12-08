package myTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.soap.Text;

public class ChoiceCourse extends JFrame implements ActionListener{
	Teacher teacher1=new Teacher("250", "����", '��');
	Teacher teacher2=new Teacher("220", "����", '��');
	Teacher teacher3=new Teacher("260", "����", '��');
	
	Course course1=new Course("TS0001", "����", "��ѧ¥102", "��һ", 6.0);
	Course course2=new Course("TS0203", "��ɢ��ѧ", "��ѧ¥105", "����", 4.0);
	Course course3=new Course("TS0339", "��������ԭ��", "�ۺ�¥1021", "��һ", 2.0);
	JTextArea jTextArea=new JTextArea(20,20);
	FileWriter fileWriter;
	JCheckBox jCheckBox1;
	JCheckBox jCheckBox2;
	JCheckBox jCheckBox3;
	StringBuffer stringBuffer=new StringBuffer("��ѡ�γ�:\n");
	StringBuffer stringBuffer2=new StringBuffer();
	
	ChoiceCourse() {
		JTabbedPane jTabbedPane=new JTabbedPane();//�½���Ƭѡ��ҳ��
		jTabbedPane.setBackground(Color.PINK);
		setSize(700, 600);
		setVisible(true);
		setTitle("ѧ��ѡ��ϵͳ");
		setLayout(new GridLayout());
		jTabbedPane.addTab("ѡ��", new Select());
		jTabbedPane.addTab("��ӡ�ҵĿγ�",new PrintIn());
		jTabbedPane.addTab("�˿�", new BackCourse());
		jTabbedPane.addTab("�˳�ϵͳ",new BackSystem());
		getContentPane().add(jTabbedPane);
		validate();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//����ı���
		add(jTextArea);
		jTextArea.setSize(300, 200);
		jTextArea.setText(stringBuffer.toString());
		validate();	
	}
		@Override
		public void actionPerformed(ActionEvent e) {
		}
		
		//ѡ�β���
		class Select extends JPanel implements ItemListener,ActionListener{	
			Select() {
				setVisible(true);
				setLayout(new FlowLayout());

				jCheckBox1=new JCheckBox(course1.getCourseName());
				add(jCheckBox1);
				//Ϊ��ѡ��ť��Ӽ����¼�
				jCheckBox1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//�����ѡ���ڱ�ѡ��״̬������ѡ�����ݻ�ȡ��jTextArea��
						if(jCheckBox1.isSelected()){
							//����ѡ�����ݻ�ȡ��jTextArea��
							stringBuffer.append(course1.getCourseName()).toString();
							jTextArea.setText(stringBuffer.toString());
							
						}
						
					}
				});
				jCheckBox2=new JCheckBox(course2.getCourseName());
				add(jCheckBox2);
				jCheckBox2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(jCheckBox2.isSelected()){
							stringBuffer.append(course2.getCourseName()).toString();
							jTextArea.setText(stringBuffer.toString());				
						}
					}
				});
				jCheckBox3=new JCheckBox(course3.getCourseName());
				add(jCheckBox3);
				jCheckBox3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(jCheckBox2.isSelected()){
							stringBuffer.append(course3.getCourseName()).toString();
							jTextArea.setText(stringBuffer.toString());	
						}
					}
				});	
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {		
			}
			@Override
			public void itemStateChanged(ItemEvent e) {
			}
		}
		
		//��ӡ�γ���Ϣ
		class PrintIn extends JPanel implements ActionListener{
			
			PrintIn(){
				JButton jButton=new JButton("��ӡ�γ���Ϣ");
				add(jButton);
				jButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "��ӡ�ɹ��������ĵ��鿴");
						
						if(jCheckBox1.isSelected()){
							try {
								writeFile(course1,teacher1.getName());
							} catch (IOException e1) {	
								e1.printStackTrace();
							}	
						}
						
						if(jCheckBox2.isSelected()){
							try {
								writeFile(course2,teacher2.getName());
							} catch (IOException e1) {					
								e1.printStackTrace();
							}								
						}
					
						if(jCheckBox3.isSelected()){
							try {
								writeFile(course3,teacher3.getName());
							} catch (IOException e1) {
								
								e1.printStackTrace();
							}								
						}					
					}
				});
						
				try {
					fileWriter = new FileWriter("D:/info/courseinfo.txt");// �����ļ����������
		            fileWriter.write(stringBuffer.toString());// 
		            fileWriter.flush();       
				} catch (IOException e) {			
					System.out.println(e);
				}
			}
			
			public void writeFile(Course course,String teacher) throws IOException{
				
				stringBuffer2.append("�γ�����:"+
						course.getCourseName()).append("����:"+course.getCoursePlace()).append("�γ̱��:"
				+course.getCourserId()).append("�γ�ѧ��:"+course.getCourseScore())
				.append("�γ�ʱ��:"+course.getCourseTime()).append("�ο���ʦ:"+teacher+"\n").toString();
				fileWriter.write(stringBuffer2.toString());
				fileWriter.flush();
			}

			@Override
			public void actionPerformed(ActionEvent e) {
			}
		}
		
		//�˳�ϵͳ
		class BackSystem extends JPanel implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
			public BackSystem() {
				JButton jButton=new JButton("�˳�ϵͳ");
				add(jButton);
				jButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);	
					}
				});
			}			
		}
		
		
		//�˿�
		class BackCourse extends JPanel implements ActionListener{
			
			JButton jButton=new JButton("�˿�");
			String str="��ѡ�Ŀγ���"+"\n";
			BackCourse() {
				jTextArea=new JTextArea();
				add(jTextArea);
				
				jTextArea.setText(str.concat(jTextArea.getText()));
				add(jButton);
				jButton.addActionListener(this);
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�˿γɹ�");
				jTextArea.setText(str);
				add(jTextArea);
				jTextArea.setText("�ҵĿγ̣�"+"\n"+"���޿γ���Ϣ");
				
			}
			
			}
		
}
		
		






