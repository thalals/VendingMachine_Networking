//�ܵ� �߰� ���� ���
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
		this.checkList = checkList;			//üũ ����Ʈ
		this.selectList = selectList;		//���õ� ����Ʈ
		this.chechAll = chechAll;			// ��� ����
	}

	public void actionPerformed(ActionEvent e) {
		// =========�ܵ� �߰� ��ư=============
			
		coinModel =  (DefaultTableModel)MachinePanelRight.moneyTable.getModel();
		if (coinModel.getRowCount() != 0) {
			coinModel.setRowCount(0);
		}
		for(int i=0; i<checkList.size();i++){
			if(checkList.get(i).isSelected()){
				if(selectList.get(i).getSelectedItem().equals("10��")){
					CoinArray.coinList.get(i).setCoinNum(CoinArray.coinList.get(i).getCoinNum() + 10);
				} else if(selectList.get(i).getSelectedItem().equals("20��")){
					CoinArray.coinList.get(i).setCoinNum(CoinArray.coinList.get(i).getCoinNum() + 20);
				} else if(selectList.get(i).getSelectedItem().equals("50��")){
					CoinArray.coinList.get(i).setCoinNum(CoinArray.coinList.get(i).getCoinNum() + 50);
				}
				checkList.get(i).setSelected(false);
			}
		}
		
		for(int i=0;i<selectList.size();i++){
			selectList.get(i).setVisible(false);
			chechAll.setLabel("��ü10���߰�");
		}

		for (int i = 0; i < CoinArray.coinList.size(); i++) {
			String arr[] = { CoinArray.coinList.get(i).getCoinName(), Integer.toString(CoinArray.coinList.get(i).getCoinNum())};
			coinModel.addRow(arr);
		}
			
		frame.dispose();
		this.setVisible(false);
	}
}
