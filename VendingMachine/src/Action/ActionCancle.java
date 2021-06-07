//x눌러서 종료시 실행창 닫기
package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ActionCancle implements ActionListener {	
	JFrame frame;	
	public ActionCancle(JFrame frame){
		this.frame = frame;
	}
	
	//하나의 프레임만을 닫음
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}
	
}
