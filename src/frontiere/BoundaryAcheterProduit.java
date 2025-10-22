package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	
	private boolean verifierIdentite(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println(
					"Je suis dÃ©solÃ© " + nomAcheteur + 
					" mais il fait Ãªtre un habitant de notre village pour commercer ici."
			);
		}
		return (controlAcheterProduit.verifierIdentite(nomAcheteur));
	}
	
	private void effectuerAchat(String nomAcheteur, String nomVendeur, int nombreAchat, String produitAchete) {
		int quantiteAchete = controlAcheterProduit.acheterProduit(nomVendeur, nombreAchat);
		if (quantiteAchete == 0) {
			System.out.println(	nomAcheteur + " veut acheter 5"
								+ produitAchete + ", malheureusement il n’y en a plus !");
		}
		if (quantiteAchete < nombreAchat) {
			System.out.println(	nomAcheteur + " veut acheter " + nombreAchat + " " + produitAchete +
								"malheureusement " + nomVendeur + "n’en a plus que "
								+ quantiteAchete + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
		}
		if (quantiteAchete == nombreAchat) {
			System.out.println(nomAcheteur + " achète " + quantiteAchete + " " + produitAchete +  " à " + nomVendeur + ".");
		}
	}
	
	private int demanderVendeur(String[] vendeurCherche, String produitCherche) {
		StringBuilder question = new StringBuilder();
		question.append("Chez quel commercant voulez-vous acheter des " + produitCherche + "\n");
		for(int i = 0; i < vendeurCherche.length; i++) {
			question.append(i+1 + " - " + vendeurCherche[i] + "\n");
		}
		int choixUtilisateur = 0;
		do {
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			if (choixUtilisateur < 0 || choixUtilisateur > vendeurCherche.length) {
				System.out.println("Veuillez choisir un nombre valide.");
			}
		} while (choixUtilisateur < 0 || choixUtilisateur > vendeurCherche.length);
		return choixUtilisateur;
	}
	
	public void acheterProduit(String nomAcheteur) {
		if (verifierIdentite(nomAcheteur)){
			String produitCherche = Clavier.entrerChaine("Quel produit voulez-vous acheter ?\n");
			String[] vendeurCherche = controlAcheterProduit.rechercherVendeursProduit(produitCherche);
			if(vendeurCherche.length == 0) {
				System.out.println("Desole, personne ne vend ce produit au marche.");
			} else {
				int choixUtilisateur = demanderVendeur(vendeurCherche, produitCherche) - 1;
				System.out.println(nomAcheteur + " se deplace jusqu'a l'etal de " + vendeurCherche[choixUtilisateur]);
				int nombreAchat = 	Clavier.entrerEntier(
									"Combien de " + produitCherche
									+ " souhaitez vous acheter ?");
				effectuerAchat(nomAcheteur, vendeurCherche[choixUtilisateur], nombreAchat, produitCherche);
			}
		}
		
		
	}
}
