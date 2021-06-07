//������ �޴����� ����� �߰� Ŭ����
package Action;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Can.CanArray;

public class AddCanFrame extends JFrame implements ActionListener{

	JCheckBox canCheck;			//üũ�ڽ�
	JTable canTable;			//�˾� ���̺�
	DefaultTableModel canModel;	//���̺� ��, ��
	
	// ������ �ʱ�ȭ
	public AddCanFrame(JTable canTable){		
		this.canTable = canTable;
	}
	
	public void addCanFrame(JTable canTable){		
		this.canTable = canTable;
		
		List<JCheckBox> canCheckList = new ArrayList<JCheckBox>();
		List<JComboBox> canSelectList = new ArrayList<JComboBox>();
		
		setTitle("�����߰� �˾�");
		setSize(320, 300);
		setLocation(200,200);
		
		// title
		JLabel label = new JLabel("����ᰡ �ʿ��ϽŰ���?");
		JPanel toPanel = new JPanel();
		toPanel.add(label);
		add(toPanel, BorderLayout.NORTH);
		
		// üũ�ڽ� �߰�
		JPanel checkPanel = new JPanel();
		JButton chechAll = new JButton("��ü10���߰�");
		chechAll.setPreferredSize(new Dimension(120, 10));
		chechAll.addActionListener(new ActionSelectAll(canCheckList));
		
		String[] canSelectNum = {"10��","20��","50��"};
		
		for(int i=0; i<CanArray.canList.size();i++){
			JPanel checkEach = new JPanel();
			canCheck = new JCheckBox(CanArray.canList.get(i).getCanName());
			JComboBox<String> canSelectBox = new JComboBox();
			for(int j=0; j<canSelectNum.length; j++){
				canSelectBox.addItem(canSelectNum[j]);
			}
			
			//�迭�� �־��ֱ�
			canCheckList.add(canCheck);
			canSelectList.add(canSelectBox);

			checkEach.add(canCheck);
			checkEach.add(canSelectBox);
			canSelectBox.setVisible(false);
			
			checkPanel.add(checkEach);
			canCheck.addActionListener(new ActionCheck(canSelectList));
			checkEach.setPreferredSize(new Dimension(160, 30));
		}
		
		
	
		add(chechAll, BorderLayout.WEST);
		add(checkPanel, BorderLayout.CENTER);
		
		JButton btnAdd = new JButton("�߰�");
		JButton btnCancle = new JButton("���");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btnAdd);
		buttonPanel.add(btnCancle);
		add(buttonPanel, BorderLayout.SOUTH);
		btnAdd.addActionListener(new ActionAddCan(this, chechAll, canCheckList, canSelectList));
		btnCancle.addActionListener(new ActionCancle(this));
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		addCanFrame(canTable);
	}
}
