package Can;

//����� Ŭ����
public class Can {
	String canName;
	int canNum;
	int canPrice;
	
	//������� ������ �ʱ�ȭ
	public Can(String canName, int canNum, int canPrice) {
		super();
		this.canName = canName;		//������ �̸�
		this.canNum = canNum;		//���
		this.canPrice = canPrice;	//����
	}

	public String toString() {
		return "�����̸� : " + canName + ", ���᰹�� : " + canNum + " ���ᰡ�� : " + canPrice + "]";
	}

	public String getCanName() {
		return canName;
	}
	
	//setCanName �Լ��� ������� �̸� ����
	public void setCanName(String canName) {
		this.canName = canName;
	}

	public int getCanNum() {
		return canNum;
	}
	
	//setCanNum �Լ��� ��� ����
	public void setCanNum(int canNum) {
		this.canNum = canNum;
	}

	public int getCanPrice() {
		return canPrice;
	}

	//setCanPrice �Լ��� ������ ���� ����
	public void setCanPrice(int canPrice) {
		this.canPrice = canPrice;
	}
}
