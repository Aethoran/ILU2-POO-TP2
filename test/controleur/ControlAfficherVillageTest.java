package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import villagegaulois.Village;
import personnages.Gaulois;

class ControlAfficherVillageTest {
	
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;
	private Gaulois asterix;
	private Gaulois obelix;
	private Druide panoramix;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
		asterix = new Gaulois("Astérix", 10);
		obelix = new Gaulois("Obélix", 30);
		panoramix = new Druide("Panoramix", 5, 2, 10);
	}
	
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		String[] listeNom = new String[1];
		listeNom[0] = "Abraracourcix";
		assertArrayEquals(controlAfficherVillage.donnerNomsVillageois(), listeNom, "village vide renvoie le chef");
		
		String[] listeNom2 = new String[3];
		listeNom2[0] = "Abraracourcix";
		listeNom2[1] = "Astérix";
		listeNom2[2] = "Obélix";
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		assertArrayEquals(controlAfficherVillage.donnerNomsVillageois(), listeNom2, "village avec gaulois");
		
		String[] listeNom3 = new String[4];
		listeNom3[0] = "Abraracourcix";
		listeNom3[1] = "Astérix";
		listeNom3[2] = "Obélix";
		listeNom3[3] = "le druide Panoramix";
		village.ajouterHabitant(panoramix);
		assertArrayEquals(controlAfficherVillage.donnerNomsVillageois(), listeNom3, "village avec druide");
		
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles", "renvoie nom de village");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5, "renvoie nbEtal");
	}

}
