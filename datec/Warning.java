package datec;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Warning {
	JDialog d = null;
	public void warning(JFrame jf, String wl) {
		// 警示对话框
		d = new JDialog(jf, "提示", true);
		d.setSize(300, 100);
		d.setVisible(true);
		d.setResizable(false);
		d.setLocationRelativeTo(null);
		JPanel p0 = new JPanel();
		d.add(p0);
		p0.setLayout(null);
		JButton b0 = new JButton("确认");
		p0.add(b0);
		b0.setBounds(75, 50, 50, 25);
		b0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.dispose();
			}
		});
	}
}
