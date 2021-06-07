package Coin;

//코인 클래스
public class Coin {
	private String coinName;
	private int coinNum;
	
	//Coin 이름, 갯수 초기화
	public Coin(String coinName, int coinNum) {
		super();
		this.coinName = coinName;
		this.coinNum = coinNum;
	}
	public String getCoinName() {
		return coinName;
	}
	
	//setCoinName 함수로 코인 이름 변경
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public int getCoinNum() {
		return coinNum;
	}
	
	//코인 갯수 변경
	public void setCoinNum(int coinNum) {
		this.coinNum = coinNum;
	}
}
