package Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client2 {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("���� ��û");
			socket.connect(new InetSocketAddress("localhost",5001));	//�ּ�, ��Ʈ
			System.out.println("���� ����");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
