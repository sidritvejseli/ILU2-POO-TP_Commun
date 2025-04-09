package model;

import java.util.Arrays;

public class CalendrierAnnuel {
	private Mois[] Calendrier;
	public CalendrierAnnuel() {
		this.Calendrier = new Mois[12];
		
		Calendrier[0] =new Mois("Janvier", 31);
		Calendrier[1] =new Mois("Fevrier", 28);
		Calendrier[2] =new Mois("Mars", 31);
		Calendrier[3] =new Mois("Avril", 30);
		Calendrier[4] =new Mois("Mai", 31);
		Calendrier[5] =new Mois("Juin", 30);
		Calendrier[6] =new Mois("Juillet", 31);
		Calendrier[7] =new Mois("Aout", 31);
		Calendrier[8] =new Mois("Septembte", 30);
		Calendrier[9] =new Mois("Octobre", 31);
		Calendrier[10] =new Mois("Novembre", 30);
		Calendrier[11] =new Mois("Decembre", 31);
		
		
	}
	
	private static class Mois{
		private String nom;
		private boolean[] jours;
		
		public Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
			Arrays.fill(jours, false);
		}
		
		private boolean estLibre(int jour) {
			return !jours[jour-1];
		}
		
		private void reserver(int jour) {
			
			if (jour > jours.length && !estLibre(jour)) {
				throw new IllegalStateException(); 
			}
			jours[jour-1] = true; 
		}
	}
	
	public boolean estLibre(int jour, int mois) {
		return Calendrier[mois-1].estLibre(jour);
	}
	
	public boolean reserver(int jour, int mois) {
		if(!estLibre(jour, mois)) {
			return false;
		}
		Calendrier[mois-1].reserver(jour);
		return true;
	}
	
}
