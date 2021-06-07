//���� ���� ��ư ����
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
		this.takeMoneytext = takeMoneytext;		//������	
		this.getCan = getCan;					//���õ� ����
		this.blist = blist;						//��ư ����Ʈ
	}
	
	//��ư ���� �׼� �Լ�
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton b = (JButton) obj;

		// �Ĵ� ��������� ���Ͻ� ����� ����
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
			// ���Ǳ⿡ ���� ���� ������ ������� ���ݺ��� ������
			if (Integer.parseInt(takeMoneytext.getText()) >= selectCanPrice) {

				for (int i = 0; i < CanArray.canList.size(); i++) {
					if (b.getLabel().equals(CanArray.canList.get(i).getCanName())) {

						// ��� ������
						if (CanArray.canList.get(i).getCanNum() > 0) {

							// �ܵ� ǥ��
							int returnMoney1 = 0;
							int returnMoney2 = 0;
							for (int j = 0; j < CanArray.canList.size(); j++) {
								if (b.getLabel().equals(CanArray.canList.get(j).getCanName())) {
									returnMoney1 = Integer.parseInt(takeMoneytext.getText());
									returnMoney2 = CanArray.canList.get(j).getCanPrice();
								}
							}
							takeMoneytext.setText(String.valueOf(returnMoney1 - returnMoney2));

							// (��ư��) ���� ������ ���� �� �ִ� ���� ǥ��
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

							// ���� ĵ ��� -1 & ĵ ��ȯ�̹���
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
						else { // ��� ������
							JOptionPane.showMessageDialog(new JFrame(), "�˼��մϴ�.. ���� ��� �����ϴ� ��_��");
						}
					}
				}

			} 
			else {// ���Ǳ⿡ ���� ���� ������ ������� ���ݺ��� ���� ������ ~
				JOptionPane.showMessageDialog(new JFrame(), "���� ���ڶ��!");
			}

		} 
		else {// ���� �� ����� ���ݺ��� ���� ���� �־��� ��
			JOptionPane.showMessageDialog(new JFrame(), "���� �������ּ���!");
		}
	}
}
