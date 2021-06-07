// �� ���Խ��� �߻� Ŭ����
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
	
	//������ �ʱ�ȭ
	public PutMoney(JTextField putMoneytext, JTextField takeMoneytext, List<JButton> blist) {
		super();
		this.putMoneytext = putMoneytext;
		this.takeMoneytext = takeMoneytext;
		this.blist = blist;
	}

	public void actionPerformed(ActionEvent e) {

		if (putMoneytext.getText().equals("")) {
			JOptionPane.showMessageDialog(new JFrame(), "���� ���� �ʾҽ��ϴ�.");
		}
		//�� ���Խ� ���� ��Ī
		else if (Pattern.matches("^[0-9]*$", putMoneytext.getText())) {	//���ڸ� ���

			boolean pattern;

			if (Integer.parseInt(putMoneytext.getText()) < 100) {
				pattern = Pattern.matches("[0,5]?0$", putMoneytext.getText());	//0,5�� ��� 0�տ� �ƹ��͵� ������ �ȵ�
			}
			
			else if (Integer.parseInt(putMoneytext.getText()) <= 3000) {
				pattern = Pattern.matches("[1-9]((\\d){0,2}[0,5])?0$", putMoneytext.getText());
			} 
			else {
				pattern = false;
			}
			
			if (pattern == false) {
				JOptionPane.showMessageDialog(new JFrame(), "����� 3000�� ������ ������, ������ 50 ������ �־��ּ���");
			}
			
			else {
				//�Է¹��� ��
				takeMoneytext.setText(String.valueOf(Integer.parseInt(takeMoneytext.getText()) + Integer.parseInt(putMoneytext.getText())));
				
				//�Է¹��� ���� 5000�� �̻��Ͻ� �޼��� ���
				if(Integer.parseInt(takeMoneytext.getText())>5000) {
					takeMoneytext.setText(String.valueOf(Integer.parseInt(takeMoneytext.getText()) - Integer.parseInt(putMoneytext.getText())));
					JOptionPane.showMessageDialog(new JFrame(), "���� 5000�� �̻� �Է��ϽǼ� �����ϴ�.");
				}
				//�Է� �ݾ׿� ���� �����Ҽ� �ִ� ������ ǥ��
				for (int i = 0; i < blist.size(); i++) {
					if (blist.get(i).getLabel().equals(CanArray.canList.get(i).getCanName())) {
						if (CanArray.canList.get(i).getCanPrice() <= Integer.parseInt(takeMoneytext.getText())) {
							blist.get(i).setForeground(new Color(255, 255, 255));//���
	//�̱� ������ ������ ���� ���
	blist.get(i).setBackground(new Color(50, 100, 250));						}
					}
				}
				//����� �߰�
				Admin.setTotalMoney(Admin.getTotalMoney() + Integer.parseInt(putMoneytext.getText()));
				MachinePanelRight.totalMoneyLabel.setText("�� ����� : " + Admin.getTotalMoney());

				putMoneytext.setText("");
			}
		} 
		else {
			JOptionPane.showMessageDialog(new JFrame(), "���� �������� �Է����ּ���");
		}
	}
}
