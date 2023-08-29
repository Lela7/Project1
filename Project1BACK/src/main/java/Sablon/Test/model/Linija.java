package Sablon.Test.model;
//• Id - identifikator
//• Broj mesta – celobrojna vrednost (obavezna)
//• Cena karte – numerička vrednost
//• Vreme polaska – tekstualna vrednost
//• Destinacija – tekstualna vrednost (obavezna)
//• Prevoznik - veza sa instancom klase prevoznik (jedna linija može pripadati samo
//• jednom prevozniku, a jedan prevoznik može imati više linija). Veza je dvosmerna

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Linija {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable=false)
	private int brojMesta;
	
	@Column
	private double cenaKarte;
	
	//@Column(nullable=false)
	private String vremePolaska;
	
	@Column(nullable=false)
	private String destinacija;
	
	@ManyToOne
	private Prevoznik prevoznik;

	//konstruktor bez id:
	public Linija(int brojMesta, double cenaKarte, String vremePolaska, String destinacija, Prevoznik prevoznik) {
		super();
		this.brojMesta = brojMesta;
		this.cenaKarte = cenaKarte;
		this.vremePolaska = vremePolaska;
		this.destinacija = destinacija;
		this.prevoznik = prevoznik;
	}

public Linija() {
	super();
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

public Prevoznik getPrevoznik() {
	return prevoznik;
}
//izmena setera:
public void setPrevoznik(Prevoznik prevoznik) {
	this.prevoznik = prevoznik;
	if(prevoznik != null && !prevoznik.getLinije().contains(this)) {
		prevoznik.getLinije().add(this);
	}
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Linija other = (Linija) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

@Override
public String toString() {
	//izmena repvoznika u String-u:
	String nazivPrevoznika = prevoznik ==null ? " - " : prevoznik.getNaziv();
	return "Linija [id=" + id + ", brojMesta=" + brojMesta + ", cenaKarte=" + cenaKarte + ", vremePolaska="
			+ vremePolaska + ", destinacija=" + destinacija + ", prevoznik=" + nazivPrevoznika + "]";
}




	
	

}
