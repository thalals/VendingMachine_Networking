// 돈 투입시의 발생 클래스
package Action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Can.CanArray;
import Machine.MachinePanelRight;
import Person.Admin;

public class PutMoney implements ActionListener {

	JTextField putMoneytext, takeMoneytext;
	List<JButton> blist;
	
	//생성자 초기화
	public PutMoney(JTextField putMoneytext, JTextField takeMoneytext, List<JButton> blist) {
		super();
		this.putMoneytext = putMoneytext;
		this.takeMoneytext = takeMoneytext;
		this.blist = blist;
	}

	public void actionPerformed(ActionEvent e) {

		if (putMoneytext.getText().equals("")) {
			JOptionPane.showMessageDialog(new JFrame(), "돈을 넣지 않았습니다.");
		}
		//돈 투입시 패턴 매칭
		else if (Pattern.matches("^[0-9]*$", putMoneytext.getText())) {	//숫자만 허용

			boolean pattern;

			if (Integer.parseInt(putMoneytext.getText()) < 100) {
				pattern = Pattern.matches("[0,5]?0$", putMoneytext.getText());	//0,5만 허용 0앞에 아무것도 없으면 안됨
			}
			
			else if (Integer.parseInt(putMoneytext.getText()) <= 3000) {
				pattern = Pattern.matches("[1-9]((\\d){0,2}[0,5])?0$", putMoneytext.getText());
			} 
			else {
				pattern = false;
			}
			
			if (pattern == false) {
				JOptionPane.showMessageDialog(new JFrame(), "지폐는 3000원 이하의 돈으로, 동전은 50 단위로 넣어주세요");
			}
			
			else {
				//입력받은 돈
				takeMoneytext.setText(String.valueOf(Integer.parseInt(takeMoneytext.getText()) + Integer.parseInt(putMoneytext.getText())));
				
				//입력받은 돈이 5000원 이상일시 메세지 출력
				if(Integer.parseInt(takeMoneytext.getText())>5000) {
					takeMoneytext.setText(String.valueOf(Integer.parseInt(takeMoneytext.getText()) - Integer.parseInt(putMoneytext.getText())));
					JOptionPane.showMessageDialog(new JFrame(), "돈은 5000원 이상 입력하실수 없습니다.");
				}
				//입력 금액에 따라 선택할수 있는 음류수 표시
				for (int i = 0; i < blist.size(); i++) {
					if (blist.get(i).getLabel().equals(CanArray.canList.get(i).getCanName())) {
						if (CanArray.canList.get(i).getCanPrice() <= Integer.parseInt(takeMoneytext.getText())) {
							blist.get(i).setForeground(new Color(255, 255, 255));//흰색
	//뽑기 가능하 음류수 색깔 블루
	blist.get(i).setBackground(new Color(50, 100, 250));						}
					}
				}
				//매출액 추가
				Admin.setTotalMoney(Admin.getTotalMoney() + Integer.parseInt(putMoneytext.getText()));
				MachinePanelRight.totalMoneyLabel.setText("총 매출액 : " + Admin.getTotalMoney());

				putMoneytext.setText("");
			}
		} 
		else {
			JOptionPane.showMessageDialog(new JFrame(), "숫자 형식으로 입력해주세용");
		}
	}
}
