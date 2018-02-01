package Server;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends ServerSocket {

	protected ServerTreatment message_interpreter;

	public Server(int port) throws IOException {
		super(port);
		this.message_interpreter = new ServerTreatment();
		System.out.println("Serveur lancé");
		
		Socket socket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		
		// On attend qu'un client veuille nous contacter
		while (true) {
			
			// Accepte un client
			socket = this.accept();
			
			// Récupère le message
			in = new DataInputStream(new BufferedInputStream( socket.getInputStream() ));
			String message = in.readUTF();
			System.out.println("#RECEIVED: "+message);
			
			// Traitement
			String treated_message = message_interpreter.treat(message);
			System.out.println(treated_message);
			
			// Répond au client
			out = new DataOutputStream( socket.getOutputStream() );
			out.writeUTF(treated_message);
			out.flush();
			
			// Ferme connection
			socket.close();
			in.close();
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
