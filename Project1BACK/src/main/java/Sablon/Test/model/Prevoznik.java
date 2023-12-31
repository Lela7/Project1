package Sablon.Test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//• Id - identifikator
//• Naziv - tekstualna vrednost (jedinstvena, obavezna)
//• Adresa – tekstualna vrednost
//• PIB – tekstualna vrednost (jedinstvena, obavezna)

@Entity
public class Prevoznik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false, unique= true )
	private String naziv;
	
	@Column
	private String adresa;
	
	@Column(nullable= false, unique= true)
	private String PIB;
	
	@OneToMany (mappedBy = "prevoznik", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Linija> linije= new ArrayList<>();

	public Prevoznik(String naziv, String adresa, String pIB) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		PIB = pIB;
	}
	
	public Prevoznik() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getPIB() {
		return PIB;
	}

	public void setPIB(String pIB) {
		PIB = pIB;
	}

	public List<Linija> getLinije() {
		return linije;
	}

	public void setLinije(List<Linija> linije) {
		this.linije = linije;
	}
	
	//dodatak:
	public void dodajLiniju(Linija linija) {
		this.linije.add(linija);
		if(!equals(linija.getPrevoznik())) {
			linija.setPrevoznik(this);
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
		Prevoznik other = (Prevoznik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prevoznik [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", PIB=" + PIB + "]";
	}
	
	
	
	
	
	
	

}
