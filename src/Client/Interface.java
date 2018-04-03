package Client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Interface extends JFrame {


	private BorderLayout layout;
	
	// LOGIN
	private JLabel l_login;
	private JLabel l_mdp;
	private JTextField tf_login;
	private JTextField tf_mdp;
	private JButton b_connexion;


	private Interface()	 {
		layout = new BorderLayout();
		b_connexion = new JButton("Connexion");
		l_login = new JLabel("Login:");
		l_mdp = new JLabel("Password:");
		tf_login = new JTextField();
		tf_mdp = new JTextField();
        initUI();
    }
	
	private void initUI() {
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
        
        initElement();
        
        setVisible(true);
	}

	
    private void initElement() {
    	JPanel pan_login = new JPanel();
    	pan_login.setLayout( new BoxLayout(pan_login, BoxLayout.Y_AXIS));
    	
    	b_connexion.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ServerLink sl = ServerLink.getInstance();
				try {
					
					String codeReturn = sl.connect( tf_login.getText(), tf_mdp.getText());
					
					tf_login.setText(codeReturn);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
    	
    	pan_login.add(l_login);
    	pan_login.add(tf_login);
    	pan_login.add(l_mdp);
    	pan_login.add(tf_mdp);
    	pan_login.add(b_connexion);

    	this.getContentPane().add(pan_login, BorderLayout.CENTER);
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
