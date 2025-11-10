package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private Chef abraracourcix;
	private Gaulois patafix;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		patafix = new Gaulois("Patafix", 20);
		village.ajouterHabitant(patafix);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		assertEquals(controlPrendreEtal.resteEtals(), true, "Trouve qu'il reste un etal");
		village.installerVendeur(patafix, "colle", 10);
		assertEquals(controlPrendreEtal.resteEtals(), false, "Trouve qu'il ne reste plus d'etal");
	}

	@Test
	void testPrendreEtal() {
		assertEquals(controlPrendreEtal.prendreEtal("Patafix", "colle", 10), 0, "Renvoie l'etal d'un vendeur");
		assertEquals(controlPrendreEtal.prendreEtal("Patafix", "patate", 10), -1, "Renvoie -1 si non trouve");
	}

	@Test
	void testVerifierIdentite() {
		village.installerVendeur(patafix, "colle", 10);
		assertEquals(controlPrendreEtal.verifierIdentite("Patafix"), true, "Check id vendeur");
		assertEquals(controlPrendreEtal.verifierIdentite("Brutus"), false, "Check id intrus");
	}

}
