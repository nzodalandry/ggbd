package vue;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame{

	//couleur du trac� ( commun a Carte et Contr�le )
	public final static Color DefaultItineraireColor = Color.RED;
	private final int CONTROLES_HAUTEUR = 150;
	public final int INFOS_LARGEUR = 350;
	
	// Dimensions de l'�cran
	private Dimension dimEcran;
    
    // Dimensions utilisables du bureau
    private int largeurUtil;
    private int hauteurUtil;
	
	// Pannels
	private PanelVisuel pnlVue;
	private PanelControls pnlCtrl;
	private PanelInfos pnlInfo;
	
	// Bordure des Panels
	Border raisedbevel = BorderFactory.createRaisedBevelBorder();
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	Border coumpoundBorder = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
	
	public FenetrePrincipale(String lienCarte, String su) {	
		super("Trouver un itin\u00E9raire");
		setFont(new Font("Dialog", Font.BOLD, 13));
		setForeground(Color.PINK);
		setTitle("Trouver un itin\u00E9raire");
		
		// Recuperer l'apparence par defaut du systeme
		String nativeLF = UIManager.getSystemLookAndFeelClassName();
    
		// Installation de l'apparence
		try {
			UIManager.setLookAndFeel(nativeLF);
		} 
		catch (InstantiationException e) {}
		catch (ClassNotFoundException e) {}
		catch (UnsupportedLookAndFeelException e) {}
		catch (IllegalAccessException e) {}
		
		// Recuperation de la taille de l'ecran
        Toolkit tk = Toolkit.getDefaultToolkit();
        dimEcran = tk.getScreenSize();
        
        // Recuperation des rebords
        Insets insets = tk.getScreenInsets(getGraphicsConfiguration()); 
        
        // Calcul de la taille utilisable sur le bureau
        largeurUtil = (int)(dimEcran.getWidth()-insets.left-insets.right); 
        hauteurUtil = (int)(dimEcran.getHeight()-insets.top-insets.bottom); 
        setPreferredSize(new Dimension(largeurUtil,hauteurUtil));
        
        int h,l;
        
		// Cr�ation du PanelControles
        h = CONTROLES_HAUTEUR;
        l = INFOS_LARGEUR;
		pnlCtrl = new PanelControls();
		pnlCtrl.setPreferredSize(new Dimension(270, 150));
		getContentPane().add(pnlCtrl ,BorderLayout.WEST);
		
		// Cr�ation de la carte
		Carte carte = new Carte(lienCarte, 40);
		
		// Cr�ation du PanelVue avec la carte
		h = hauteurUtil;
		l = largeurUtil - (2*INFOS_LARGEUR);
		pnlVue = new PanelVisuel(carte);
		pnlVue.setPreferredSize(new Dimension(l, h));
		pnlVue.setBorder(coumpoundBorder);
		getContentPane().add(pnlVue, BorderLayout.CENTER);
		
		// Cr�ation du PanelInformations
		l = INFOS_LARGEUR;
		h = hauteurUtil;
		pnlInfo = new PanelInfos(l, h, su);
		pnlInfo.setPreferredSize(new Dimension(300, 0));
		getContentPane().add(pnlInfo ,BorderLayout.EAST);
		
		// Mise � la taille du bureau pour le mode fen�tre normal
		pack();
		setLocation(insets.left, insets.top);
		
		// Mise en mode fenetre aggrandie
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Op�ration de fermeture
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public PanelControls getPanneauControles() {
		return pnlCtrl;
	}

	public PanelInfos getPanneauInfos() {
		return pnlInfo;
	}

	public PanelVisuel getPanneauVue() {
		return pnlVue;
	}
}
