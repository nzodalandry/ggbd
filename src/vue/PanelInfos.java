package vue;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import modele.Application;
import modele.ReseauRoutier;
import vue.PanelControls.jcbFlag;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelInfos extends JPanel{

	private JLabel lblInfos;
	private DefaultListModel dlmInfos; 
	private JList jlInfos;
	private JScrollPane jspInfos;
	private int num;
	
	private JLabel lblFeuilleRoute;
	private DefaultListModel dlmFeuilleRoute; 
	private JList jlFeuilleRoute;
	private JScrollPane jspFeuilleRoute;
	
	private Border jspBorder, outsideBorder, insideBorder;
	
	private final int INFOS_HAUTEUR = 175;
	
	// Donnees des infos
	private String message1, message2, su, longueur_trajet;
	private int x, y;
	private int depart = -1, arrivee = -1;
	float zoom = Application.ZOOM_INITIAL;
	private JTabbedPane tabbedPane;
	private JLabel lblAjouter;
	private JLabel lblNewLabel_1;
	private JLabel lblModeEdition;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblDddd;
	private JLabel lblSens;
	private JLabel lblChoixDeLa;
	private JTextField txtNomRue;
	private JButton btnNewPoint;
	private JLabel lblSaisirLesInformations;
	private JLabel lblAbsice;
	private JLabel lblOrdonney;
	private JLabel lblChoixDeLa_1;
	private JTextField txtPointX;
	private JComboBox cbPointRue;
	private JTextField txtPointY;
	private JLabel label;
	private JComboBox cbSuppRue;
	private JButton btnSuppRue;
	private JLabel lblNewLabel_2;
	private JLabel lblPoint;
	private JLabel lblAttentionCe;
	private JComboBox cbSuppPoint;
	private JLabel lblChoixDuPoint;
	private JButton btnSuppPoint;
	private JComboBox cbVille;
	private Application app;
	private ReseauRoutier r=new ReseauRoutier();
	
	public PanelInfos(int l, int h, String su) {
		super();
		this.su = su;
		
		// Creation du Layout (de type BoxLayout)
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		// Ajout du label informations
		lblInfos = new JLabel("Informations sur les points");
		lblInfos.setForeground(new Color(0, 139, 139));
		lblInfos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInfos.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		lblInfos.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblInfos);
		
		// Creation de la bordure des listes
		outsideBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		// A ameliorer
		insideBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		jspBorder = BorderFactory.createCompoundBorder(outsideBorder, insideBorder);
		
		// Ajout de la liste scrollable d'informations
		dlmInfos = new DefaultListModel();
		jlInfos = new JList(dlmInfos);
		jlInfos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlInfos.setLayoutOrientation(JList.VERTICAL);
		jlInfos.setVisibleRowCount(-1);
		jspInfos = new JScrollPane(jlInfos);
		jspInfos.setPreferredSize(new Dimension((int)l, INFOS_HAUTEUR));
		jspInfos.setMinimumSize(new Dimension((int)l, INFOS_HAUTEUR));
		jspInfos.setBorder(jspBorder);
		add(jspInfos);
		setMessage("Bienvenue !", "Choisissez un itin\u00e9raire.");
		
		// Ajout du label Feuille de route
		lblFeuilleRoute = new JLabel("Informations sur l'itineraire trouve");
		lblFeuilleRoute.setForeground(new Color(0, 139, 139));
		lblFeuilleRoute.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFeuilleRoute.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblFeuilleRoute);
		
		// Ajout de la liste scrollable feuille de route
		dlmFeuilleRoute = new DefaultListModel();
		jlFeuilleRoute = new JList(dlmFeuilleRoute);
		jlFeuilleRoute.setLayoutOrientation(JList.VERTICAL);
		jlFeuilleRoute.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlFeuilleRoute.setVisibleRowCount(-1);
		jlFeuilleRoute.setCellRenderer(new AfficheurElementListe());
		jspFeuilleRoute = new JScrollPane(jlFeuilleRoute);
		jspFeuilleRoute.setPreferredSize(new Dimension(50, 150));
		jspFeuilleRoute.setBorder(jspBorder);
		add(jspFeuilleRoute);
		
		lblModeEdition = new JLabel("Mode edition");
		lblModeEdition.setAlignmentX(0.5f);
		lblModeEdition.setForeground(new Color(0, 139, 139));
		lblModeEdition.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblModeEdition);
		
		lblDddd = new JLabel(".");
		add(lblDddd);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("NOUVELLE RUE", null, panel, null);
		tabbedPane.setBackgroundAt(0, Color.LIGHT_GRAY);
		tabbedPane.setForegroundAt(0, new Color(255, 99, 71));
		
		lblAjouter = new JLabel("Saisir les informations de la nouvelle Rue");
		lblAjouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouter.setBackground(Color.LIGHT_GRAY);
		lblAjouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		
		lblSens = new JLabel("Sens");
		lblSens.setForeground(Color.DARK_GRAY);
		lblSens.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		lblChoixDeLa = new JLabel("Choix de la ville");
		lblChoixDeLa.setForeground(Color.DARK_GRAY);
		lblChoixDeLa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		txtNomRue = new JTextField();
		txtNomRue.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setSelectedIndex(1);
		
		cbVille = new JComboBox();
		JButton btnNewRue = new JButton("ENREGISTRER");
		btnNewRue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNomRue.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Veuillez saisir un nom de rue SVP !","Erreur",JOptionPane.ERROR_MESSAGE) ;	
				else {
					cbPointRue.addItem(txtNomRue.getText());
					cbSuppRue.addItem(txtNomRue.getText());
					JOptionPane.showMessageDialog(null, "Rue enregistree avec succes","validation d'enregistrement",JOptionPane.INFORMATION_MESSAGE) ;
				}
			}
		});
		btnNewRue.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewRue.setForeground(Color.BLUE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAjouter)
					.addContainerGap(158, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(1)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblChoixDeLa, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
							.addComponent(lblSens, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomRue, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(cbVille, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
					.addGap(114))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(90)
					.addComponent(btnNewRue, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(238, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblAjouter)
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNomRue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(16)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSens, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChoixDeLa, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbVille, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(btnNewRue)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("NOUVEAU POINT", null, panel_2, null);
		
		btnNewPoint = new JButton("ENREGISTRER");
		num=(int)r.listePoints.get(0)+1;
		btnNewPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPointX.getText().isEmpty() || txtPointY.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs SVP !","Erreur",JOptionPane.ERROR_MESSAGE) ;	
				else {
					cbSuppPoint.addItem(num);
					cbSuppPoint.setSelectedItem(cbSuppPoint.getItemAt(cbSuppPoint.getItemCount()-1));
					JOptionPane.showMessageDialog(null, "Point enregistre avec succes","validation d'enregistrement",JOptionPane.INFORMATION_MESSAGE) ;
					num++;
				}
			}
		});
		btnNewPoint.setForeground(Color.BLUE);
		btnNewPoint.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblSaisirLesInformations = new JLabel("Saisir les informations du nouveau point");
		lblSaisirLesInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaisirLesInformations.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaisirLesInformations.setBackground(Color.LIGHT_GRAY);
		
		lblAbsice = new JLabel("Abscisse (X)");
		lblAbsice.setForeground(Color.DARK_GRAY);
		lblAbsice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		lblOrdonney = new JLabel("Ordonne (Y)");
		lblOrdonney.setForeground(Color.DARK_GRAY);
		lblOrdonney.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		lblChoixDeLa_1 = new JLabel("Choix de la Rue");
		lblChoixDeLa_1.setForeground(Color.DARK_GRAY);
		lblChoixDeLa_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		txtPointX = new JTextField();
		txtPointX.setColumns(10);
		
		cbPointRue = new JComboBox();
		
		txtPointY = new JTextField();
		txtPointY.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lblChoixDeLa_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addGap(1)
									.addComponent(cbPointRue, 0, 168, Short.MAX_VALUE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblAbsice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblOrdonney, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtPointY, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
										.addComponent(txtPointX, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(90)
							.addComponent(btnNewPoint))
						.addComponent(lblSaisirLesInformations, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(30)
					.addComponent(lblSaisirLesInformations, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbsice, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrdonney, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(19)
							.addComponent(lblChoixDeLa_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(17)
							.addComponent(cbPointRue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addComponent(btnNewPoint)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		tabbedPane.setBackgroundAt(1, Color.LIGHT_GRAY);
		tabbedPane.setForegroundAt(1, new Color(255, 99, 71));
		
		panel_1 = new JPanel();
		tabbedPane.addTab("SUPPRESSION", null, panel_1, null);
		tabbedPane.setBackgroundAt(2, Color.LIGHT_GRAY);
		tabbedPane.setForegroundAt(2, new Color(255, 99, 71));
		
		lblNewLabel_1 = new JLabel("RUE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		
		label = new JLabel("Choix de la Rue");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		cbSuppRue = new JComboBox();
		
		btnSuppRue = new JButton("VALIDER");
		btnSuppRue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Etes vous sure de vouloir supprimer cette rue ?","Confirmation de suppression", JOptionPane.YES_NO_CANCEL_OPTION);
				if(n==0) {
					cbSuppRue.removeItem(cbSuppRue.getSelectedItem());
					cbPointRue.removeItemAt(cbPointRue.getSelectedIndex());
					JOptionPane.showMessageDialog(null,"Rue supprimee avec succes","Message suppression",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSuppRue.setForeground(Color.BLUE);
		btnSuppRue.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblNewLabel_2 = new JLabel("Attention cette Rue sera supprimee definitivement.");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		lblPoint = new JLabel("POINT");
		lblPoint.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPoint.setBackground(Color.LIGHT_GRAY);
		
		lblAttentionCe = new JLabel("Attention ce point sera supprime definitivement.");
		lblAttentionCe.setForeground(Color.RED);
		lblAttentionCe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		cbSuppPoint = new JComboBox();
		
		lblChoixDuPoint = new JLabel("Numero du point");
		lblChoixDuPoint.setForeground(Color.DARK_GRAY);
		lblChoixDuPoint.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		
		btnSuppPoint = new JButton("VALIDER");
		btnSuppPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Etes vous sur de vouloir supprimer ce point ","Confirmation de suppression",JOptionPane.YES_NO_OPTION) ;	
				int n = JOptionPane.showConfirmDialog(null, "Etes vous sure de vouloir supprimer ce point ?","Confirmation de suppression", JOptionPane.YES_NO_CANCEL_OPTION);
				if(n==0) {
					cbSuppPoint.removeItem(cbSuppPoint.getSelectedItem());
					JOptionPane.showMessageDialog(null,"Point supprime avec succes","Message suppression",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSuppPoint.setForeground(Color.BLUE);
		btnSuppPoint.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(19)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(cbSuppRue, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(90)
							.addComponent(btnSuppRue, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(90)
							.addComponent(btnSuppPoint, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(lblChoixDuPoint, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(cbSuppPoint, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPoint, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAttentionCe, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel_1)
					.addGap(1)
					.addComponent(lblNewLabel_2)
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbSuppRue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(btnSuppRue)
					.addGap(30)
					.addComponent(lblPoint)
					.addGap(1)
					.addComponent(lblAttentionCe, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(22)
							.addComponent(lblChoixDuPoint, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(20)
							.addComponent(cbSuppPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(20)
					.addComponent(btnSuppPoint)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
	
	public void ajouterRoute(String route, String chemin_image) {
		dlmFeuilleRoute.addElement(new ElementListe(route, chemin_image));
	}
	
	public void ajouterRoute(String route) {
		dlmFeuilleRoute.addElement(new ElementListe(route));
	}
	
	public void reinitialiserInfos() {
		dlmInfos.removeAllElements();
	}
	
	public void reinitialiserRoutes() {
		dlmFeuilleRoute.removeAllElements();
	}
	
	public void setMessage(String mess1, String mess2) {
		message1 = mess1;
		message2 = mess2;
		refaireInfos();
	}
	
	public void setLongueurTrajet(String longueur) {
		longueur_trajet = longueur;
		refaireInfos();
	}
	
	public void updateCoord(int x, int y) {
		this.x = x;
		this.y = y;
		refaireInfos();
	}
	
	public void updateZoom(float zoom) {
		this.zoom = zoom;
		refaireInfos();
	}
	
	public void updateDepart(int d) {
		depart = d;
		refaireInfos();
	}	
	
	public void updateArrivee(int a) {
		arrivee = a;
		refaireInfos();
	}
	
	private void refaireInfos() {
		dlmInfos.removeAllElements();
		if(message1 != null)
			dlmInfos.addElement(message1);
		if(message2 != null)
			dlmInfos.addElement(message2);
		dlmInfos.addElement(new String("Systeme d'unit\u00e9s : " + su));
		dlmInfos.addElement(new String("Longueur du trajet : " + ((longueur_trajet == null) ? "-" : longueur_trajet)));
		dlmInfos.addElement(new String("D\u00e9part : " + ((depart == -1) ? "-" : new Integer(depart).toString())));
		dlmInfos.addElement(new String("Arriv\u00e9e : " + ((arrivee == -1) ? "-" : new Integer(arrivee).toString())));
		dlmInfos.addElement(new String("Coordonn\u00e9e X : " + x));
		dlmInfos.addElement(new String("Coordonn\u00e9e Y : " + y));
		dlmInfos.addElement(new String("Zoom : " + (int)(zoom * 100) + " %"));
	}
	public void chargerPoint(ArrayList liste)
	{
		JComboBox cmb = new JComboBox();
		cmb=cbSuppPoint;
		cmb.removeAllItems();
		if (liste.size() > 0) {
			for (int i=0; i<liste.size();i++) {
				cmb.addItem(liste.get(i));
			}
		}
	}
	public void ajouterVille(String ville){
		cbVille.addItem(ville);
	}
	public void ajouterRue(ArrayList list) {
		if (list.size() > 0) {
			for (int i=0; i<list.size();i++) {
				cbPointRue.addItem(list.get(i));
				cbSuppRue.addItem(list.get(i));
			}
		}
	}
}

class ElementListe {
	  private final String texte;
	  private final String chemin_image;
	  private ImageIcon image;
	  
	  public ElementListe(String texte) {
		  this.texte = texte;
		  this.chemin_image = "";
	  }

	  public ElementListe(String texte, String chemin_image) {
		  this.texte = texte;
		  this.chemin_image = chemin_image;
	  }

	  public String getTitle() {
		  return texte;
	  }
	  
	  public String getCheminImage() {
		  return chemin_image;
	  }

	  public ImageIcon getImage() {
		  if (image == null) {
			  image = new ImageIcon(chemin_image);
		  }
		  return image;
	  }
	  
	  // Override standard toString method to give a useful result
	  public String toString() {
		  return texte;
	  }
	  
}

@SuppressWarnings("serial")
class AfficheurElementListe extends JLabel implements ListCellRenderer {
	
	private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
	public AfficheurElementListe() {
		setOpaque(true);
	    setIconTextGap(5);
	}
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	    ElementListe element = (ElementListe) value;
		setText(element.getTitle());
		if (element.getCheminImage() != "") {
			setIcon(element.getImage());
		}
		else {
			setIcon(new ImageIcon());
		}
	    if (isSelected) {
	      setBackground(HIGHLIGHT_COLOR);
	      setForeground(Color.white);
	    }
	    else {
	      setBackground(Color.white);
	      setForeground(Color.black);
	    }
		return this;
	}
	
}