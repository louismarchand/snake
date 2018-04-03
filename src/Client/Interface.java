package Client;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Interface extends JFrame {


	private BorderLayout layout;


	private Interface()	 {
		layout = new BorderLayout();
        initUI();
    }
	private void initUI(){
		setLayout(layout);
		setTitle("ShnakeRPG");
	    // Taille de la frame
	    setSize(800, 600);
	    // Placer au centre de l'ecran
	    setLocationRelativeTo(null);
	    // Resizable ou non
	    setResizable(true);
        // Action a la fermeture (croix)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        setVisible(true);
	}

	
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface();
            }
        });
    }

}
