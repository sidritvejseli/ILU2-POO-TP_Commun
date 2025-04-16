package model;

public class ReservationRestaurant extends Reservation {
	private int numTable;
	private int service;
	public ReservationRestaurant(int jour, int mois,int service ,int numTable) {
		super(jour, mois);
		this.numTable = numTable;
		this.service = service;
	}
	
	@Override
	public String toString() {
		String retour =  "Le %d/%d : table n°%d pour le %s service";
		String service_string = "premier";
		if(service ==2) {
			service_string = "deuxieme";
		}
		return String.format(retour,getJour(), getMois(), numTable,service_string);
	}
}
