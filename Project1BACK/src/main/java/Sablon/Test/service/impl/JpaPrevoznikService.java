package Sablon.Test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sablon.Test.model.Prevoznik;
import Sablon.Test.repository.PrevoznikRepository;
import Sablon.Test.service.PrevoznikService;

@Service
public class JpaPrevoznikService implements PrevoznikService{
	
	@Autowired
	private PrevoznikRepository prevoznikRepository;

	@Override
	public Prevoznik findOne(Long id) {
		return prevoznikRepository.findOneById(id);
	}

	@Override
	public List<Prevoznik> findAll() {
		return prevoznikRepository.findAll();
	}

	@Override
	public Prevoznik save(Prevoznik prevoznik) {
		return prevoznikRepository.save(prevoznik);
	}

	@Override
	public Prevoznik update(Prevoznik prevoznik) {
		return prevoznikRepository.save(prevoznik);
	}

	//Kad se obrise prevoznik, obrisae se i sve linije vezane za tog prevoznika:
	
	@Override
	public Prevoznik delete(Long id) {
		Optional<Prevoznik> prevoznik= prevoznikRepository.findById(id);
		if(prevoznik.isPresent()) {
			prevoznikRepository.deleteById(id);
			return prevoznik.get();
		}
		return null;
	}

	@Override
	public List<Prevoznik> find(String naziv, String adresa, String pIB) {
	
		if (naziv == null) {
			naziv="";
		}
		if (adresa == null) {
			adresa="";
		}
		if (pIB == null) {
			pIB="";
			
		} return prevoznikRepository.findAll();
	}

}
