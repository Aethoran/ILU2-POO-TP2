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
			String vendeurCherche[] = controlAcheterProduit.rechercherVendeursProduit(produitCherche);
			if(vendeurCherche == null) {
				System.out.println("Desole, personne ne vend ce produit au marche.");
			} else {
				System.out.println("Chez quel commercant voulez-vous acheter des " + produitCherche);
				for(int i = 0; i < vendeurCherche.length; i++) {
					System.out.println(i + " - " + vendeurCherche[i]);
				}
			}
		}
		
		
	}
}
