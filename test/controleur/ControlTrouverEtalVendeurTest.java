package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	private Village village;
	private Chef abraracourcix;
	private Gaulois patafix;
	private Gaulois riqiqix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		patafix = new Gaulois("Patafix", 20);
		village.ajouterHabitant(patafix);
		riqiqix = new Gaulois("Riqiqix", 20);
		village.ajouterHabitant(riqiqix);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		village.installerVendeur(patafix, "colle", 10);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Patafix"), "Trouve etal avec un vendeur");
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Donnetonnumdetelfix"), "Trouve null avec un intrus");
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Riqiqix"), "Trouve null avec un gaulois non vendeur");
	}

}
