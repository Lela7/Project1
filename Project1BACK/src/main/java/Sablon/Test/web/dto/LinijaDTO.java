package Sablon.Test.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;



//• Id - identifikator
//• Broj mesta – celobrojna vrednost (obavezna)
//• Cena karte – numerička vrednost
//• Vreme polaska – tekstualna vrednost
//• Destinacija – tekstualna vrednost (obavezna)
//• Prevoznik - veza sa instancom klase prevoznik (jedna linija može pripadati samo
//• jednom prevozniku, a jedan prevoznik može imati više linija). Veza je dvosmerna

//1.3 Na nivou API-ja validirati sledeće stavke:
//• Broj mesta nije negativna vrednost
//• Destinacija je neprazan, ne null tekst

public class LinijaDTO {
	@Positive(message= "Id mora biti pozitivan broj.")
	private Long id;
	
	@NotNull(message= "Broj mesta nije zadat.")
	@Positive(message="Broj mesta mora biti pozitivan broj.")
	private int brojMesta;
	
	private double cenaKarte;
	
	
	private String vremePolaska;
	
	@NotBlank(message="Destinacija nije zadata.")
	private String destinacija;
	
	@NotNull(message="Prevoznik za koji je vezana linija nije zadat.")
	//private PrevoznikDTO prevoznik;
	
	//a moze i:
	private Long prevoznikId;
	private String prevoznikNaziv;
	
	

	public LinijaDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}

	public double getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	public String getVremePolaska() {
		return vremePolaska;
	}

	public void setVremePolaska(String vremePolaska) {
		this.vremePolaska = vremePolaska;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}
	
	
	public Long getPrevoznikId() {
		return prevoznikId;
	}

	public void setPrevoznikId(Long prevoznikId) {
		this.prevoznikId = prevoznikId;
	}

	public String getPrevoznikNaziv() {
		return prevoznikNaziv;
	}

	public void setPrevoznikNaziv(String prevoznikNaziv) {
		this.prevoznikNaziv = prevoznikNaziv;
	}

//	public PrevoznikDTO getPrevoznik() {
//		return prevoznik;
//	}
//
//	public void setPrevoznik(PrevoznikDTO prevoznik) {
//		this.prevoznik = prevoznik;
//	}

	
	
	
	
	

}
