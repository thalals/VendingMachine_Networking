//음료를 뽑는 클래스
package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TakeCan implements ActionListener {

	JButton getCan;		//버튼 객체 생성
	
	public TakeCan(JButton getCan) {
		super();
		this.getCan = getCan;
	}
	
	//버튼 클릭시 음료와 메세지 송출
	public void actionPerformed(ActionEvent e) {
		getCan.setIcon(new ImageIcon("canreturn.png"));
		JOptionPane.showMessageDialog(new JFrame(), "감사합니다.");
	}

}
