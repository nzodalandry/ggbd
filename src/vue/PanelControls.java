package vue;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import modele.Application;

@SuppressWarnings("serial")
public class PanelControls extends JPanel {
	
	private final int HAUTEUR = 150;
	
	private JLabel jlDepart;
	private JLabel jlArrivee;
	
	private JLabel jlVille;
	private JLabel jlRue;
	private JLabel jlPoint;
	private JLabel jlVille2;
	private JLabel jlRue2;
	private JLabel jlPoint2;
	
	private JComboBox jcbVilleDepart;
	private JComboBox jcbVilleArrivee;
	//constantes de selection de comboBox
	public enum jcbFlag {DEPART, ARRIVEE, BOTH};
	
	private JComboBox jcbRueDepart;
	private JComboBox jcbRueArrivee;
	
	private JComboBox jcbPointDepart;
	private JComboBox jcbPointArrivee;
	
	private JButton jbOk;
	
	private JLabel jlZoom;
	
	private JSlider jsZoom;
	private JButton jbZoomPlus;
	private JButton jbZoomMoins;
	private JButton jbZoomGlobal;
	private JButton jbZoomGrosPlan;
	private JButton jbZoomReel;
	
	private JPanel jpConteneurEst;
	private JPanel jpConteneurOuest;
	
	private GridBagConstraints contraintes;

	@SuppressWarnings("deprecation")
	public PanelControls() {
		super();
		
		
		
		//Creation du Panel Ouest
		jpConteneurOuest = new JPanel(new GridBagLayout());
		jpConteneurOuest.setMaximumSize(new Dimension(700, HAUTEUR));
		
		// Creation des contraintes communes
		contraintes = new GridBagConstraints();
		contraintes.insets = new Insets(0, -20, 5, 0);
		contraintes.anchor = GridBagConstraints.LINE_START;
		contraintes.weightx = 0.0;
		
		// Ajout du label Depart
				jlDepart = new JLabel("D\u00e9part");
				//jlDepart.setFont(jlDepart.getFont().deriveFont(Font.BOLD));
				jlDepart.setFont(new Font("Serif", Font.BOLD, 20));
				//jlDepart.setPreferredSize(new Dimension(150,20));
				contraintes.gridx = 0;
				contraintes.gridy = 0;
				//contraintes.gridwidth=100;
				jpConteneurOuest.add(jlDepart, contraintes);
				contraintes.anchor = GridBagConstraints.CENTER;
		contraintes.insets = new Insets(15, -40, 5, 5);
		// Ajout du label Ville
		jlVille = new JLabel("Ville ");
		jlVille.setFont(jlVille.getFont().deriveFont(Font.ITALIC));
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		jpConteneurOuest.add(jlVille, contraintes);
		
		// Ajout du label Rue
		jlRue = new JLabel("Rue ");
		jlRue.setFont(jlVille.getFont().deriveFont(Font.ITALIC));
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		jpConteneurOuest.add(jlRue, contraintes);
		
		// Ajout du label Points
		jlPoint = new JLabel("Point ");
		jlPoint.setFont(jlPoint.getFont().deriveFont(Font.ITALIC));
		contraintes.gridx = 0;
		contraintes.gridy = 3;
		jpConteneurOuest.add(jlPoint, contraintes);
		
		// Contrainte pour les autres composants
		
		
		
		// Ajout de la ComboBox de la ville départ
		jcbVilleDepart = new JComboBox();
		jcbVilleDepart.setName("jcbVilleDepart");
		jcbVilleDepart.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		jpConteneurOuest.add(jcbVilleDepart, contraintes);
		
		// Ajout de la ComboBox de la rue de départ
		jcbRueDepart = new JComboBox();
		jcbRueDepart.setName("jcbRueDepart");
		jcbRueDepart.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 1;
		contraintes.gridy = 2;
		jpConteneurOuest.add(jcbRueDepart, contraintes);
		
		// Ajout de la ComboBox du point de départ
		jcbPointDepart = new JComboBox();
		jcbPointDepart.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 1;
		contraintes.gridy = 3;
		jpConteneurOuest.add(jcbPointDepart, contraintes);
		contraintes.insets = new Insets(15, 0, 5,5);
		// Ajout du label Arrivee
		contraintes.insets = new Insets(25, -20, 5, 0);
		jlArrivee = new JLabel("Destination");
		//jlArrivee.setFont(jlArrivee.getFont().deriveFont(Font.BOLD));
		jlArrivee.setFont(new Font("Serif", Font.BOLD, 20));
		contraintes.gridx = 0;
		contraintes.gridy = 4;		
		jpConteneurOuest.add(jlArrivee, contraintes);
		contraintes.insets = new Insets(15,-40, 5, 5);
		//222
		// Ajout du label Ville
		jlVille2 = new JLabel("Ville ");
		jlVille2.setFont(jlVille.getFont().deriveFont(Font.ITALIC));
		contraintes.gridx = 0;
		contraintes.gridy = 5;
		jpConteneurOuest.add(jlVille2, contraintes);
			
		// Ajout du label Rue
		jlRue2 = new JLabel("Rue ");
		jlRue2.setFont(jlVille2.getFont().deriveFont(Font.ITALIC));
		contraintes.gridx = 0;
		contraintes.gridy = 6;
		jpConteneurOuest.add(jlRue2, contraintes);
				
		// Ajout du label Points
		jlPoint2 = new JLabel("Point ");
		jlPoint2.setFont(jlPoint2.getFont().deriveFont(Font.ITALIC));
		contraintes.gridx = 0;
		contraintes.gridy = 7;
		jpConteneurOuest.add(jlPoint2, contraintes);
						
		// Ajout de la ComboBox de la ville d'arrivée
		jcbVilleArrivee = new JComboBox();
		jcbVilleArrivee.setName("jcbVilleArrivee");
		jcbVilleArrivee.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 1;
		contraintes.gridy = 5;
		jpConteneurOuest.add(jcbVilleArrivee, contraintes);
		
		// Ajout de la ComboBox de la rue d'arrivée
		jcbRueArrivee = new JComboBox();
		jcbRueArrivee.setName("jcbRueArrivee");
		jcbRueArrivee.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 1;
		contraintes.gridy = 6;
		jpConteneurOuest.add(jcbRueArrivee, contraintes);
		
		// Ajout de la ComboBox du point de départ
		jcbPointArrivee = new JComboBox();
		jcbPointArrivee.setPreferredSize(new Dimension(175,20));
		contraintes.gridx = 1;
		contraintes.gridy = 7;
		jpConteneurOuest.add(jcbPointArrivee, contraintes);
		
		GridBagConstraints contraint =new GridBagConstraints();
		contraint.insets = new Insets(35, -78, 0, 0);
		// Bouton pour valider la requete
		jbOk = new JButton("Itinéraire");
		jbOk.setFont(new Font(jbOk.getFont().getFontName(), Font.BOLD, 15));
		jbOk.setForeground(Color.BLUE);
		jbOk.setName("jbOk");
		contraint.gridx = 1;
		contraint.gridy = 8;
		contraint.gridheight = 2;
		contraint.gridwidth = GridBagConstraints.RELATIVE;
		contraint.fill = GridBagConstraints.VERTICAL;
		contraint.anchor = GridBagConstraints.CENTER;
		jpConteneurOuest.add(jbOk, contraint);
		
		
		
		
		// Creation du Panel Est
		jpConteneurEst = new JPanel(new GridBagLayout());
		jpConteneurEst.setMaximumSize(new Dimension(200, HAUTEUR));
	
		// Contraintes communes
		contraintes.fill = GridBagConstraints.NONE;
		contraintes.insets = new Insets(5, 8, 5, 5);
		//contraintes.anchor = GridBagConstraints.LINE_START;
		contraintes.weightx = 1;
		
		// Label des zooms
		jlZoom = new JLabel("Zoom");
		//jlZoom.setFont(jlZoom.getFont().deriveFont(Font.BOLD));
		jlZoom.setFont(new Font("Serif", Font.BOLD, 20));
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 3;
		contraintes.anchor = GridBagConstraints.CENTER;
		jpConteneurEst.add(jlZoom, contraintes);
		
		contraintes.gridwidth = 1;
		contraintes.insets = new Insets(5, 5, 5, 5);
		// Boutton pour Zoomer
		jbZoomPlus = new JButton("+");
		jbZoomPlus.setName("jbZoomPlus");
		jbZoomPlus.setFont(new Font("Serif", Font.BOLD, 30));
		jbZoomPlus.setPreferredSize(new Dimension(50, 50));
		jbZoomPlus.setForeground(Color.BLUE);
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		contraintes.anchor = GridBagConstraints.LINE_START;
		jpConteneurEst.add(jbZoomPlus, contraintes);
		
		
		//Slider de zoom
		
		jsZoom = new JSlider();
		jsZoom.setMinimum((int) (Application.ZOOM_MIN*100));
		jsZoom.setMaximum((int) (Application.ZOOM_MAX*100));
		jsZoom.setValue((int) (Application.ZOOM_INITIAL*100));
		jsZoom.setMajorTickSpacing(10);
		jsZoom.setPaintTicks(true);
		jsZoom.setPaintLabels(true);
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		jsZoom.setVisible(false);
		jpConteneurEst.add(jsZoom,contraintes);
		 
		contraintes.insets = new Insets(5, 50, 5, 5);
		// Boutton pour Dezoomer
		jbZoomMoins = new JButton("-");
		jbZoomMoins.setName("jbZoomMoins");
		jbZoomMoins.setFont(new Font("Serif", Font.BOLD, 30));
		jbZoomMoins.setPreferredSize(new Dimension(50, 50));
		jbZoomMoins.setForeground(Color.BLUE);
		contraintes.gridx = 1;
		contraintes.gridy = 2;
		contraintes.anchor = GridBagConstraints.LINE_START;
		jpConteneurEst.add(jbZoomMoins, contraintes);
		contraintes.insets = new Insets(5, 5, 5, 5);
		//Boutton pour avoir une vue d'ensemble (où on ne vois rien d'ailleurs)
		jbZoomGlobal = new JButton("Vue Globale");
		jbZoomGlobal.setName("jbZoomGlobal");
		jbZoomGlobal.setPreferredSize(new Dimension(100, 20));
		jbZoomGlobal.setForeground(Color.BLUE);
		contraintes.gridx = 0;
		contraintes.gridy = 4;
		contraintes.anchor = GridBagConstraints.LINE_START;
		jpConteneurEst.add(jbZoomGlobal, contraintes);
		
		// Boutton pour remettre le Zoom a la normale
		jbZoomReel = new JButton("Taille Réelle");
		jbZoomReel.setName("jbZoomReel");
		jbZoomReel.setPreferredSize(new Dimension(100, 20));
		jbZoomReel.setForeground(Color.BLUE);
		contraintes.gridx = 1;
		contraintes.gridy = 4;
		contraintes.anchor = GridBagConstraints.LINE_START;
		jpConteneurEst.add(jbZoomReel, contraintes);
		
		
		//Boutton pour mettre la vue en gros plan
		jbZoomGrosPlan = new JButton("Gros plan");
		jbZoomGrosPlan.setName("jbZoomGrosPlan");
		jbZoomGrosPlan.setPreferredSize(new Dimension(100, 20));
		jbZoomGrosPlan.setForeground(Color.BLUE);
		contraintes.gridx = 0;
		contraintes.gridy = 5;
		contraintes.anchor = GridBagConstraints.CENTER;
		jbZoomGrosPlan.setVisible(false);
		jpConteneurEst.add(jbZoomGrosPlan, contraintes);
		
		
		// Creation du Layout general(de type BoxLayout)	
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(Box.createVerticalGlue());
		add(jpConteneurOuest);
		add(Box.createVerticalGlue());
		add(jpConteneurEst);
		add(Box.createVerticalGlue());
	}
	
	public void ajouterRouteDansCombobox(String route, jcbFlag flag) {
		switch(flag){
		case DEPART:
			jcbRueDepart.addItem(route);
			break;
		
		case ARRIVEE:
			jcbRueArrivee.addItem(route);
			break;
			
		case BOTH:
			jcbRueDepart.addItem(route);
			jcbRueArrivee.addItem(route);
			break;
		}	
	}
	
	public void ajouterVilleDansCombobox(String ville){
		jcbVilleDepart.addItem(ville);
		jcbVilleArrivee.addItem(ville);
	}
	
	public String getNomVille(jcbFlag flag) {
		String ret = "";
		switch (flag) {
			case DEPART: ret = (String)jcbVilleDepart.getSelectedItem(); break;
			case ARRIVEE: ret = (String)jcbVilleArrivee.getSelectedItem(); break;
		}
		return ret;
	}
	
	public String getNomRoute(jcbFlag flag) {
		String ret = "";
		switch (flag) {
			case DEPART: ret = (String)jcbRueDepart.getSelectedItem(); break;
			case ARRIVEE: ret = (String)jcbRueArrivee.getSelectedItem(); break;
		}
		return ret;
	}
	
	public int getNumPoint(jcbFlag flag) {
		int ret = -1;
		switch (flag) {
			case DEPART: ret = (Integer)jcbPointDepart.getSelectedItem(); break;
			case ARRIVEE: ret = (Integer)jcbPointArrivee.getSelectedItem(); break;
		}
		return ret;
	}
	
	public void setPoints(jcbFlag flag, Vector<Integer> liste) {
		JComboBox cmb = new JComboBox();
		switch (flag) {
			case DEPART: cmb = jcbPointDepart; break;
			case ARRIVEE: cmb = jcbPointArrivee; break;
		}
		cmb.removeAllItems();
		if (liste.size() > 0) {
			for (Iterator it = liste.iterator(); it.hasNext();) {
				cmb.addItem(it.next());
			}
		}
	}
	
	public void changerTexteBoutonOk(String texte) {
		jbOk.setText(texte);
	}

	public void ajouterEcouteurAuBoutonOk(ActionListener ecouteur) {
		jbOk.addActionListener(ecouteur);
	}
	
	public void ajouterEcouteurAuBoutonZoomMoins(ActionListener ecouteur) {
		jbZoomMoins.addActionListener(ecouteur);
	}
	
	public void ajouterEcouteurAuBoutonZoomPlus(ActionListener ecouteur) {
		jbZoomPlus.addActionListener(ecouteur);
	}

	public void ajouterEcouteurAuBoutonZoomReel(ActionListener ecouteur) {
		jbZoomReel.addActionListener(ecouteur);
	}

	public void ajouterEcouteurAuBoutonZoomGlobal(ActionListener ecouteur) {
		jbZoomGlobal.addActionListener(ecouteur);	
	}
	
	public void ajouterEcouteurAuBoutonZoomGrosPlan(ActionListener ecouteur) {
		jbZoomGrosPlan.addActionListener(ecouteur);	
	}
	
	public void ajouterEcouteurAuSlider(ChangeListener ecouteur) {
		jsZoom.addChangeListener(ecouteur);
	}
	
	public void ajouterEcouteurVilleDepart(ActionListener ecouteur) {
		jcbVilleDepart.addActionListener(ecouteur);
	}
	
	public void ajouterEcouteurRueDepart(ActionListener ecouteur) {
		jcbRueDepart.addActionListener(ecouteur);
	}
	
	public void ajouterEcouteurVilleArrivee(ActionListener ecouteur) {
		jcbVilleArrivee.addActionListener(ecouteur);
	}
	
	public void ajouterEcouteurRueArrivee(ActionListener ecouteur) {
		jcbRueArrivee.addActionListener(ecouteur);
	}
	
	public boolean villeDejaPresente(String ville) {
		for(int i=0;i<jcbVilleDepart.getItemCount();i++){
			if(jcbVilleDepart.getItemAt(i).toString().equals(ville)) {
				return true;
			}
		}
		return false;
	}

	public void viderRueComboBox(jcbFlag flag) {
		switch(flag){
		case ARRIVEE:
			jcbRueArrivee.removeAllItems();
			break;
		
		case DEPART:
			jcbRueDepart.removeAllItems();
			break;
			
		case BOTH:
			jcbRueDepart.removeAllItems();
			jcbRueArrivee.removeAllItems();
			break;
		}	
	}
	
	public void setSliderValue(int val){
		jsZoom.setValue(val);
	}
	
	public void setIconZoomMoins(ImageIcon icon) {
		jbZoomMoins.setIcon(icon);
	}
	
	public void setIconZoomPlus(ImageIcon icon) {
		jbZoomPlus.setIcon(icon);
	}
}
