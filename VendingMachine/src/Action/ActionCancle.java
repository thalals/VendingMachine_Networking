//x������ ����� ����â �ݱ�
package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ActionCancle implements ActionListener {	
	JFrame frame;	
	public ActionCancle(JFrame frame){
		this.frame = frame;
	}
	
	//�ϳ��� �����Ӹ��� ����
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
	
}
