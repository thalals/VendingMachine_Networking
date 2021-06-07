package Machine;
//������ ���� ���Ǳ� �޴�
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
	JButton getCan, canButton;				//JButton ��ü 
	JTextField putMoneytext, takeMoneytext;		//JTextField ��ü

	public MachinePanelLeft() {
		// ���� ���Ǳ� �޴�
		//�����ӳ� ������ ����
		setPreferredSize(new Dimension(320, 550));
		//blist ���˸� ��ü
		List<JButton> blist = new ArrayList<JButton>();
		// ------------<�� ���ⱸ>-----------//
		JPanel moneyPanel = new JPanel();

		JPanel takeMoneyPanel = new JPanel();
		takeMoneytext = new JTextField(6);	//�ؽ�Ʈ�ʵ� ũ�� ����
		takeMoneytext.setText("0");		//��ĭ���� �ʱ�ȭ
		
		JButton takeMoneyButton = new JButton(new ImageIcon("return.png"));		//��ȯ ��ư gui ���� ����
		takeMoneyButton.setBorder(BorderFactory.createEmptyBorder());		//��ư�� ���� ����
		takeMoneyButton.setContentAreaFilled(false);						//��ư�� ����� ��������
		takeMoneyButton.addActionListener(new ReturnMoney(takeMoneytext, getCan, blist));	//��� ��ü(�ܵ�,������,��ư)

		JPanel putMoneyPanel = new JPanel();
		putMoneytext = new JTextField(6);		//�� ���Ա� �ʵ� ����
		
		
		//�� ���Խ� �̺�Ʈ �߻�
		putMoneytext.addActionListener(new PutMoney(putMoneytext, takeMoneytext, blist));
		JButton putMoneyButton = new JButton("���ֱ�");
		putMoneyButton.addActionListener(new PutMoney(putMoneytext, takeMoneytext, blist));
		
		takeMoneytext.setEditable(false);
		takeMoneyPanel.add(takeMoneytext);
		takeMoneyPanel.add(takeMoneyButton);
		putMoneyPanel.add(putMoneytext);
		putMoneyPanel.add(putMoneyButton);
		
		moneyPanel.add(takeMoneyPanel);
		moneyPanel.add(putMoneyPanel);

		// ----------<�����ȯ��>----------------//
		JPanel getCanPanel = new JPanel();
		getCan = new JButton("");
		getCan.addActionListener(new TakeCan(getCan));
		getCan.setIcon(new ImageIcon("canreturn.png"));
		getCan.setBorder(BorderFactory.createEmptyBorder());
		getCan.setContentAreaFilled(false);

		getCanPanel.add(getCan);

		// ------------<���ἱ��>----------//
		JPanel selectCan = new JPanel(new GridLayout(2, 1));
		selectCan.setPreferredSize(new Dimension(310, 330));

		for (int i = 0; i < CanArray.canList.size(); i++) {
			JPanel canEach = new JPanel();
			JLabel canLabel = new JLabel(CanArray.canList.get(i).getCanPrice() + "��");
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
