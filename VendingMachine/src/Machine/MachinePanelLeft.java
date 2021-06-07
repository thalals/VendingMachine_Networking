package Machine;
//프레임 내에 자판기 메뉴
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Action.PutMoney;
import Action.ReturnMoney;
import Action.TakeCan;
import Action.ButtonAction;
import Can.CanArray;

public class MachinePanelLeft extends JPanel {
	JButton getCan, canButton;				//JButton 객체 
	JTextField putMoneytext, takeMoneytext;		//JTextField 객체

	public MachinePanelLeft() {
		// 좌측 자판기 메뉴
		//프레임내 사이즈 지정
		setPreferredSize(new Dimension(320, 550));
		//blist 제넉릭 객체
		List<JButton> blist = new ArrayList<JButton>();
		// ------------<돈 입출구>-----------//
		JPanel moneyPanel = new JPanel();

		JPanel takeMoneyPanel = new JPanel();
		takeMoneytext = new JTextField(6);	//텍스트필드 크기 설정
		takeMoneytext.setText("0");		//빈칸으로 초기화
		
		JButton takeMoneyButton = new JButton(new ImageIcon("return.png"));		//반환 버튼 gui 사진 설정
		takeMoneyButton.setBorder(BorderFactory.createEmptyBorder());		//버튼의 여백 설정
		takeMoneyButton.setContentAreaFilled(false);						//버튼의 배경을 투명으로
		takeMoneyButton.addActionListener(new ReturnMoney(takeMoneytext, getCan, blist));	//출력 객체(잔돈,음류수,버튼)

		JPanel putMoneyPanel = new JPanel();
		putMoneytext = new JTextField(6);		//돈 투입구 필드 지정
		
		
		//돈 투입시 이벤트 발생
		putMoneytext.addActionListener(new PutMoney(putMoneytext, takeMoneytext, blist));
		JButton putMoneyButton = new JButton("돈넣기");
		putMoneyButton.addActionListener(new PutMoney(putMoneytext, takeMoneytext, blist));
		
		takeMoneytext.setEditable(false);
		takeMoneyPanel.add(takeMoneytext);
		takeMoneyPanel.add(takeMoneyButton);
		putMoneyPanel.add(putMoneytext);
		putMoneyPanel.add(putMoneyButton);
		
		moneyPanel.add(takeMoneyPanel);
		moneyPanel.add(putMoneyPanel);

		// ----------<음료반환구>----------------//
		JPanel getCanPanel = new JPanel();
		getCan = new JButton("");
		getCan.addActionListener(new TakeCan(getCan));
		getCan.setIcon(new ImageIcon("canreturn.png"));
		getCan.setBorder(BorderFactory.createEmptyBorder());
		getCan.setContentAreaFilled(false);

		getCanPanel.add(getCan);

		// ------------<음료선택>----------//
		JPanel selectCan = new JPanel(new GridLayout(2, 1));
		selectCan.setPreferredSize(new Dimension(310, 330));

		for (int i = 0; i < CanArray.canList.size(); i++) {
			JPanel canEach = new JPanel();
			JLabel canLabel = new JLabel(CanArray.canList.get(i).getCanPrice() + "원");
			canButton = new JButton(CanArray.canList.get(i).getCanName());
			canButton.addActionListener(new ButtonAction(takeMoneytext, getCan, blist));
			canButton.setForeground(new Color(0, 0, 0));
			canButton.setBackground(new Color(255, 255, 255));
			canEach.add(new JLabel(new ImageIcon(i + ".png")));
			canEach.add(canLabel);
			canEach.add(canButton);
			selectCan.add(canEach);

			blist.add(canButton);
		}

		add(selectCan, BorderLayout.NORTH);
		add(moneyPanel, BorderLayout.CENTER);
		add(getCanPanel, BorderLayout.SOUTH);

		moneyPanel.setBackground(new Color(10, 110, 120));
		takeMoneyPanel.setBackground(new Color(10, 110, 120));
		putMoneyPanel.setBackground(new Color(10, 110, 120));
		getCanPanel.setBackground(new Color(10, 110, 120));
		setBackground(new Color(10, 110, 120));

	}
}
