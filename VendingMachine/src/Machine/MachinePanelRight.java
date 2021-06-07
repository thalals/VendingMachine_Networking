package Machine;
//���Ǳ� ���� ������ �޴�
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Action.AddCanFrame;
import Action.AddCoinFrame;
import Can.CanArray;
import Coin.CoinArray;
import Person.Admin;

public class MachinePanelRight extends JPanel implements ActionListener {

//	JTextField adminPass;
	JPasswordField adminPass;
	JPanel canAdminPanel, moneyAdminPanel, moneyTotalPanel;
	JButton btnAdminIn, btnAddCanStart, btnAddCan;
	JLabel label,labe2;
	String password;
	DefaultTableModel canModel;
	public static JLabel totalMoneyLabel;
	public static JTable canTable, moneyTable;

	public MachinePanelRight(String password) {
		this.password = password;
		// ���� ������ �ǳ�

		setPreferredSize(new Dimension(280, 550));

		label = new JLabel("������������ ������ �����ڷ� �������ּ���!");
		label.setVisible(true);		

		// ------------ <������� ���� �ǳ�> ------------ //
		canAdminPanel = new JPanel(new BorderLayout());

		String[] canColName = { "�����̸�", "���", "���� �ǸŰ���" };
		canModel = new DefaultTableModel(canColName, 0);
		canTable = new JTable(canModel);
		JScrollPane canScrollPanel = new JScrollPane(canTable);
		canScrollPanel.setPreferredSize(new Dimension(230, 150));

		btnAddCan = new JButton("�����߰�");
		btnAddCan.addActionListener(new AddCanFrame(canTable));

		canAdminPanel.add(new JLabel("�������"), BorderLayout.WEST);
		canAdminPanel.add(btnAddCan, BorderLayout.EAST);
		canAdminPanel.add(canScrollPanel, BorderLayout.SOUTH);
		canAdminPanel.setVisible(false);

		for (int i = 0; i < CanArray.canList.size(); i++) {
			String arr[] = { CanArray.canList.get(i).getCanName(),
					Integer.toString(CanArray.canList.get(i).getCanNum()),
					Integer.toString(CanArray.canList.get(i).getCanPrice()) };
			canModel.addRow(arr);
		}

		// ------------ <�ܵ� ���� �ǳ�> ------------ //
		moneyAdminPanel = new JPanel(new BorderLayout());

		String[] moneyColName = { "���� ����", "���� ����", };
		DefaultTableModel moneyModel = new DefaultTableModel(moneyColName, 0);
		moneyTable = new JTable(moneyModel);
		JScrollPane moneyScrollPanel = new JScrollPane(moneyTable);
		moneyScrollPanel.setPreferredSize(new Dimension(230, 150));

		JButton btnAddMoney = new JButton("�ܵ��߰�");
		btnAddMoney.addActionListener(new AddCoinFrame(moneyTable));
		moneyAdminPanel.add(new JLabel("�ܵ�����"), BorderLayout.CENTER);
		moneyAdminPanel.add(btnAddMoney, BorderLayout.EAST);
		moneyAdminPanel.add(moneyScrollPanel, BorderLayout.SOUTH);
		moneyAdminPanel.setVisible(false);

		moneyModel = (DefaultTableModel) moneyTable.getModel();

		for (int i = 0; i < CoinArray.coinList.size(); i++) {
			String arr[] = { CoinArray.coinList.get(i).getCoinName(),
					Integer.toString(CoinArray.coinList.get(i).getCoinNum()) };
			moneyModel.addRow(arr);
		}

		moneyTotalPanel = new JPanel(new BorderLayout());
		totalMoneyLabel = new JLabel("�� ����� : " + Admin.getTotalMoney());
		moneyTotalPanel.add(totalMoneyLabel);
		moneyTotalPanel.setVisible(false);

		// ------------ <������ ���� �ǳ�> ----------- //
		JPanel inAdminPanel = new JPanel();

//		adminPass = new JTextField(10);
		adminPass = new JPasswordField(10);
		adminPass.setEchoChar('*');			//��й�ȣ ������
		btnAdminIn = new JButton("����");
		adminPass.addActionListener(this);
		btnAdminIn.addActionListener(this);

		inAdminPanel.add(new JLabel("������"));
		inAdminPanel.add(adminPass);
		inAdminPanel.add(btnAdminIn);

		add(inAdminPanel);
		add(canAdminPanel);
		add(label);
		add(moneyAdminPanel);
		add(moneyTotalPanel);
	}

	//��ư �׼�(��ư Ŭ�� �� ����)
	public void actionPerformed(ActionEvent e) {
		// ������ ���� ��й�ȣȮ��
				if(!canAdminPanel.isVisible()){
					if(adminPass.getText().equals(password)){
						
						label.setVisible(false);
						canAdminPanel.setVisible(true);
						moneyAdminPanel.setVisible(true);
						moneyTotalPanel.setVisible(true);
						
						btnAdminIn.setText("��������");
						adminPass.setText("");
						adminPass.setVisible(false);
						
					} 
					else if(adminPass.getText().equals("")) {
						JOptionPane.showMessageDialog(new JFrame(), "��й�ȣ�� �Է����ּ���");
					} 
					else {
						JOptionPane.showMessageDialog(new JFrame(), "��й�ȣ�� Ʋ�Ƚ��ϴ�!");
					}
				} 
				else if(canAdminPanel.isVisible()){
					
					label.setVisible(true);
					canAdminPanel.setVisible(false);
					moneyAdminPanel.setVisible(false);
					moneyTotalPanel.setVisible(false);
					
					btnAdminIn.setText("����");
					adminPass.setVisible(true);
				}
	}

}
