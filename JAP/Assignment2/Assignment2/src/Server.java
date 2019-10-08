import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server{

	
	public static void main(String[] args) {
		int port = 8088;
		while(true){
			try {
				ServerSocket s = new ServerSocket(port);
				System.out.println("Using default port: "+s.getLocalPort());
				while(true){
					Socket incoming = s.accept();
					System.out.println("Connecting to a client"+incoming);
					Runnable sr = new ServerSocketRunnable(incoming);
					Thread t = new Thread(sr);
		            t.start();
		            
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	

}
