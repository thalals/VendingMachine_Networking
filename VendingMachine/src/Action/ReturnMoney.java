// 잔돈 반환 클래스
package Action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Can.CanArray;
import Coin.CoinArray;
import Machine.MachinePanelRight;
import Person.Admin;

public class ReturnMoney implements ActionListener {

	JTextField takeMoneytext;	//객체 생성
	JButton getCan;
	List<JButton> blist;

	//생성자 초기화
	public ReturnMoney(JTextField takeMoneytext, JButton getCan, List<JButton> blist) {
		super();
		this.takeMoneytext = takeMoneytext;
		this.getCan = getCan;
		this.blist = blist;
	}
	
	public void actionPerformed(ActionEvent e) {
		// 문자열을 정수형 숫자로 바꿔 주는 parseInt 객체
		int returnMoney = Integer.parseInt(takeMoneytext.getText());

		int return1000 = 0;
		int return500 = 0;
		int return100 = 0;
		int return50 = 0;
		int return10 = 0;

		if (returnMoney > 0) {
			return1000 = returnMoney / 1000;
			return500 = (returnMoney % 1000) / 500;
			return100 = ((returnMoney % 1000) % 500) / 100;
			return50 = (((returnMoney % 1000) % 500) % 100) / 50;
			return10 = ((((returnMoney % 1000) % 500) % 100) % 50) / 10;
			
			//매출액 감소
			Admin.setTotalMoney(Admin.getTotalMoney() - returnMoney);
			MachinePanelRight.totalMoneyLabel.setText("총 매출액 : " + Admin.getTotalMoney());
			
			//1000원 반출
			for(int i=0;i<return1000;i++){
				if(CoinArray.coinList.get(4).getCoinNum()==0){
					JOptionPane.showMessageDialog(new JFrame(), "1000원 지폐 부족");
					return500 = returnMoney/500;
					break;
				}
				else{
					CoinArray.coinList.get(4).setCoinNum(CoinArray.coinList.get(4).getCoinNum() - 1);
					returnMoney-=1000;
					takeMoneytext.setText(Integer.toString(returnMoney));
				}
			}
			//500원 반출
			for(int i=0;i<return500;i++){
				if(CoinArray.coinList.get(3).getCoinNum()==0){
					JOptionPane.showMessageDialog(new JFrame(), "500원 동전 부족");
					return100 = returnMoney/100;
					break;
				}
				else{
					CoinArray.coinList.get(3).setCoinNum(CoinArray.coinList.get(3).getCoinNum() - 1);
					returnMoney-=500;
					takeMoneytext.setText(Integer.toString(returnMoney));
				}
			}
			//100원 반출
			for(int i=0;i<return100;i++){
				if(CoinArray.coinList.get(2).getCoinNum()==0){					
					JOptionPane.showMessageDialog(new JFrame(), "100원 동전 부족");
					return50 = returnMoney/50;
					break;				
				}
				else{
					CoinArray.coinList.get(2).setCoinNum(CoinArray.coinList.get(2).getCoinNum() - 1);
					returnMoney-=100;
					takeMoneytext.setText(Integer.toString(returnMoney));
				}
			}
			//50원 반출
			for(int i=0;i<return50;i++){
				if(CoinArray.coinList.get(1).getCoinNum()==0){					
					JOptionPane.showMessageDialog(new JFrame(), "50원 동전 부족");
					return10 = returnMoney/10;
					break;				
				}
				else{
					CoinArray.coinList.get(1).setCoinNum(CoinArray.coinList.get(1).getCoinNum() - 1);
					returnMoney-=50;
					takeMoneytext.setText(Integer.toString(returnMoney));
				}
			}
			
			//10원 반출
			for(int i=0;i<return10;i++){
				if(CoinArray.coinList.get(0).getCoinNum()==0){
					JOptionPane.showMessageDialog(new JFrame(), "10원 동전 부족");
					takeMoneytext.setText(Integer.toString(returnMoney));
					break;				
				}
				else{
					CoinArray.coinList.get(0).setCoinNum(CoinArray.coinList.get(0).getCoinNum() - 1);
					returnMoney-=10;
					takeMoneytext.setText(Integer.toString(returnMoney));
				}
			}
			
			//DefaultTableMode1 으로 관리자 메뉴 입출력 관리
			DefaultTableModel moneyModel = (DefaultTableModel) MachinePanelRight.moneyTable.getModel();
			moneyModel.setRowCount(0);		// DefaultTableModel 초기화
			
			//잔돈 관리 메뉴
			for (int j = 0; j < CoinArray.coinList.size(); j++) {
				String arr[] = { CoinArray.coinList.get(j).getCoinName(),
						Integer.toString(CoinArray.coinList.get(j).getCoinNum()) };
				moneyModel.addRow(arr);
			}
			
			// 음류수 관리 메뉴
			for (int k = 0; k < blist.size(); k++) {
				if (blist.get(k).getLabel().equals(CanArray.canList.get(k).getCanName())) {
					blist.get(k).setForeground(new Color(0, 0, 0));
					blist.get(k).setBackground(new Color(255,255,255));
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "반환할 돈이없습니다.");
		}

	}

}
