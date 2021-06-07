package Machine;
//자판기 내의 관리자 메뉴
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
		// 우측 관리자 판넬

		setPreferredSize(new Dimension(280, 550));

		label = new JLabel("관리페이지를 보려면 관리자로 접속해주세요!");
		label.setVisible(true);		

		// ------------ <음료재고 관리 판넬> ------------ //
		canAdminPanel = new JPanel(new BorderLayout());

		String[] canColName = { "음료이름", "재고", "개당 판매가격" };
		canModel = new DefaultTableModel(canColName, 0);
		canTable = new JTable(canModel);
		JScrollPane canScrollPanel = new JScrollPane(canTable);
		canScrollPanel.setPreferredSize(new Dimension(230, 150));

		btnAddCan = new JButton("음료추가");
		btnAddCan.addActionListener(new AddCanFrame(canTable));

		canAdminPanel.add(new JLabel("음료관리"), BorderLayout.WEST);
		canAdminPanel.add(btnAddCan, BorderLayout.EAST);
		canAdminPanel.add(canScrollPanel, BorderLayout.SOUTH);
		canAdminPanel.setVisible(false);

		for (int i = 0; i < CanArray.canList.size(); i++) {
			String arr[] = { CanArray.canList.get(i).getCanName(),
					Integer.toString(CanArray.canList.get(i).getCanNum()),
					Integer.toString(CanArray.canList.get(i).getCanPrice()) };
			canModel.addRow(arr);
		}

		// ------------ <잔돈 관리 판넬> ------------ //
		moneyAdminPanel = new JPanel(new BorderLayout());

		String[] moneyColName = { "동전 종류", "남은 갯수", };
		DefaultTableModel moneyModel = new DefaultTableModel(moneyColName, 0);
		moneyTable = new JTable(moneyModel);
		JScrollPane moneyScrollPanel = new JScrollPane(moneyTable);
		moneyScrollPanel.setPreferredSize(new Dimension(230, 150));

		JButton btnAddMoney = new JButton("잔돈추가");
		btnAddMoney.addActionListener(new AddCoinFrame(moneyTable));
		moneyAdminPanel.add(new JLabel("잔돈관리"), BorderLayout.CENTER);
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
		totalMoneyLabel = new JLabel("총 매출액 : " + Admin.getTotalMoney());
		moneyTotalPanel.add(totalMoneyLabel);
		moneyTotalPanel.setVisible(false);

		// ------------ <관리자 접속 판넬> ----------- //
		JPanel inAdminPanel = new JPanel();

//		adminPass = new JTextField(10);
		adminPass = new JPasswordField(10);
		adminPass.setEchoChar('*');			//비밀번호 가리기
		btnAdminIn = new JButton("접속");
		adminPass.addActionListener(this);
		btnAdminIn.addActionListener(this);

		inAdminPanel.add(new JLabel("관리자"));
		inAdminPanel.add(adminPass);
		inAdminPanel.add(btnAdminIn);

		add(inAdminPanel);
		add(canAdminPanel);
		add(label);
		add(moneyAdminPanel);
		add(moneyTotalPanel);
	}

	//버튼 액션(버튼 클릭 시 실행)
	public void actionPerformed(ActionEvent e) {
		// 관리자 접속 비밀번호확인
				if(!canAdminPanel.isVisible()){
					if(adminPass.getText().equals(password)){
						
						label.setVisible(false);
						canAdminPanel.setVisible(true);
						moneyAdminPanel.setVisible(true);
						moneyTotalPanel.setVisible(true);
						
						btnAdminIn.setText("접속해제");
						adminPass.setText("");
						adminPass.setVisible(false);
						
					} 
					else if(adminPass.getText().equals("")) {
						JOptionPane.showMessageDialog(new JFrame(), "비밀번호를 입력해주세요");
					} 
					else {
						JOptionPane.showMessageDialog(new JFrame(), "비밀번호가 틀렸습니다!");
					}
				} 
				else if(canAdminPanel.isVisible()){
					
					label.setVisible(true);
					canAdminPanel.setVisible(false);
					moneyAdminPanel.setVisible(false);
					moneyTotalPanel.setVisible(false);
					
					btnAdminIn.setText("접속");
					adminPass.setVisible(true);
				}
	}

}
