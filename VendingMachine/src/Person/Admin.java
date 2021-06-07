package Person;

public class Admin {
	
	//기본 매출액
	public static int totalMoney = 100000;
	
	public Admin(){}

	public static int getTotalMoney() {
		return totalMoney;
	}

	public static void setTotalMoney(int totalMoney) {
		Admin.totalMoney = totalMoney;
	}
	
}
