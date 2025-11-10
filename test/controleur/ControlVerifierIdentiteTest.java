package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private Chef abraracourcix;
	private Gaulois patafix;
	private ControlVerifierIdentite controlVerifierId;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		patafix = new Gaulois("Patafix", 20);
		village.ajouterHabitant(patafix);
		village.setChef(abraracourcix);
		controlVerifierId = new ControlVerifierIdentite(village);
	}
	
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierId, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		assertEquals(controlVerifierId.verifierIdentite("Patafix"), true, "Verifier ID de gaulois dans village");
		assertEquals(controlVerifierId.verifierIdentite("Jaimefairedestrix"), false, "Verifier ID de gaulois non existant");
	}

}
