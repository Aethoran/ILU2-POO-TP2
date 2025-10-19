package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		if (village.trouverHabitant(nomVendeur) != null) {
			return village.rechercherEtal(village.trouverHabitant(nomVendeur));
		} else {
			return null;
		}
	}
	
	public String[] donneesEtal(String nomVendeur) {
		Etal etal = trouverEtalVendeur(nomVendeur);
		String[] donneesEtal = new String[5];
		donneesEtal = etal.etatEtal();
		etal.libererEtal();
		return donneesEtal;
	}
	
}
