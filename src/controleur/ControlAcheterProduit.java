package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public String[] rechercherVendeursProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if (vendeurs == null) {
			return (new String[0]);
		}
		String[] nomsVendeurs = new String[vendeurs.length];
		for (int i = 0; i < vendeurs.length; i++) {
			nomsVendeurs[i] = vendeurs[i].getNom();
		}
		return nomsVendeurs;
	}
	
	public int acheterProduit(String nomVendeur, int nbAchat) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(nbAchat);
	}
	
}
