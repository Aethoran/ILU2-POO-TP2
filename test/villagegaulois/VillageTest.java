package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;

class VillageTest {
	
	private Village village;
	private Chef abraracourcix;
	private Gaulois obelix;
	private Druide panoramix;
	private Gaulois asterix;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testVillage() {
		assertNotNull(village, "Constructeur ne renvoie pas null");
	}

	@Test
	void testGetNom() {
		assertEquals(village.getNom(), "le village des irréductibles");
	}

	@Test
	void testSetChef() {
		String[] liste = new String[1];
		liste[0] = "Abraracourcix";
		assertArrayEquals(village.donnerVillageois(), liste);
	}

	@Test
	void testAjouterHabitant() {
		obelix = new Gaulois("Obélix", 10);
		panoramix = new Druide("Panoramix", 10, 2, 5);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(panoramix);
		String[] liste = new String[3];
		liste[0] = "Abraracourcix";
		liste[1] = "Obélix";
		liste[2] = "le druide Panoramix";
		assertArrayEquals(village.donnerVillageois(), liste);
	}

	@Test
	void testTrouverHabitant() {
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		assertEquals(village.trouverHabitant("Abraracourcix"), abraracourcix);
		assertEquals(village.trouverHabitant("Obélix"), obelix);
		assertNull(village.trouverHabitant("Philippe du meme"));
	}

	@Test
	void testDonnerVillageois() {
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		String[] liste = new String[2];
		liste[0] = "Abraracourcix";
		liste[1] = "Obélix";
		assertArrayEquals(village.donnerVillageois(), liste);
	}

	@Test
	void testDonnerNbEtal() {
		assertEquals(village.donnerNbEtal(), 2);
		obelix = new Gaulois("Obélix", 10);;
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "menhir", 2);
		assertEquals(village.donnerNbEtal(), 2);
	}

	@Test
	void testInstallerVendeur() {
		obelix = new Gaulois("Obélix", 10);
		panoramix = new Druide("Panoramix", 10, 2, 5);
		asterix = new Gaulois("Astérix", 10);
		village.ajouterHabitant(panoramix);
		village.ajouterHabitant(obelix);
		assertEquals(village.installerVendeur(obelix, "menhir", 5), 0);
		assertEquals(village.installerVendeur(panoramix, "potion", 5), 1);
		assertEquals(village.installerVendeur(asterix, "beigne", 5), -1);
	}

	@Test
	void testPartirVendeur() {
		obelix = new Gaulois("Obélix", 10);;
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "menhir", 1);
		panoramix = new Druide("Panoramix", 10, 2, 5);
		village.ajouterHabitant(panoramix);
		assertEquals(village.installerVendeur(panoramix, "potion", 5), 1);
		assertFalse(village.rechercherEtalVide());
		village.partirVendeur(obelix);
		assertTrue(village.rechercherEtalVide());
	}

	@Test
	void testRechercherEtalVide() {
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "menhir", 5);
		assertTrue(village.rechercherEtalVide());
		panoramix = new Druide("Panoramix", 10, 2, 5);
		village.ajouterHabitant(panoramix);
		village.installerVendeur(panoramix, "potion", 5);
		assertFalse(village.rechercherEtalVide());

	}

	@Test
	void testRechercherVendeursProduit() {
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "menhir", 5);
		Gaulois[] pasVide = new Gaulois[1];
		pasVide[0] = obelix;
		String[] vide = new String [0];
		assertArrayEquals(village.rechercherVendeursProduit("menhir"), pasVide);
		assertArrayEquals(village.rechercherVendeursProduit("chips paprika"), null);
	}

	@Test
	void testRechercherEtal() {
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "menhir", 5);
		assertEquals(village.rechercherEtal(obelix).getVendeur(), obelix);
	}

	@Test
	void testDonnerEtatMarche() {
		obelix = new Gaulois("Obélix", 10);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "menhir", 5);
		String[] liste = new String[3];
		liste[0] = "Obélix";
		liste[1] = "5";
		liste[2] = "menhir";
		assertArrayEquals(village.donnerEtatMarche(), liste);
	}

}
