package Sablon.Test.web.dto;
//• Id - identifikator
//• Naziv - tekstualna vrednost (jedinstvena, obavezna)
//• Adresa – tekstualna vrednost
//• PIB – tekstualna vrednost (jedinstvena, obavezna)

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import Sablon.Test.model.Linija;

public class PrevoznikDTO {
	@Positive(message= "Id mora biti pozitivan broj.")
	private Long id;
	
	@NotBlank(message = "Naziv prevoznika nije zadat.")
	private String naziv;
	
	private String adresa;
	
	@NotBlank(message = "PIB nije zadat.")
	private String PIB;
	
	//@NotEmpty(message= "Nije zadata nijedna linija koja pripada prevozniku")
	private List<Linija> linije= new ArrayList<>();
	
	public PrevoznikDTO() {
		
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
	
	
	
	

}
