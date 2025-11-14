package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	
	private Village village;
	private Chef abraracourcix;
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Gaulois obelix;

	@BeforeEach
	public void initialiserSituation() {
		
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "menhir", 10);
	}
	
	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlAcheterProduit.verifierIdentite("Obélix"));
		assertFalse(controlAcheterProduit.verifierIdentite("Marcus"));
	}

	@Test
	void testRechercherVendeursProduit() {
		String[] pasVide = new String[1];
		pasVide[0] = "Obélix";
		String[] vide = new String [0];
		assertArrayEquals(controlAcheterProduit.rechercherVendeursProduit("menhir"), pasVide);
		assertArrayEquals(controlAcheterProduit.rechercherVendeursProduit("chips paprika"), vide);
	}

	@Test
	void testAcheterProduit() {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Obélix");
		assertEquals(controlAcheterProduit.acheterProduit("Obélix", 5), etal.acheterProduit(5));
	}

}
