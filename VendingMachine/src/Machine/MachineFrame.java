package Machine;
//�ӽ� ������ Ŭ����
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Can.Can;
import Can.CanArray;
import Coin.Coin;
import Coin.CoinArray;

public class MachineFrame extends JFrame {
	String password;			//������ ��й�ȣ
	public MachineFrame(String password){
		this.password = password;
		
		// ���Ǳ� �� ����� �߰�
		// ��� 3���� �ʱ�ȭ
		//�������� ��, Ŀ��, �̿�����, ���Ŀ��, ź�� 5����
		CanArray.canList.add(new Can("��", 3, 450));
		CanArray.canList.add(new Can("Ŀ��", 3, 500));
		CanArray.canList.add(new Can("�̿�����", 3, 550));
		CanArray.canList.add(new Can("���Ŀ��", 3, 700));
		CanArray.canList.add(new Can("ź��", 3, 750));
		
		//���Ǳ� �� ������ 5���� �ʱ�ȭ
		CoinArray.coinList.add(new Coin("10",5));
		CoinArray.coinList.add(new Coin("50",5));
		CoinArray.coinList.add(new Coin("100",5));
		CoinArray.coinList.add(new Coin("500",5));
		CoinArray.coinList.add(new Coin("1000",5));
		
		setTitle("���Ǳ� ���� ���α׷� - ��Ʈ��ũ");
		setPreferredSize(new Dimension(650,550));	//JFrame �� ũ�� ����
		setLocation(400,150);		// ����ȭ�鳻�� ��Ÿ�� ��ġ ��ǥ
		
		WindowListener win = new WindowAdapter() {
			//window �� ������ x �� ������ ����
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		};
		
		addWindowListener(win);	//���������� win ���

		//�����ӿ� ����� ����Ʈ�� üũ
		Container contentPanel = getContentPane();
		
		// ������ �����ʿ� ������ �޴� 
		JPanel panelRight = new MachinePanelRight(password);
		//������ ���ʿ��� ���Ǳ�
		JPanel panelLeft = new MachinePanelLeft();
		
		//��ġ ����
		contentPanel.add(panelRight,BorderLayout.EAST);
		contentPanel.add(panelLeft,BorderLayout.CENTER);

		// �����ӳ��� ����������Ʈ���� ���̾ƿ��� Prefered Size�� �µ��� 			�������� ����� �����ִ� �Լ��̴�.
		pack();
		//�������� ���� ���̵��� ����
		setVisible(true);
		
	}
}
