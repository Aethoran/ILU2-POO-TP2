package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private Village village;
	private Chef abraracourcix;
	private ControlLibererEtal controlLibererEtal;
	private Gaulois asterix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;


	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		asterix = new Gaulois("Astérix", 10);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "baffe", 500);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}
	
	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}

	
	@Test
	void testLibererEtal() {
		String[] liste = new String[5];
		liste[0] = "true";
		liste[1] = "Astérix";
		liste[2] = "baffe";
		liste[3] = "500";
		liste[4] = "0";
		assertNull(controlLibererEtal.libererEtal("obelix"), "null si pas un vendeur");
		assertArrayEquals(controlLibererEtal.libererEtal("Astérix"), liste, "liberation etal d'un vendeur");
	}

	@Test
	void testIsVendeur() {
		assertTrue(controlLibererEtal.isVendeur("Astérix"));
		assertFalse(controlLibererEtal.isVendeur("Obélix"));
	}

}
