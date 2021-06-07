//음료 선택 버튼 제어
package Action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Can.CanArray;
import Machine.MachinePanelRight;
import Person.Admin;

public class ButtonAction implements ActionListener {

	JTextField takeMoneytext;
	JButton getCan;
	List<JButton> blist;

	public ButtonAction(JTextField takeMoneytext, JButton getCan, List<JButton> blist) {
		super();
		this.takeMoneytext = takeMoneytext;		//받은돈	
		this.getCan = getCan;					//선택된 음료
		this.blist = blist;						//버튼 리스트
	}
	
	//버튼 선택 액션 함수
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton b = (JButton) obj;

		// 파는 음료수들중 제일싼 음료수 가격
		int minPrice = 10000;
		for (int i = 0; i < CanArray.canList.size(); i++) {
			if (minPrice >= CanArray.canList.get(i).getCanPrice()) {
				minPrice = CanArray.canList.get(i).getCanPrice();
			}
		}

		if (minPrice <= Integer.parseInt(takeMoneytext.getText())) {

			int selectCanPrice = 0;
			for (int i = 0; i < CanArray.canList.size(); i++) {
				if (CanArray.canList.get(i).getCanName().equals(b.getLabel())) {
					selectCanPrice = CanArray.canList.get(i).getCanPrice();
					break;
				}
			}
			// 자판기에 들어온 돈이 선택한 음료수의 가격보다 많을때
			if (Integer.parseInt(takeMoneytext.getText()) >= selectCanPrice) {

				for (int i = 0; i < CanArray.canList.size(); i++) {
					if (b.getLabel().equals(CanArray.canList.get(i).getCanName())) {

						// 재고가 있으면
						if (CanArray.canList.get(i).getCanNum() > 0) {

							// 잔돈 표시
							int returnMoney1 = 0;
							int returnMoney2 = 0;
							for (int j = 0; j < CanArray.canList.size(); j++) {
								if (b.getLabel().equals(CanArray.canList.get(j).getCanName())) {
									returnMoney1 = Integer.parseInt(takeMoneytext.getText());
									returnMoney2 = CanArray.canList.get(j).getCanPrice();
								}
							}
							takeMoneytext.setText(String.valueOf(returnMoney1 - returnMoney2));

							// (버튼색) 남은 돈으로 뽑을 수 있는 음료 표시
							for (int k = 0; k < blist.size(); k++) {
								if (blist.get(k).getLabel().equals(CanArray.canList.get(k).getCanName())) {
									if (CanArray.canList.get(k).getCanPrice() <= Integer
											.parseInt(takeMoneytext.getText())) {
										blist.get(k).setForeground(new Color(255, 255, 255));
										blist.get(k).setBackground(new Color(50, 100, 250));
									} 
									else {
										blist.get(k).setForeground(new Color(0, 0, 0));
										blist.get(k).setBackground(new Color(255, 255, 255));
									}
								}
							}

							// 뽑은 캔 재고 -1 & 캔 반환이미지
							CanArray.canList.get(i).setCanNum(CanArray.canList.get(i).getCanNum() - 1);
							DefaultTableModel canModel = (DefaultTableModel) MachinePanelRight.canTable.getModel();
							canModel.setRowCount(0);
							for (int j = 0; j < CanArray.canList.size(); j++) {
								String arr[] = { CanArray.canList.get(j).getCanName(),
										Integer.toString(CanArray.canList.get(j).getCanNum()),
										Integer.toString(CanArray.canList.get(j).getCanPrice()) };
								canModel.addRow(arr);
							}
							getCan.setIcon(new ImageIcon("return" + i + ".png"));

						}
						else { // 재고가 없으면
							JOptionPane.showMessageDialog(new JFrame(), "죄송합니다.. 음료 재고가 없습니다 ㅠ_ㅠ");
						}
					}
				}

			} 
			else {// 자판기에 들어온 돈이 선택한 음료수의 가격보다 많지 않으면 ~
				JOptionPane.showMessageDialog(new JFrame(), "돈이 모자라요!");
			}

		} 
		else {// 제일 싼 음료수 가격보다 적은 돈을 넣었을 때
			JOptionPane.showMessageDialog(new JFrame(), "돈을 투입해주세요!");
		}
	}
}
