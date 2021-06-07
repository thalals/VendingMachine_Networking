//관리자 메뉴에서 음료수 추가 클래스
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

	JCheckBox canCheck;			//체크박스
	JTable canTable;			//팝업 테이블
	DefaultTableModel canModel;	//테이블 행, 열
	
	// 생성자 초기화
	public AddCanFrame(JTable canTable){		
		this.canTable = canTable;
	}
	
	public void addCanFrame(JTable canTable){		
		this.canTable = canTable;
		
		List<JCheckBox> canCheckList = new ArrayList<JCheckBox>();
		List<JComboBox> canSelectList = new ArrayList<JComboBox>();
		
		setTitle("음료추가 팝업");
		setSize(320, 300);
		setLocation(200,200);
		
		// title
		JLabel label = new JLabel("어떤음료가 필요하신가요?");
		JPanel toPanel = new JPanel();
		toPanel.add(label);
		add(toPanel, BorderLayout.NORTH);
		
		// 체크박스 추가
		JPanel checkPanel = new JPanel();
		JButton chechAll = new JButton("전체10개추가");
		chechAll.setPreferredSize(new Dimension(120, 10));
		chechAll.addActionListener(new ActionSelectAll(canCheckList));
		
		String[] canSelectNum = {"10개","20개","50개"};
		
		for(int i=0; i<CanArray.canList.size();i++){
			JPanel checkEach = new JPanel();
			canCheck = new JCheckBox(CanArray.canList.get(i).getCanName());
			JComboBox<String> canSelectBox = new JComboBox();
			for(int j=0; j<canSelectNum.length; j++){
				canSelectBox.addItem(canSelectNum[j]);
			}
			
			//배열에 넣어주기
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
		
		JButton btnAdd = new JButton("추가");
		JButton btnCancle = new JButton("취소");
		
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
