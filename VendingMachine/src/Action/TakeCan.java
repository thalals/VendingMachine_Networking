//���Ḧ �̴� Ŭ����
package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TakeCan implements ActionListener {

	JButton getCan;		//��ư ��ü ����
	
	public TakeCan(JButton getCan) {
		super();
		this.getCan = getCan;
	}
	
	//��ư Ŭ���� ����� �޼��� ����
	public void actionPerformed(ActionEvent e) {
		getCan.setIcon(new ImageIcon("canreturn.png"));
		JOptionPane.showMessageDialog(new JFrame(), "�����մϴ�.");
	}

}
