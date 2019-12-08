计G191邵秀芳2019322030


## 综合性实验  学生选课系统设计
**一、实验目的**

1、分析学生选课系统

2、使用GUI窗体及其组件设计窗体界面

3、完成学生选课过程业务逻辑编程

4、基于文件保存并读取数据

5、处理异常


**二、实验要求**

1、	设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。

2、	基于事件模型对业务逻辑编程，实现在界面上支持上述操作。

3、	针对操作过程中可能会出现的各种异常，做异常处理。

4、	基于输入/输出编程，支持学生、课程、教师等数据的读写操作。

5、	基于Github.com提交实验，包括实验SRC源文件夹程序、README.MD实验报告文档。


**三、实验过程**


1、编写一个UserRegister类，实现用户注册功能，并利用FileWrite将用户注册的信息写入文件。


    
    （1）将用户名标签jl，用户名文本域zhuname，密码标签jl2，密码域zhupwd，注册按钮jb，重置按钮button添加到JFrame中。
    
    （2）分别为注册按钮jb和重置按钮button添加监听事件。
    
    （3）为注册按钮jb添加监听事件：编写三个判断条件，当用户名或密码框输入为空时，弹出提示信息："用户名密码不允许为空"；
    当用户名超过8位，密码超过6位时，弹出提示信息："用户名不得超过八位，密码不得超过六位"；当用户名和密码输入合法时,弹出
    信息："注册成功,点击确定后登 录"。 并实例化UserLogin()类，点击确定后，实现跳转到用户登录页面功能。
      
    （4）为重置按钮添加监听事件：当点击重置按钮时，使用setText("")将文本框和密码框中的内容清空。
 
    （5）编写文件写入方法writeFile()，使用字符串缓冲区stringBuffer,将用户名和密码添加进去并toString()转化成字符串，
    写入到D:/info/userinfo.txt中，用flush()方法进行刷新。
    
    （6）在注册按钮的监听事件用户名和密码均合法的判断中，调用writeFile()，实现将合法的用户名和密码写入文件writer。      

2、在UserLogin类中添加readFile()方法，获取注册用户信息文件的信息，用于用户登录时的校验。

    （1）对登录和重置按钮添加监听事件。
    
    （2）编写readFile方法，对D:/info/userinfo.txt文件中的内容进行遍历读取，并添加判断语句，添加到登录按钮的监听事件中，
    当点击登录按钮时，如果用户名和密码不存在于读取的文件中，显示提示信息："用户名或密码错误"，如果用户名和密码是存在于文件
    中，调用选课页面ChoiceCourse类。
    
    （3）当点击重置按钮时，使用setText("")，将用户名和密码框中的内容清空。
    
 3、在ChoiceCourse类中添加四个类：选课类Select、打印课程信息类PrintIn、退出系统类BackSystem、退课类BackCourse
    
    （1）实例化Course和Teacher
    
    （2）在ChoiceCourse中添加文本域：（用于显示已选的课程），卡片选项页面JTabbedPane，使用addTab添加四个内容面板：选课、
    打印我的课程、退课、退出系统，分别为四个面板添加监听事件，点击不同的按钮实例化不同的类（Select、PrintIn、BackSystem、
    BackCourse），即点击不同的内容面板跳转至相应页面。
    
    （3）在select类中添加四个复选按钮，jCheckBox1，jCheckBox2，jCheckBox3，jCheckBox4，获取课程course的名称设置为这四个
    文本框显示内容，并为按钮添加监听事件，并增加jCheckBox.isSelected()条件判断，当该复选框被选中时，获取复选框内容，添加至文
    本域中。
    
    （4）编写文件写入方法writeFile(Course course,String teacher)，将course的内容追加到stringbuffer2中，将stringBuffer2.
    toString()写入到D:/info/courseinfo.txt文件中。
    
    （5）在PrintIn类中添加打印课程信息按钮，为该按钮添加监听事件。点击该按钮时，弹出信息：打印成功，请至文档查看。并增加if判
    断条件,当某个课程已经被选中，调用writeFile(Course course,String teacher)并传递课程与教师参数。
    
    （6）在BackSystem退出系统类中添加退出系统按钮jButton，为该按钮添加监听事件。当点击该按钮时，调用System.exit(0)，实现系统
    的退出。
    
    （7）在BackCourse退课类中添加退出系统按钮jButton，为该按钮添加监听事件。当点击该按钮时，展示已选课程的文本框内容被清空。

**四、核心代码**

1、在UserRegister类中   
            
     ```
     //1、将用户名和密码写入:/info/userinfo.txt文件中
    public void writeFile(){
		try {
			writer = new FileWriter("D:/info/userinfo.txt");
			stringBuffer.append("用户信息为：\n").append("用户名："+zhuname.getText()).append(
					"密码："+zhupwd.getText());
            writer.write(stringBuffer.toString());// 
            writer.flush();//刷新  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

       ```
       ```
       //2、为注册按钮jb添加监听事件：编写三个判断条件
       JButton jb=new JButton("注册");
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//当用户名或密码输入为空时，弹出提示信息
				if(zhuname.getText().trim().length()==0||zhupwd.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
					return;
				}
				//当用户名输入超过8位，或者密码超过6位时用，
				if(zhuname.getText().trim().length()>=8||zhupwd.getText().trim().length()>=6){
					JOptionPane.showMessageDialog(null, "用户名不得超过八位，密码不得超过六位");
					return;
				}
				//当户名和密码输入合法时
				else {
					JOptionPane.showMessageDialog(null, "注册成功,点击确定后登录");
					//写入文件中
					writeFile();
					//跳转到用户登录页面
					UserLogin userLogin=new UserLogin();
					return;
				}
				}
			});
       ```
       ```
       //3、为重置按钮添加监听事件
       button.setText("重置");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//动作触发时，将用户名和密码设置为空
				zhuname.setText("");
				zhupwd.setText("");
				//repassword.setText("");
			}
		});
       
       ```
  2、在UserLogin中
  
  
  ```
  //1、编写文件读取方法
  public void readFile(){
		try {
			//读取D:/info/userinfo.txt中的内容
			fileReader = new FileReader("D:/info/userinfo.txt");
			int read = fileReader.read();
			subname=name.getText();
			subpwd=password.getText();
			//遍历读取
			while(read!=-1){
				read = fileReader.read();
				}
			//判断，如果读取到的信息里面包含用户输入的用户名密码，就跳转到选课页面
			if(fileReader.toString().contains(subname)&&fileReader.toString().contains(subpwd)){
				//跳转到选课页面
				ChoiceCourse choiceCourse=new ChoiceCourse();
			}
			else {//否则，弹出信息："用户名或密码错误"
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
  ```
  ```
  
  //2、为确定按钮添加监听事件
		JButton jb=new JButton("确定");
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//当点击确定时，调用readFile()来判断用户输入的用户名和密码是否存在问题
				readFile();
			}
		});
  ```
  ```
  //3、为重置按钮添加监听事件
  button.setText("重置");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				password.setText("");
			}
		});
  ```
       
3、ChoiceCourse中的select类中的select()构造方法
```
//1、为复选按钮添加监听事件
	jCheckBox1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		//如果复选框处于被选中状态，将复选框内容获取到jTextArea中
		if(jCheckBox1.isSelected()){
		//将复选框内容获取到jTextArea中
		stringBuffer.append(course1.getCourseName()).toString();
		jTextArea.setText(stringBuffer.toString());
		}}});
```

4、ChoiceCourse中的PrintIn类中的writeFile(Course course,String teacher)方法
```
//1、写入"D:/info/courseinfo.txt中
fileWriter = new FileWriter("D:/info/courseinfo.txt");// 创建文件输出流对象
fileWriter.write(stringBuffer.toString());// 
fileWriter.flush(); //刷新 
//2、有参方法，用于传递课程和教师信息     
public void writeFile(Course course,String teacher) throws IOException{
//将课程详细信息添加到stringBuffer2中
	stringBuffer2.append("课程名称:"+
		course.getCourseName()).append("教室:"+course.getCoursePlace()).append("课程编号:"
		+course.getCourserId()).append("课程学分:"+course.getCourseScore())
		.append("课程时间:"+course.getCourseTime()).append("任课老师:"+teacher+"\n").toString();
		//将stringBuffer2中的内容写入到fileWrite中
	fileWriter.write(stringBuffer2.toString());
	fileWriter.flush();//刷新
			}
```
5、ChoiceCourse中的PrintIn类中的PrintIn构造方法

**六、运行截图**




**七、实验感想**

这次字符串编程，使我对String的方法有了更多的了解，提高了我的思维方式，锻炼了解决实际问题的能力。但这次编写的代码不够简练，我将通过日后的学习不断对代码
进行改进。
