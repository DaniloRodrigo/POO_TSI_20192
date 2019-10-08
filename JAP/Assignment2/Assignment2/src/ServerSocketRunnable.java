import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class ServerSocketRunnable implements Runnable{
	private Socket s;
	private Scanner in;
	private static String TAG = "SERVER>";
	
	public ServerSocketRunnable(Socket s) {
		// TODO Auto-generated constructor stub
		this.s = s;
	}

	@Override
	public void run() {
		
		try {
			
			InputStream inStream = s.getInputStream();
			in = new Scanner(inStream);
			OutputStream outStream = s.getOutputStream();
			PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
			String line = in.nextLine();
			String command = line.substring(0, line.indexOf(">"));
			String argument = line.substring(line.indexOf(">")+1);
			Boolean flag = true;
			while(flag){

					GregorianCalendar calendar = new GregorianCalendar();
					switch (command) {
					case "ECHO":
						out.println(TAG + "ECHO: "+argument);
						break;

					case "TIME":
						SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss a");
						time.setCalendar(calendar);
						String timeFormatted = time.format(calendar.getTime());
						out.println(TAG + "TIME:" +timeFormatted);
						break;
					case "DATE":					
						SimpleDateFormat date = new SimpleDateFormat("dd MMMM yyyy");
						date.setCalendar(calendar);
						String dateFormatted = date.format(calendar.getTime());
						out.println(TAG + "DATE:" +dateFormatted);
						break;
					case "?":
						out.println( TAG +"AVAILABLE SERVICES: -END -ECHO -TIME -DATE -? -CLS ");
						break;
					case "CLS":
						out.println("CLS");
						break;
					case "END":
						out.println("END");
						flag = false;
						break;
					default:
						out.println(TAG + "Unrecognized command.");
						break;
					}

					line = in.nextLine();
					command = line.substring(0, line.indexOf(">"));
					argument = line.substring(line.indexOf(">")+1);
					Thread.sleep(500);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} finally{
			try {
				s.close();
				System.out.println("Server Socket: Closing client connection ...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		
		
	}

}
