package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import modele.Application;
import vue.PanelControls;

public class ControlleurAllComboBox implements ActionListener {
	private Application app;
	
	public ControlleurAllComboBox(Application app) {
		this.app = app;
	}
	
	public void actionPerformed(ActionEvent evt) {
		JComboBox box_clique = (JComboBox) evt.getSource();
		String nom_box = box_clique.getName();
		if (nom_box.equals("jcbVilleDepart")) {
			app.selectionnerFiltre(PanelControls.jcbFlag.DEPART);
		}
		else if (nom_box.equals("jcbVilleArrivee")) {
			app.selectionnerFiltre(PanelControls.jcbFlag.ARRIVEE);
		}
		else if (nom_box.equals("jcbRueDepart")) {
			app.remplirListePoints(PanelControls.jcbFlag.DEPART);
		}
		else if (nom_box.equals("jcbRueArrivee") ) {
			app.remplirListePoints(PanelControls.jcbFlag.ARRIVEE);
		}
	}
}