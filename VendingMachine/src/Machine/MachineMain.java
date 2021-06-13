package Machine;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

//머신 메인 함수
//서버
public class MachineMain extends Application {
	static ExecutorService	executorService; 	//스레드 풀
	static ServerSocket serverSocket;
	static List<Client> connections = new Vector<Client>();
	

	public static void main(String[] args) {
		
		executorService = Executors.newFixedThreadPool(10);	//스레드 풀의 수
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost",5001));
		}catch (Exception e) {
			//서버가 닫혀지지 않았다면
			if(!serverSocket.isClosed()) {
				stopServer();
			}
			return;
		}
		
		//연결 수락 객체
		Runnable runnalbe = new Runnable() {
			@Override
			public void run() {
				Platform.runLater(()->{
					System.out.println("[서버 시작]");
				});
				
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						System.out.println("연결 수락 : "+socket.getRemoteSocketAddress()+" : "+Thread.currentThread().getName());
						
						Client client = new Client(socket);
						connections.add(client);
						new MachineFrame("**1234567");

					}
					catch (IOException e) {
						if(!serverSocket.isClosed())
							stopServer();
						break;
					}
				}
			}
		};
		
		executorService.submit(runnalbe);
	}
	
	private static void stopServer() {
		try {
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			if(serverSocket!=null && !serverSocket.isClosed())
				serverSocket.close();
			if(executorService!=null && !executorService.isShutdown())
				executorService.shutdown();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}

	class Client{
		Socket socket;

		Client(Socket socket){
			this.socket = socket;
		}
	}
	

