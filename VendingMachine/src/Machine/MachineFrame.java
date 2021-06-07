package Machine;
//머신 프레임 클래스
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
	String password;			//관리자 비밀번호
	public MachineFrame(String password){
		this.password = password;
		
		// 자판기 내 음료수 추가
		// 재고 3으로 초기화
		//음류수는 물, 커피, 이온음류, 고급커피, 탄산 5종류
		CanArray.canList.add(new Can("물", 3, 450));
		CanArray.canList.add(new Can("커피", 3, 500));
		CanArray.canList.add(new Can("이온음료", 3, 550));
		CanArray.canList.add(new Can("고급커피", 3, 700));
		CanArray.canList.add(new Can("탄산", 3, 750));
		
		//자판기 내 동전양 5개로 초기화
		CoinArray.coinList.add(new Coin("10",5));
		CoinArray.coinList.add(new Coin("50",5));
		CoinArray.coinList.add(new Coin("100",5));
		CoinArray.coinList.add(new Coin("500",5));
		CoinArray.coinList.add(new Coin("1000",5));
		
		setTitle("자판기 관리 프로그램 - 네트워크");
		setPreferredSize(new Dimension(650,550));	//JFrame 의 크기 조절
		setLocation(400,150);		// 바탕화면내에 나타는 위치 좌표
		
		WindowListener win = new WindowAdapter() {
			//window 가 닫힐때 x 를 누르면 종료
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		};
		
		addWindowListener(win);	//윈도우어댑터 win 등록

		//프래임에 연결된 컨텐트팬 체크
		Container contentPanel = getContentPane();
		
		// 프레임 오른쪽에 관리자 메뉴 
		JPanel panelRight = new MachinePanelRight(password);
		//프레임 왼쪽에는 자판기
		JPanel panelLeft = new MachinePanelLeft();
		
		//위치 조절
		contentPanel.add(panelRight,BorderLayout.EAST);
		contentPanel.add(panelLeft,BorderLayout.CENTER);

		// 프레임내에 서브컴포넌트들의 레이아웃과 Prefered Size에 맞도록 			윈도우의 사이즈를 맞춰주는 함수이다.
		pack();
		//프레임을 눈에 보이도록 설정
		setVisible(true);
		
	}
}
