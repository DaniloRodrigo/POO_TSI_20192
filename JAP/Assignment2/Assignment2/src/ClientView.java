import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class ClientView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String applicationTitle = "Danilo's Client";
	public static int HEIGHT = 500;
	public static int WIDTH = 600;
	private static String TAG = "CLIENT>"; 
	
	private JLabel lbHost;
	private JLabel lbPort;
	private JTextField txtHost;
	private JTextField txtMessage;
	private JComboBox<String> cbPort;
	private JButton btnConnect;
	private JButton btnSend;	
	private JTextArea terminal;
	private JScrollPane scroll;
	private Boolean flag = true;
	
	

	{
		lbHost = new JLabel("Host:");
		lbHost.setDisplayedMnemonic(KeyEvent.VK_H);
		lbHost.setPreferredSize(new Dimension(40, 40));
		
		lbPort = new JLabel("Port:");
		lbPort.setDisplayedMnemonic(KeyEvent.VK_P);
		lbPort.setPreferredSize(new Dimension(40, 40));
		
		
		txtMessage = new JTextField("Type a server request line");
		txtMessage.setColumns(46);
		txtMessage.setBackground(Color.WHITE);
		txtHost = new JTextField(" localhost");
		txtHost.setPreferredSize(new Dimension(80,20));
		//txtHost.setColumns(45);
		txtHost.setBackground(Color.WHITE);
		lbHost.setLabelFor(txtHost);
		
		
		
		cbPort = new JComboBox<String>();
		cbPort.addItem("");
		cbPort.addItem("8088");
		cbPort.addItem("65000");
		cbPort.addItem("65535");
		cbPort.setSize(60, cbPort.getHeight());
		cbPort.setBackground(Color.WHITE);
		cbPort.setEditable(true);
		lbPort.setLabelFor(cbPort);
		
		btnConnect = new JButton("Connect");
		btnConnect.setActionCommand("connect");
		btnConnect.setPreferredSize(cbPort.getPreferredSize());
		btnConnect.setBackground(Color.RED);
		btnSend = new JButton("Send");
		btnSend.setActionCommand("send");
		btnSend.setEnabled(false);
		btnSend.setMnemonic(KeyEvent.VK_S);
		
	}
	public ClientView() {
		super(new BorderLayout());
		txtHost.requestFocus();
		
		JPanel paneConnection = new JPanel(new BorderLayout());
		JPanel paneTerminal = new JPanel(new BorderLayout());
		
		JPanel paneTop = new JPanel(new BorderLayout());
		JPanel paneMiddle = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		JPanel paneConnectionTop = new JPanel();
		paneConnectionTop.setLayout(new BoxLayout(paneConnectionTop, BoxLayout.X_AXIS));
		//Box paneConnectionTop = Box.createHorizontalBox();
		JPanel paneConnectionBottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
		
		terminal = new JTextArea();
		terminal.setEditable(false);
		
		scroll = new JScrollPane(terminal);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		TitledBorder borderConnection = new TitledBorder("CONECTION");
		borderConnection.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
		TitledBorder borderTerminal = new TitledBorder("TERMINAL");
		borderTerminal.setBorder(BorderFactory.createLineBorder(Color.BLUE, 10));
		
		paneConnection.setBorder(borderConnection);
		paneTerminal.setBorder(borderTerminal);
		
		
		paneConnectionTop.add(Box.createHorizontalStrut(4));
		paneConnectionTop.add(lbHost);
		paneConnectionTop.add(Box.createHorizontalStrut(9));
		paneConnectionTop.add(txtHost);
//		paneConnectionTop.add(Box.createHorizontalGlue());
		
		paneConnectionBottom.add(lbPort);
		paneConnectionBottom.add(cbPort);
		paneConnectionBottom.add(btnConnect);
		
		paneMiddle.add(txtMessage);
		paneMiddle.add(btnSend);
		
		paneConnection.add(paneConnectionTop, BorderLayout.NORTH);
		paneConnection.add(paneConnectionBottom, BorderLayout.SOUTH);
		
		paneTerminal.add(terminal, BorderLayout.CENTER);
		
		paneTop.add(paneConnection, BorderLayout.NORTH);
		paneTop.add(paneMiddle, BorderLayout.SOUTH);
		
		this.add(paneTop,BorderLayout.NORTH);
		this.add(paneTerminal,BorderLayout.CENTER);
		
		Controller c = new Controller();
		btnConnect.addActionListener(c);
		btnSend.addActionListener(c);
		
	}
	
	private void setConnected(SocketChannel s){
		if(s.isConnected()){
			btnSend.setEnabled(true);
			btnConnect.setEnabled(false);
			btnConnect.setBackground(Color.BLUE);
			terminal.append("Connected to "+s.socket()+"\n");
		}else{
			btnSend.setEnabled(false);
			btnConnect.setEnabled(true);
			btnConnect.setBackground(Color.RED);
		}
	}
	
	private class Controller implements ActionListener{
		private InputStream inStream;
		private OutputStream outStream;
		private SocketChannel channel;
		private Scanner in;
		private PrintWriter out;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			switch (e.getActionCommand()) {
			case "connect":
				createConnection();
				break;

			case "send":
				sendMessage();
				break;
			}
			
		}
		private void createConnection(){
			if(cbPort.getSelectedItem().toString().equals("")){
				JOptionPane.showMessageDialog(getParent(), "Select a Port before connect!");
			}else{
				try {
					channel = SocketChannel.open(new InetSocketAddress(txtHost.getText().trim(), Integer.parseInt(cbPort.getSelectedItem().toString())));
					//terminal.append(channel.getClass().getName());
					if(channel.isOpen()){
						setConnected(channel);
						inStream = channel.socket().getInputStream();
						outStream = channel.socket().getOutputStream();
						out = new PrintWriter(outStream, true /* autoFlush */);
						in = new Scanner(inStream);	
						
					}
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					terminal.append(TAG + "ERROR:" + "Connection refused: server is not available. Check port or restar server." + "\n");
				} catch (UnresolvedAddressException e) {
					terminal.append(TAG + "ERROR:" + "Unknown Host." + "\n");
				}
			}
			
		}
		
		private void sendMessage(){
			
			try{
				out.println(txtMessage.getText().toString());
				
				if(in.hasNext()){
					String line = in.nextLine();
					switch (line) {
					case "CLS":
						terminal.setText("");
						flag = false;
						break;
					case "END":
						terminal.append(TAG + "Connection closed" + "\n");
						try {
							channel.close();
							setConnected(channel);
							terminal.append("SERVER>Connection closed." + "\n");
							flag = false;
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					default:
						if(flag){
							terminal.append(line + "\n");
						}else{
							flag = true;
						}
						break;
					}
				}
			}finally{
				
			}
			
		}
	}
}

















