package Client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerLink {

	static ServerLink instance;
	
	private Socket socket;
	private PrintWriter streamOut;
	private BufferedReader streamIn;
	
	private ServerLink() {
		try {
			this.socket = new Socket("127.0.0.1", 2020);
			this.streamOut = new PrintWriter(socket.getOutputStream());
	        this.streamIn = new BufferedReader( new InputStreamReader( this.socket.getInputStream() ) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String connect( String username, String mdp ) throws IOException {
		
		String message = "{'header':{'username':'"+username+"', 'ipPlayer':'IPPLAYER', 'typeEvent':'authentication'}, 'data':{'connect':'true', 'mdp':'"+mdp+"'}}";
        streamOut.println(message);
        streamOut.flush();

	    String line = "";
	    String codeReturn = "";
        while (line.equals("")) {
	        line = this.streamIn.readLine();
	        codeReturn += line;
	        System.out.println(line);
        }
        
        return codeReturn;
	}
	
	
	static ServerLink getInstance() {
		if ( instance == null ) {
			instance = new ServerLink();
		}
		return instance;
	}
}
