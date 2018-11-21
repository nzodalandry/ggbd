package modele;

// Classe stockant un element d'un plus court chemin
public class ReseauStatut
{
	// Numero de la Node (numéro du point du reseau routier)
	public int n;
	// Autres donnees
	public int g;

	// Constructeur
	public ReseauStatut(int nde, int goal)
	{
		n = nde;
		g = goal;
	}
}
