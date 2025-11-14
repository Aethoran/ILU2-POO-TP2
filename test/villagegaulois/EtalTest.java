package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;

class EtalTest {
	
	private Village village;
	private Chef abraracourcix;
	private Gaulois obelix;
	private Druide panoramix;
	private Gaulois asterix;
	private Etal etal;
	private Etal etal2;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		panoramix = new Druide("Panoramix", 10, 2, 5);
		village.installerVendeur(panoramix, "potion", 10);
		etal = village.rechercherEtal(panoramix);
	}
	
	@Test
	void testIsEtalOccupe() {
		assertTrue(etal.isEtalOccupe());
		village.partirVendeur(panoramix);
		assertFalse(etal.isEtalOccupe());
	}

	@Test
	void testGetVendeur() {
		assertEquals(etal.getVendeur(), panoramix);
	}

	@Test
	void testGetQuantite() {
		assertEquals(etal.getQuantite(), 10);
	}

	@Test
	void testGetProduit() {
		assertEquals(etal.getProduit(), "potion");
	}

	@Test
	void testOccuperEtal() {
		asterix = new Gaulois("Astérix", 10);
		village.ajouterHabitant(asterix);
		etal2 = new Etal();
		etal2.occuperEtal(asterix, "beigne", 5);
		assertEquals(etal2.getVendeur(), asterix);
		assertEquals(etal2.getProduit(), "beigne");
		assertTrue(etal2.isEtalOccupe());
		
	}

	@Test
	void testContientProduit() {
		assertTrue(etal.contientProduit("potion"));
		assertFalse(etal.contientProduit("banane flambée"));
	}

	@Test
	void testAcheterProduit() {
		etal2 = new Etal();
		assertEquals(etal2.acheterProduit(10), 0);
		assertEquals(etal.acheterProduit(0), 0);
		assertEquals(etal.acheterProduit(2), 2);
		assertEquals(etal.getQuantite(), 8);
		assertEquals(etal.acheterProduit(10), 8);
	}

	@Test
	void testLibererEtal() {
		assertTrue(etal.isEtalOccupe());
		etal.libererEtal();
		assertFalse(etal.isEtalOccupe());
	}

	@Test
	void testEtatEtal() {
		String[] liste = new String[5];
		liste[0] = "true";
		liste[1] = "Panoramix";
		liste[2] = "potion";
		liste[3] = "10";
		liste[4] = "0";
		assertArrayEquals(etal.etatEtal(), liste);
		etal2 = new Etal();
		String[] liste2 = new String[5];
		liste2[0] = "false";
		assertArrayEquals(etal2.etatEtal(), liste2);
	}

}
