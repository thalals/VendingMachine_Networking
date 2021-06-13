package Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client3 {
	Socket socket;
	
	Client3(Socket socket){
		this.socket = socket;
		run();
	}
	
	void run(){
		try {
			socket = new Socket();
			System.out.println("연결 요청");
			socket.connect(new InetSocketAddress("localhost",5001));	//주소, 포트
			System.out.println("연결 성공");
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
