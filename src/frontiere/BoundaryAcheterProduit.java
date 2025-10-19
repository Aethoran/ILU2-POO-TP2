package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println(
					"Je suis désolé " + nomAcheteur + 
					" mais il fait être un habitant de notre village pour commercer ici."
			);
		} else {
			String produitCherche = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");
			
		}
		
		
	}
}
