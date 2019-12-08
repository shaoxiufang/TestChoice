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
	Teacher teacher1=new Teacher("250", "李四", '男');
	Teacher teacher2=new Teacher("220", "张三", '男');
	Teacher teacher3=new Teacher("260", "王五", '男');
	
	Course course1=new Course("TS0001", "高数", "教学楼102", "周一", 6.0);
	Course course2=new Course("TS0203", "离散数学", "教学楼105", "周五", 4.0);
	Course course3=new Course("TS0339", "计算机组成原理", "综合楼1021", "周一", 2.0);
	JTextArea jTextArea=new JTextArea(20,20);
	FileWriter fileWriter;
	JCheckBox jCheckBox1;
	JCheckBox jCheckBox2;
	JCheckBox jCheckBox3;
	StringBuffer stringBuffer=new StringBuffer("已选课程:\n");
	StringBuffer stringBuffer2=new StringBuffer();
	
	ChoiceCourse() {
		JTabbedPane jTabbedPane=new JTabbedPane();//新建卡片选项页面
		jTabbedPane.setBackground(Color.PINK);
		setSize(700, 600);
		setVisible(true);
		setTitle("学生选课系统");
		setLayout(new GridLayout());
		jTabbedPane.addTab("选课", new Select());
		jTabbedPane.addTab("打印我的课程",new PrintIn());
		jTabbedPane.addTab("退课", new BackCourse());
		jTabbedPane.addTab("退出系统",new BackSystem());
		getContentPane().add(jTabbedPane);
		validate();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//添加文本框
		add(jTextArea);
		jTextArea.setSize(300, 200);
		jTextArea.setText(stringBuffer.toString());
		validate();	
	}
		@Override
		public void actionPerformed(ActionEvent e) {
		}
		
		//选课操作
		class Select extends JPanel implements ItemListener,ActionListener{	
			Select() {
				setVisible(true);
				setLayout(new FlowLayout());

				jCheckBox1=new JCheckBox(course1.getCourseName());
				add(jCheckBox1);
				//为复选按钮添加监听事件
				jCheckBox1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//如果复选框处于被选中状态，将复选框内容获取到jTextArea中
						if(jCheckBox1.isSelected()){
							//将复选框内容获取到jTextArea中
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
		
		//打印课程信息
		class PrintIn extends JPanel implements ActionListener{
			
			PrintIn(){
				JButton jButton=new JButton("打印课程信息");
				add(jButton);
				jButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "打印成功，请至文档查看");
						
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
					fileWriter = new FileWriter("D:/info/courseinfo.txt");// 创建文件输出流对象
		            fileWriter.write(stringBuffer.toString());// 
		            fileWriter.flush();       
				} catch (IOException e) {			
					System.out.println(e);
				}
			}
			
			public void writeFile(Course course,String teacher) throws IOException{
				
				stringBuffer2.append("课程名称:"+
						course.getCourseName()).append("教室:"+course.getCoursePlace()).append("课程编号:"
				+course.getCourserId()).append("课程学分:"+course.getCourseScore())
				.append("课程时间:"+course.getCourseTime()).append("任课老师:"+teacher+"\n").toString();
				fileWriter.write(stringBuffer2.toString());
				fileWriter.flush();
			}

			@Override
			public void actionPerformed(ActionEvent e) {
			}
		}
		
		//退出系统
		class BackSystem extends JPanel implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
			public BackSystem() {
				JButton jButton=new JButton("退出系统");
				add(jButton);
				jButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);	
					}
				});
			}			
		}
		
		
		//退课
		class BackCourse extends JPanel implements ActionListener{
			
			JButton jButton=new JButton("退课");
			String str="您选的课程有"+"\n";
			BackCourse() {
				jTextArea=new JTextArea();
				add(jTextArea);
				
				jTextArea.setText(str.concat(jTextArea.getText()));
				add(jButton);
				jButton.addActionListener(this);
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "退课成功");
				jTextArea.setText(str);
				add(jTextArea);
				jTextArea.setText("我的课程："+"\n"+"暂无课程信息");
				
			}
			
			}
		
}
		
		






