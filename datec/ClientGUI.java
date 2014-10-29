package datec;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientGUI extends JFrame implements ActionListener {

	int i, j, checkstate;
	String gt1, gt2, gt3, gt4, gt5, user, time;
	Object[][] get = { { 1, 2, "3" }, { 4, '5', "6", 7 } };
	boolean check1 = true, check2 = false, nameused = false;
	JPanel p0, p1, p2, p3, p4, p5, p6;
	CardLayout card;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15,
			l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28,
			l29, l30, l31, l32, l33, l34, l35, l36, l37;
	JTextField t1, t3, t6, t7, t8, t10, t11, t12, t13, t14, t15, t16, t17, t18,
			t19, t20, t21, t22, t24, t25, t26, t27, t28, t29, t30, t31, t32,
			t33, t34, t36, t37, t38, t39, t40, t41;
	JPasswordField t2, t4, t5;
	JTextArea t9, t23, t35;
	JComboBox c1;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15,
			b16, b17, b18, b19, b20, b21;
	JRadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7;

	public void clientGUI() {
		// 定义窗体和全局的中间容器
		this.setTitle("预约系统");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		p0 = new JPanel();
		this.setContentPane(p0);
		card = new CardLayout();
		p0.setLayout(card);

		// 添加6个中间容器
		p1 = new JPanel();
		p0.add(p1);
		p2 = new JPanel();
		p0.add(p2);
		p3 = new JPanel();
		p0.add(p3);
		p4 = new JPanel();
		p0.add(p4);
		p5 = new JPanel();
		p0.add(p5);
		p6 = new JPanel();
		p0.add(p6);
		card.first(p0);
		
		// 为p1（登录界面/初始界面）添加组件
		p1.setLayout(null);
		b1 = new JButton("登录");
		b1.addActionListener(this);
		p1.add(b1);
		b1.setBounds(300, 400, 100, 50);
		b2 = new JButton("注册");
		b2.addActionListener(this);
		p1.add(b2);
		b2.setBounds(500, 400, 100, 50);
		l1 = new JLabel("用户名");
		p1.add(l1);
		l1.setBounds(300, 200, 100, 50);
		l2 = new JLabel("密码");
		p1.add(l2);
		l2.setBounds(300, 300, 100, 50);
		t1 = new JTextField();
		p1.add(t1);
		t1.setBounds(400, 200, 200, 50);
		t2 = new JPasswordField();
		p1.add(t2);
		t2.setBounds(400, 300, 200, 50);

		// 为p2（注册界面）添加组件
		p2.setLayout(null);
		l3 = new JLabel("用户名");
		p2.add(l3);
		l3.setBounds(300, 50, 100, 50);
		l4 = new JLabel("（注：以1开头+5位数字作为老师的账号，以2开头+10位学号作为学生账号）");
		p2.add(l4);
		l4.setBounds(200, 150, 500, 50);
		l5 = new JLabel("密码");
		p2.add(l5);
		l5.setBounds(300, 250, 100, 50);
		l6 = new JLabel("确认密码");
		p2.add(l6);
		l6.setBounds(300, 350, 100, 50);
		b3 = new JButton("上一步");
		b3.addActionListener(this);
		p2.add(b3);
		b3.setBounds(300, 450, 100, 50);
		b4 = new JButton("注册");
		b4.addActionListener(this);
		p2.add(b4);
		b4.setBounds(500, 450, 100, 50);
		t3 = new JTextField();
		p2.add(t3);
		t3.setBounds(400, 50, 200, 50);
		t4 = new JPasswordField();
		p2.add(t4);
		t4.setBounds(400, 250, 200, 50);
		t5 = new JPasswordField();
		p2.add(t5);
		t5.setBounds(400, 350, 200, 50);

		// 为p3（管理员界面）添加组件
		p3.setLayout(null);
		rb1 = new JRadioButton("查询账号", true);
		p3.add(rb1);
		rb1.setBounds(200, 50, 100, 50);
		rb2 = new JRadioButton("查询作息表");
		p3.add(rb2);
		rb2.setBounds(200, 150, 100, 50);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		String[] array = { "按账号", "按老师名", "按学生名" };
		c1 = new JComboBox(array);
		p3.add(c1);
		c1.setBounds(300, 50, 100, 50);
		t6 = new JTextField();
		p3.add(t6);
		t6.setBounds(500, 50, 200, 50);
		l7 = new JLabel("老师号");
		p3.add(l7);
		l7.setBounds(300, 150, 50, 50);
		t7 = new JTextField();
		p3.add(t7);
		t7.setBounds(350, 150, 200, 50);
		l8 = new JLabel("第");
		p3.add(l8);
		l8.setBounds(575, 150, 25, 50);
		t8 = new JTextField();
		p3.add(t8);
		t8.setBounds(600, 150, 50, 50);
		l9 = new JLabel("周");
		p3.add(l9);
		l9.setBounds(650, 150, 50, 50);
		t9 = new JTextArea();
		t9.setEditable(false);
		p3.add(t9);
		t9.setBounds(200, 250, 500, 200);
		b5 = new JButton("查询");
		b5.addActionListener(this);
		p3.add(b5);
		b5.setBounds(300, 500, 100, 50);
		b6 = new JButton("删除");
		b6.addActionListener(this);
		p3.add(b6);
		b6.setBounds(500, 500, 100, 50);

		// 为p4（教师界面）添加组件
		p4.setLayout(null);
		l10 = new JLabel("老师号");
		p4.add(l10);
		l10.setBounds(50, 50, 50, 50);
		t10 = new JTextField();
		t10.setEditable(false);
		p4.add(t10);
		t10.setBounds(100, 50, 150, 50);
		l11 = new JLabel("姓名");
		p4.add(l11);
		l11.setBounds(350, 50, 50, 50);
		t11 = new JTextField();
		t11.setEditable(false);
		p4.add(t11);
		t11.setBounds(400, 50, 150, 50);
		l12 = new JLabel("课程");
		p4.add(l12);
		l12.setBounds(650, 50, 50, 50);
		t12 = new JTextField();
		t12.setEditable(false);
		p4.add(t12);
		t12.setBounds(700, 50, 150, 50);
		l13 = new JLabel("地址");
		p4.add(l13);
		l13.setBounds(50, 110, 50, 50);
		t13 = new JTextField();
		t13.setEditable(false);
		p4.add(t13);
		t13.setBounds(100, 110, 150, 50);
		l14 = new JLabel("电话");
		p4.add(l14);
		l14.setBounds(350, 110, 50, 50);
		t14 = new JTextField();
		t14.setEditable(false);
		p4.add(t14);
		t14.setBounds(400, 110, 150, 50);
		l15 = new JLabel("email");
		p4.add(l15);
		l15.setBounds(650, 110, 50, 50);
		t15 = new JTextField();
		t15.setEditable(false);
		p4.add(t15);
		t15.setBounds(700, 110, 150, 50);
		b7 = new JButton("更改");
		b7.addActionListener(this);
		p4.add(b7);
		b7.setBounds(750, 165, 100, 25);
		t23 = new JTextArea();
		t23.setEditable(false);
		p4.add(t23);
		t23.setBounds(50, 250, 800, 225);
		rb3 = new JRadioButton("查询作息表", true);
		p4.add(rb3);
		rb3.setBounds(50, 200, 100, 50);
		rb4 = new JRadioButton("查询学生");
		p4.add(rb4);
		rb4.setBounds(400, 200, 100, 50);
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(rb3);
		bg2.add(rb4);
		l16 = new JLabel("第");
		p4.add(l16);
		l16.setBounds(175, 200, 25, 50);
		t17 = new JTextField();
		t17.setEditable(false);
		p4.add(t17);
		t17.setBounds(200, 200, 50, 50);
		l17 = new JLabel("周");
		p4.add(l17);
		l17.setBounds(250, 200, 50, 50);
		l21 = new JLabel("学生名");
		p4.add(l21);
		l21.setBounds(500, 200, 50, 50);
		t22 = new JTextField();
		p4.add(t22);
		t22.setBounds(550, 200, 100, 50);
		b12 = new JButton("查询");
		p4.add(b12);
		b12.setBounds(750, 200, 100, 50);
		b8 = new JButton("上");
		b8.addActionListener(this);
		p4.add(b8);
		b8.setBounds(50, 500, 50, 50);
		b9 = new JButton("下");
		b9.addActionListener(this);
		p4.add(b9);
		b9.setBounds(100, 500, 50, 50);
		l18 = new JLabel("一周    周");
		p4.add(l18);
		l18.setBounds(150, 500, 100, 50);
		t18 = new JTextField();
		p4.add(t18);
		t18.setBounds(200, 500, 50, 50);
		t19 = new JTextField();
		p4.add(t19);
		t19.setBounds(300, 500, 50, 50);
		l19 = new JLabel("课时    老师状态");
		p4.add(l19);
		l19.setBounds(350, 500, 100, 50);
		t20 = new JTextField();
		t20.setEditable(false);
		p4.add(t20);
		t20.setBounds(450, 500, 50, 50);
		b10 = new JButton("更改");
		b10.addActionListener(this);
		p4.add(b10);
		b10.setBounds(500, 500, 100, 50);
		l20 = new JLabel("预约人");
		p4.add(l20);
		l20.setBounds(600, 500, 50, 50);
		t21 = new JTextField();
		t21.setEditable(false);
		p4.add(t21);
		t21.setBounds(650, 500, 100, 50);
		b11 = new JButton("拒绝");
		b11.addActionListener(this);
		p4.add(b11);
		b11.setBounds(750, 500, 100, 50);
		b13 = new JButton("退出登录");
		p4.add(b13);
		b13.setBounds(800, 0, 100, 30);

		// 为p5（个人信息修改界面）添加组件
		p5.setLayout(null);
		l22 = new JLabel("姓名");
		p5.add(l22);
		l22.setBounds(300, 25, 50, 50);
		t24 = new JTextField();
		p5.add(t24);
		t24.setBounds(350, 25, 250, 50);
		l23 = new JLabel("课程/学院");
		p5.add(l23);
		l23.setBounds(300, 125, 50, 50);
		t25 = new JTextField();
		p5.add(t25);
		t25.setBounds(350, 125, 250, 50);
		l24 = new JLabel("地址");
		p5.add(l24);
		l24.setBounds(300, 225, 50, 50);
		t26 = new JTextField();
		p5.add(t26);
		t26.setBounds(350, 225, 250, 50);
		l25 = new JLabel("电话");
		p5.add(l25);
		l25.setBounds(300, 325, 50, 50);
		t27 = new JTextField();
		p5.add(t27);
		t27.setBounds(350, 325, 250, 50);
		l26 = new JLabel("email");
		p5.add(l26);
		l26.setBounds(300, 425, 50, 50);
		t28 = new JTextField();
		p5.add(t28);
		t28.setBounds(350, 425, 250, 50);
		b14 = new JButton("上一步");
		p5.add(b14);
		b14.setBounds(300, 525, 100, 30);
		b15 = new JButton("保存");
		p5.add(b15);
		b15.setBounds(500, 525, 100, 30);

		// 为p6（学生界面）添加组件
		p6.setLayout(null);
		l27 = new JLabel("学生号");
		p6.add(l27);
		l27.setBounds(50, 50, 50, 50);
		t29 = new JTextField();
		t29.setEditable(false);
		p6.add(t29);
		t29.setBounds(100, 50, 150, 50);
		l28 = new JLabel("姓名");
		p6.add(l28);
		l28.setBounds(350, 50, 50, 50);
		t30 = new JTextField();
		t30.setEditable(false);
		p6.add(t30);
		t30.setBounds(400, 50, 150, 50);
		l29 = new JLabel("学院");
		p6.add(l29);
		l29.setBounds(650, 50, 50, 50);
		t31 = new JTextField();
		t31.setEditable(false);
		p6.add(t31);
		t31.setBounds(700, 50, 150, 50);
		l30 = new JLabel("地址");
		p6.add(l30);
		l30.setBounds(50, 110, 50, 50);
		t32 = new JTextField();
		t32.setEditable(false);
		p6.add(t32);
		t32.setBounds(100, 110, 150, 50);
		l31 = new JLabel("电话");
		p6.add(l31);
		l31.setBounds(350, 110, 50, 50);
		t33 = new JTextField();
		t33.setEditable(false);
		p6.add(t33);
		t33.setBounds(400, 110, 150, 50);
		l32 = new JLabel("email");
		p6.add(l32);
		l32.setBounds(650, 110, 50, 50);
		t34 = new JTextField();
		t34.setEditable(false);
		p6.add(t34);
		t34.setBounds(700, 110, 150, 50);
		b16 = new JButton("更改");
		p6.add(b16);
		b16.setBounds(750, 165, 100, 25);
		t35 = new JTextArea();
		t35.setEditable(false);
		p6.add(t35);
		t35.setBounds(50, 250, 800, 225);
		rb5 = new JRadioButton("查询作息表", true);
		p6.add(rb5);
		rb5.setBounds(50, 200, 100, 50);
		rb6 = new JRadioButton("查询老师");
		p6.add(rb6);
		rb6.setBounds(425, 200, 100, 50);
		rb7 = new JRadioButton("我的预约");
		p6.add(rb7);
		rb7.setBounds(675, 200, 100, 50);
		ButtonGroup bg3 = new ButtonGroup();
		bg3.add(rb5);
		bg3.add(rb6);
		bg3.add(rb7);
		l33 = new JLabel("第");
		p6.add(l33);
		l33.setBounds(175, 200, 25, 50);
		t36 = new JTextField();
		t36.setEditable(false);
		p6.add(t36);
		t36.setBounds(200, 200, 50, 50);
		l34 = new JLabel("周    老师号");
		p6.add(l34);
		l34.setBounds(250, 200, 75, 50);
		t37 = new JTextField();
		p6.add(t37);
		t37.setBounds(325, 200, 100, 50);
		l35 = new JLabel("老师名");
		p6.add(l35);
		l35.setBounds(525, 200, 50, 50);
		t38 = new JTextField();
		p6.add(t38);
		t38.setBounds(575, 200, 100, 50);
		b17 = new JButton("查询");
		p6.add(b17);
		b17.setBounds(775, 200, 75, 50);
		b18 = new JButton("上");
		p6.add(b18);
		b18.setBounds(50, 500, 50, 50);
		b19 = new JButton("下");
		p6.add(b19);
		b19.setBounds(100, 500, 50, 50);
		l36 = new JLabel("一周    周");
		p6.add(l36);
		l36.setBounds(150, 500, 100, 50);
		t39 = new JTextField();
		p6.add(t39);
		t39.setBounds(200, 500, 50, 50);
		t40 = new JTextField();
		p6.add(t40);
		t40.setBounds(300, 500, 50, 50);
		l37 = new JLabel("课时    老师状态");
		p6.add(l37);
		l37.setBounds(350, 500, 100, 50);
		t41 = new JTextField();
		t41.setEditable(false);
		p6.add(t41);
		t41.setBounds(450, 500, 50, 50);
		b20 = new JButton("预约");
		p6.add(b20);
		b20.setBounds(500, 500, 100, 50);
		b21 = new JButton("退出登录");
		p6.add(b21);
		b21.setBounds(800, 0, 100, 30);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			gt1 = t1.getText();
			gt2 = t2.getPassword().toString();
			// 发送数据、匹配数据库,赋值check1和check2
			try {
				Socket socket = new Socket("127.0.0.1", 4700);
				PrintWriter os = new PrintWriter(socket.getOutputStream());
				os.println("1");
				os.flush();
				os.println(gt1);
				os.flush();
				BufferedReader is = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				String rec;
				rec = is.readLine();
				System.out.println(rec);
				System.out.println(gt1);
				if(rec.equals(gt1)){
					check1 = true;
				}
				else{
					check1 = false;
				}
				System.out.println("check1赋值为"+check1);
				os.println(gt2);
				os.flush();
				rec = is.readLine();
				if(rec.equals(gt2)){
					check2 = true;
				}
				else{
					check2 = false;
				}
				System.out.println("check2赋值为"+check2);
			} catch (Exception e1) {
				System.out.println("Error" + e);
			} 
			if (check1 && check2) {
				if (gt1.charAt(0) == '0') {
					card.next(p0);
					card.next(p0);
					t6.setText(null);
					t7.setText(null);
					t8.setText(null);
					t9.setText(null);
				} else if (gt1.charAt(0) == '1') {
					card.next(p0);
					card.next(p0);
					card.next(p0);
					user = gt1;
					// 根据用户账号user检索数据库，查找其属性赋值给gt1到gt5
					t10.setText(user);
					t11.setText(gt1);
					t12.setText(gt2);
					t13.setText(gt3);
					t14.setText(gt4);
					t15.setText(gt5);
					t17.setText(time);
					t18.setText(null);
					t19.setText(null);
					t20.setText(null);
					t21.setText(null);
					t22.setText(null);
					t23.setText(null);
				} else if (gt1.charAt(0) == '2') {
					card.last(p0);
					user = gt1;
					// 根据用户账号user检索数据库，查找其属性赋值给gt1到gt5
					t29.setText(user);
					t30.setText(gt1);
					t31.setText(gt2);
					t32.setText(gt3);
					t33.setText(gt4);
					t34.setText(gt5);
					t35.setText(null);
					t36.setText(time);
					t37.setText(null);
					t38.setText(null);
					t39.setText(null);
					t40.setText(null);
					t41.setText(null);
				}
			} else if (check1 && !check2) {
				Warning w = new Warning();
				w.warning(this, "密码错误");
			} else if (!check1) {
				Warning w = new Warning();
				w.warning(this, "账号不存在");
			}
			check1 = false;
			check2 = false;
		} else if (e.getSource() == b2)
			card.next(p0);
		else if (e.getSource() == b3)
			card.previous(p0);
		else if (e.getSource() == b4) {
			gt1 = t3.getText();
			gt2 = t4.getPassword().toString().trim();
			gt3 = t5.getPassword().toString().trim();
			if (gt1.charAt(0) == '1' && gt1.length() == 6 && gt2 == gt3
					&& gt2 != "") {
				// 数据库中匹配老师账号，检测重复则nameused赋值true
				if (!nameused) {
					// 数据库中建立老师账号，gt1是账号，gt2是密码
					Warning w = new Warning();
					w.warning(this, "注册成功！");
					card.previous(p0);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
				} else {
					Warning w = new Warning();
					w.warning(this, "账号已存在");
					System.out.println("账号已存在");
				}
			} else if (gt1.charAt(0) == '2' && gt1.length() == 11 && gt2 == gt3
					&& gt2 != "") {
				// 数据库中匹配学生账号
				if (!nameused) {
					// 数据库中建立学生账号
					Warning w = new Warning();
					w.warning(this, "注册成功！");
					card.previous(p0);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
				} else {
					Warning w = new Warning();
					w.warning(this, "账号已存在");
				}
			} else if (gt2 != gt3) {
				Warning w = new Warning();
				w.warning(this, "密码确认错误");
				System.out.println("密码确认错误");
			} else {
				Warning w = new Warning();
				w.warning(this, "用户号非法");
				System.out.println("用户号非法");
			}
			System.out.println(gt2);
			System.out.println(gt3);
		} else if (e.getSource() == b5) {
			if (rb1.isSelected() && t6.getText() != null) {
				checkstate = c1.getSelectedIndex();
				gt1 = t6.getText();
				// 从数据库中查询是否存在
				if (check1) {
					// 从数据库中数据，输入get
					t9.setText(null);
					for (i = 0; i < get.length; i++) {
						for (j = 0; j < get[i].length; j++) {
							t9.append(get[i][j].toString() + " ");
						}
						t9.append("\n");
					}
				} else {
					Warning w = new Warning();
					w.warning(this, "该用户不存在");
				}
			} else if (rb2.isSelected() && t7.getText() != null
					&& t8.getText() != null) {
				gt1 = t7.getText();
				gt2 = t8.getText();
				// 从数据库中查询是否存在
				if (check1 && check2) {
					// 从数据库中数据，输入get
					t9.setText(null);
					for (i = 0; i < get.length; i++) {
						for (j = 0; j < get[i].length; j++) {
							t9.append(get[i][j].toString() + " ");
						}
						t9.append("\n");
					}
				} else if (!check1) {
					Warning w = new Warning();
					w.warning(this, "该用户不存在");
				} else {
					Warning w = new Warning();
					w.warning(this, "周次书写错误");
				}
			} else {
				Warning w = new Warning();
				w.warning(this, "查询失败");
			}
		} else if (e.getSource() == b6) {
			if (rb1.isSelected() && c1.getSelectedIndex() == 0
					&& t6.getText() != null) {
				gt1 = t6.getText();
				// 在数据库中按账号gt1查找，找到则置check1为真
				if (check1) {
					// 在数据库中删除账号为gt1的实体
				} else {
					Warning w = new Warning();
					w.warning(this, "该用户不存在");
				}
			} else {
				Warning w = new Warning();
				w.warning(this, "查询方式错误！请选中 查询账号→按账号 并输入账号");
			}
		} else if (e.getSource() == b7) {
			card.next(p0);
			t24.setText(null);
			t25.setText(null);
			t26.setText(null);
			t27.setText(null);
			t28.setText(null);
			checkstate = 1;
		} else if (e.getSource() == b8) {
			if (rb3.isSelected()) {
				gt1 = t17.getText();
				i = Integer.parseInt(gt1) - 1;
				if (i == 0)
					i = 20;
				gt1 = "" + i;
				gt2 = t18.getText();
				gt3 = t19.getText();
				// 从数据库中查询第gt1周的课表存入get中
				t23.setText(null);
				for (i = 0; i < get.length; i++) {
					for (j = 0; j < get[i].length; j++) {
						t23.append(get[i][j].toString() + " ");
					}
					t23.append("\n");
				}
				if (Integer.parseInt(gt2) >= 1 && Integer.parseInt(gt2) <= 7
						&& Integer.parseInt(gt3) >= 1
						&& Integer.parseInt(gt3) <= 8) {
					// 在数据库中user的第gt1周周gt2第gt3课时的预约状态置无并赋值gt4、gt5
					t20.setText(gt4);
					t21.setText(gt5);
				} else {
					Warning w = new Warning();
					w.warning(this, "部分查询失败");
				}
			} else {
				Warning w = new Warning();
				w.warning(this, "请先选中查询课表");
			}
		} else if (e.getSource() == b9) {
			if (rb3.isSelected()) {
				gt1 = t17.getText();
				i = Integer.parseInt(gt1) % 20 + 1;
				gt1 = "" + i;
				gt2 = t18.getText();
				gt3 = t19.getText();
				// 从数据库中查询第gt1周的课表存入get中
				t23.setText(null);
				for (i = 0; i < get.length; i++) {
					for (j = 0; j < get[i].length; j++) {
						t23.append(get[i][j].toString() + " ");
					}
					t23.append("\n");
				}
				if (Integer.parseInt(gt2) >= 1 && Integer.parseInt(gt2) <= 7
						&& Integer.parseInt(gt3) >= 1
						&& Integer.parseInt(gt3) <= 8) {
					// 在数据库中user的第gt1周周gt2第gt3课时的预约状态置无并赋值gt4、gt5
					t20.setText(gt4);
					t21.setText(gt5);
				} else {
					Warning w = new Warning();
					w.warning(this, "部分查询失败");
				}
			} else {
				Warning w = new Warning();
				w.warning(this, "请先选中查询作息表");
			}
		} else if (e.getSource() == b10) {
			user = t10.getText();
			gt1 = t17.getText();
			gt2 = t18.getText();
			gt3 = t19.getText();
			if (Integer.parseInt(gt2) >= 1 && Integer.parseInt(gt2) <= 7
					&& Integer.parseInt(gt3) >= 1 && Integer.parseInt(gt3) <= 8) {
				// 在数据库中修改user的第gt1周周gt2第gt3课时的闲/忙状态并赋值gt4
				t20.setText(gt4);
			} else {
				Warning w = new Warning();
				w.warning(this, "修改失败");
			}
		} else if (e.getSource() == b11) {
			gt1 = t17.getText();
			gt2 = t18.getText();
			gt3 = t19.getText();
			if (Integer.parseInt(gt2) >= 1 && Integer.parseInt(gt2) <= 7
					&& Integer.parseInt(gt3) >= 1 && Integer.parseInt(gt3) <= 8) {
				// 在数据库中user的第gt1周周gt2第gt3课时的预约状态置无并赋值gt4
				t21.setText(gt4);
			} else {
				Warning w = new Warning();
				w.warning(this, "修改失败");
			}
		} else if (e.getSource() == b12) {
			if (rb3.isSelected()) {
				gt1 = t17.getText();
				gt2 = t18.getText();
				gt3 = t19.getText();
				// 从数据库中查询第gt1周的课表存入get中
				t23.setText(null);
				for (i = 0; i < get.length; i++) {
					for (j = 0; j < get[i].length; j++) {
						t23.append(get[i][j].toString() + " ");
					}
					t23.append("\n");
				}
				if (Integer.parseInt(gt2) >= 1 && Integer.parseInt(gt2) <= 7
						&& Integer.parseInt(gt3) >= 1
						&& Integer.parseInt(gt3) <= 8) {
					// 在数据库中user的第gt1周周gt2第gt3课时的预约状态置无并赋值gt4、gt5
					t20.setText(gt4);
					t21.setText(gt5);
				} else {
					Warning w = new Warning();
					w.warning(this, "部分查询失败");
				}
			} else if (rb4.isSelected()) {
				gt1 = t22.getText();
				// 在数据库中检索姓名是gt1的学生，检索到则check1为true，并赋值get
				if (check1) {
					t23.setText(null);
					for (i = 0; i < get.length; i++) {
						for (j = 0; j < get[i].length; j++) {
							t23.append(get[i][j].toString() + " ");
						}
						t23.append("\n");
					}
				} else {
					Warning w = new Warning();
					w.warning(this, "该用户不存在");
				}
			}
		} else if (e.getSource() == b13) {
			card.first(p0);
			t1.setText(null);
			t2.setText(null);
			user = null;
		} else if (e.getSource() == b14) {
			if (checkstate == 1)
				card.previous(p0);
			else if (checkstate == 2)
				card.next(p0);
		} else if (e.getSource() == b15) {
			gt1 = t24.getText();
			gt2 = t25.getText();
			gt3 = t26.getText();
			gt4 = t27.getText();
			gt5 = t28.getText();
			// 在数据库中保存信息
			Warning w = new Warning();
			w.warning(this, "保存成功！");
			if (checkstate == 1)
				card.previous(p0);
			else if (checkstate == 2)
				card.next(p0);
		} else if (e.getSource() == b16) {
			card.previous(p0);
			t30.setText(null);
			t31.setText(null);
			t32.setText(null);
			t33.setText(null);
			t34.setText(null);
			checkstate = 2;
		} else if (e.getSource() == b17) {
			if (rb5.isSelected()) {
				gt1 = t36.getText();
				gt2 = t37.getText();
				gt3 = t39.getText();
				gt4 = t40.getText();
				// 从数据库中查询gt2号老师第gt1周的课表,若成功则check1变true，存入get中
				if (check1) {
					t35.setText(null);
					for (i = 0; i < get.length; i++) {
						for (j = 0; j < get[i].length; j++) {
							t35.append(get[i][j].toString() + " ");
						}
						t35.append("\n");
					}
					if (Integer.parseInt(gt3) >= 1
							&& Integer.parseInt(gt3) <= 7
							&& Integer.parseInt(gt4) >= 1
							&& Integer.parseInt(gt4) <= 8) {
						// 在数据库中gt2的第gt1周周gt3第gt4课时的预约状态置无并赋值gt5
						t41.setText(gt5);
					} else {
						Warning w = new Warning();
						w.warning(this, "部分查询失败");
					}
				} else {
					Warning w = new Warning();
					w.warning(this, "查询失败");
				}
			} else if (rb6.isSelected()) {
				gt1 = t38.getText();
				// 在数据库中检索姓名是gt1的学生，检索到则check1为true，并赋值get
				if (check1) {
					t35.setText(null);
					for (i = 0; i < get.length; i++) {
						for (j = 0; j < get[i].length; j++) {
							t35.append(get[i][j].toString() + " ");
						}
						t35.append("\n");
					}
				} else {
					Warning w = new Warning();
					w.warning(this, "该用户不存在");
				}
			} else if (rb7.isSelected()) {
				// 在数据库中检索预约人为user的老师、时间，存入get
				t35.setText(null);
				for (i = 0; i < get.length; i++) {
					for (j = 0; j < get[i].length; j++) {
						t35.append(get[i][j].toString() + " ");
					}
					t35.append("\n");
				}
			}
		} else if (e.getSource() == b18) {
			if (rb5.isSelected()) {
				gt1 = t36.getText();
				i = Integer.parseInt(gt1) - 1;
				if (i == 0)
					i = 20;
				gt1 = "" + i;
				gt2 = t37.getText();
				gt3 = t39.getText();
				gt4 = t40.getText();
				// 从数据库中查询gt2号老师第gt1周的课表,若成功则check1变true，存入get中
				if (check1) {
					t35.setText(null);
					for (i = 0; i < get.length; i++) {
						for (j = 0; j < get[i].length; j++) {
							t35.append(get[i][j].toString() + " ");
						}
						t35.append("\n");
					}
					if (Integer.parseInt(gt3) >= 1
							&& Integer.parseInt(gt3) <= 7
							&& Integer.parseInt(gt4) >= 1
							&& Integer.parseInt(gt4) <= 8) {
						// 在数据库中gt2的第gt1周周gt3第gt4课时的预约状态置无并赋值gt5
						t41.setText(gt5);
					} else {
						Warning w = new Warning();
						w.warning(this, "部分查询失败");
					}
				} else {
					Warning w = new Warning();
					w.warning(this, "查询失败");
				}
			} else {
				Warning w = new Warning();
				w.warning(this, "请先选中查询课表");
			}
		} else if (e.getSource() == b19) {
			if (rb5.isSelected()) {
				gt1 = t36.getText();
				i = Integer.parseInt(gt1) % 20 + 1;
				gt1 = "" + i;
				gt2 = t37.getText();
				gt3 = t39.getText();
				gt4 = t40.getText();
				// 从数据库中查询gt2号老师第gt1周的课表,若成功则check1变true，存入get中
				if (check1) {
					t35.setText(null);
					for (i = 0; i < get.length; i++) {
						for (j = 0; j < get[i].length; j++) {
							t35.append(get[i][j].toString() + " ");
						}
						t35.append("\n");
					}
					if (Integer.parseInt(gt3) >= 1
							&& Integer.parseInt(gt3) <= 7
							&& Integer.parseInt(gt4) >= 1
							&& Integer.parseInt(gt4) <= 8) {
						// 在数据库中gt2的第gt1周周gt3第gt4课时的预约状态置无并赋值gt5
						t41.setText(gt5);
					} else {
						Warning w = new Warning();
						w.warning(this, "部分查询失败");
					}
				} else {
					Warning w = new Warning();
					w.warning(this, "查询失败");
				}
			} else {
				Warning w = new Warning();
				w.warning(this, "请先选中查询课表");
			}
		} else if (e.getSource() == b20) {
			gt1 = t36.getText();
			gt2 = t37.getText();
			gt3 = t39.getText();
			gt4 = t40.getText();
			// 在数据库中gt2的第gt1周周gt3第gt4课时的预约状态
			// 若为闲/未预约，返回check1为true，修改为已预约状态并赋值gt5
			if (check1) {
				Warning w = new Warning();
				w.warning(this, "预约成功");
				t41.setText(gt5);
			} else {
				Warning w = new Warning();
				w.warning(this, "老师忙");
			}
		} else if (e.getSource() == b21) {
			card.first(p0);
			t1.setText(null);
			t2.setText(null);
			user = null;
		}
	}
}
