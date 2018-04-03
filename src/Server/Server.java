package Server;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends ServerSocket {

	protected ServerTreatment message_interpreter;

	public Server(int port) throws IOException {
		super(port);
		System.out.println("Serveur lancé");
		
		Socket socket = null;
		BufferedReader in = null;
		DataOutputStream out = null;
		
		// On attend qu'un client veuille nous contacter
		while (true) {
			
			// Accepte un client
			socket = this.accept();
			
			// On lance le thread d'écoute
			ClientReader cr = new ClientReader(socket);
			cr.start();
		}
	}

	public static void main(String args[]) {
		
//		if ( args.length < 1 ) {
//			System.err.println("USAGE: donner un port");
//		}
//
//		int port = Integer.parseInt(args[0]);
		int port = 2020;
		
		try {
			Server server = new Server(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
