//음료수 추가 액션 이벤트 클래스
package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import Can.CanArray;
import Machine.MachinePanelRight;
import Person.Admin;


public class ActionAddCan implements ActionListener {

	JFrame frame;
	DefaultTableModel canModel;			//음류수 행,열
	List<JCheckBox> checkList;			//체크리스트
	List<JComboBox> selectList;			//선택된 리트트
	JButton chechAll;					//모두 선택 버튼
	
	public ActionAddCan(JFrame frame, JButton chechAll, List<JCheckBox> checkList, List<JComboBox> selectList){
		super();
		this.frame = frame;
		this.checkList = checkList;
		this.selectList = selectList; 
		this.chechAll=chechAll;
	}

	public void actionPerformed(ActionEvent e) {		
		// =========음료 추가 버튼=============
		
		canModel = (DefaultTableModel)MachinePanelRight.canTable.getModel();
		if (canModel.getRowCount() != 0) {
			canModel.setRowCount(0);
		}
		
		for(int i=0; i<checkList.size();i++){
			if(checkList.get(i).isSelected()){
				if(selectList.get(i).getSelectedItem().equals("10개")){
					CanArray.canList.get(i).setCanNum(CanArray.canList.get(i).getCanNum() + 10);
				} else if(selectList.get(i).getSelectedItem().equals("20개")){
					CanArray.canList.get(i).setCanNum(CanArray.canList.get(i).getCanNum() + 20);
				} else if(selectList.get(i).getSelectedItem().equals("50개")){
					CanArray.canList.get(i).setCanNum(CanArray.canList.get(i).getCanNum() + 50);
				}
				checkList.get(i).setSelected(false);
				
				if(selectList.get(i).getSelectedItem().equals("10개")){
					Admin.setTotalMoney(Admin.getTotalMoney()-(int)((CanArray.canList.get(i).getCanPrice()*10)*0.7));
				} else if(selectList.get(i).getSelectedItem().equals("20개")){
					Admin.setTotalMoney(Admin.getTotalMoney()-(int)((CanArray.canList.get(i).getCanPrice()*20)*0.7));
				} else if(selectList.get(i).getSelectedItem().equals("50개")){
					Admin.setTotalMoney(Admin.getTotalMoney()-(int)((CanArray.canList.get(i).getCanPrice()*50)*0.7));
				}
				
				MachinePanelRight.totalMoneyLabel.setText("총 매출액 : " + Admin.getTotalMoney());
			}
		}
		
		for(int i=0;i<selectList.size();i++){
			selectList.get(i).setVisible(false);
			chechAll.setLabel("전체10개추가");
		}
		

		for (int i=0; i<CanArray.canList.size(); i++) {
			String arr[] = { CanArray.canList.get(i).getCanName(), Integer.toString(CanArray.canList.get(i).getCanNum()),
					Integer.toString(CanArray.canList.get(i).getCanPrice()) };
			canModel.addRow(arr);
		}

		frame.dispose();
	}
}
