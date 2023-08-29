package Sablon.Test.service;

import java.util.List;

import Sablon.Test.model.Prevoznik;

public interface PrevoznikService {
	
	Prevoznik findOne(Long id);
	
	List<Prevoznik> findAll();
	
	Prevoznik save( Prevoznik prevoznik);
	
	Prevoznik update(Prevoznik prevoznik);
	
	Prevoznik delete (Long id);

	List<Prevoznik> find(String naziv, String adresa, String pIB);
	
	

}
