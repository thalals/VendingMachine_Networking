//잔돈 추가 관리 기능
package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import Coin.CoinArray;
import Machine.MachinePanelRight;

public class ActionAddCoin extends JFrame implements ActionListener{

	JFrame frame;
	DefaultTableModel coinModel;
	List<JCheckBox> checkList;
	List<JComboBox> selectList;
	JButton chechAll;
	
	public ActionAddCoin(JFrame frame, JButton chechAll, List<JCheckBox> checkList, List<JComboBox> selectList){
		super();
		this.frame = frame;			
		this.checkList = checkList;			//체크 리스트
		this.selectList = selectList;		//선택된 리스트
		this.chechAll = chechAll;			// 모두 선택
	}

	public void actionPerformed(ActionEvent e) {
		// =========잔돈 추가 버튼=============
			
		coinModel =  (DefaultTableModel)MachinePanelRight.moneyTable.getModel();
		if (coinModel.getRowCount() != 0) {
			coinModel.setRowCount(0);
		}
		for(int i=0; i<checkList.size();i++){
			if(checkList.get(i).isSelected()){
				if(selectList.get(i).getSelectedItem().equals("10개")){
					CoinArray.coinList.get(i).setCoinNum(CoinArray.coinList.get(i).getCoinNum() + 10);
				} else if(selectList.get(i).getSelectedItem().equals("20개")){
					CoinArray.coinList.get(i).setCoinNum(CoinArray.coinList.get(i).getCoinNum() + 20);
				} else if(selectList.get(i).getSelectedItem().equals("50개")){
					CoinArray.coinList.get(i).setCoinNum(CoinArray.coinList.get(i).getCoinNum() + 50);
				}
				checkList.get(i).setSelected(false);
			}
		}
		
		for(int i=0;i<selectList.size();i++){
			selectList.get(i).setVisible(false);
			chechAll.setLabel("전체10개추가");
		}

		for (int i = 0; i < CoinArray.coinList.size(); i++) {
			String arr[] = { CoinArray.coinList.get(i).getCoinName(), Integer.toString(CoinArray.coinList.get(i).getCoinNum())};
			coinModel.addRow(arr);
		}
			
		frame.dispose();
		this.setVisible(false);
	}
}
