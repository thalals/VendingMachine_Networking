package Can;

//음료수 클래스
public class Can {
	String canName;
	int canNum;
	int canPrice;
	
	//음료수의 종료의 초기화
	public Can(String canName, int canNum, int canPrice) {
		super();
		this.canName = canName;		//음류수 이름
		this.canNum = canNum;		//재고
		this.canPrice = canPrice;	//가격
	}

	public String toString() {
		return "음료이름 : " + canName + ", 음료갯수 : " + canNum + " 음료가격 : " + canPrice + "]";
	}

	public String getCanName() {
		return canName;
	}
	
	//setCanName 함수로 음료수의 이름 변경
	public void setCanName(String canName) {
		this.canName = canName;
	}

	public int getCanNum() {
		return canNum;
	}
	
	//setCanNum 함수로 재고 변경
	public void setCanNum(int canNum) {
		this.canNum = canNum;
	}

	public int getCanPrice() {
		return canPrice;
	}

	//setCanPrice 함수로 음류수 가격 변갱
	public void setCanPrice(int canPrice) {
		this.canPrice = canPrice;
	}
}
