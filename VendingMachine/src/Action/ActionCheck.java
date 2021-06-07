//관리자 메뉴 추가 선택 기능
package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import Can.CanArray;
import Coin.CoinArray;

public class ActionCheck implements ActionListener {
	List<JComboBox> selectList;			// 선택 체크박스
	
	public ActionCheck(List<JComboBox> selectList) {
		super();
		this.selectList = selectList;
	}
	//체크박스 선택시
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JCheckBox c = (JCheckBox)obj;
		
		// 내가 선택한 체크박스 ( 음료 )
		if(selectList.size()>=6){	
			//선택 되었을때
			if(c.isSelected()){
				for(int i=0;i<selectList.size();i++){
					if(CanArray.canList.get(i).getCanName().equals(c.getLabel())){
						selectList.get(i).setVisible(true);
					}
				}
			} 
			else {
				for(int i=0;i<selectList.size();i++){
					if(CanArray.canList.get(i).getCanName().equals(c.getLabel())){
						selectList.get(i).setVisible(false);
					}
				}
			}
		} 
		// 잔돈 체크박스
		else {
			//선택 되었을때
			if(c.isSelected()){
				for(int i=0;i<selectList.size();i++){
					if(CoinArray.coinList.get(i).getCoinName().equals(c.getLabel())){
						selectList.get(i).setVisible(true);
					}
				}
			} 
			else {
				for(int i=0;i<selectList.size();i++){
					if(CoinArray.coinList.get(i).getCoinName().equals(c.getLabel())){
						selectList.get(i).setVisible(false);
					}
				}
			}
		}
		
	}
}