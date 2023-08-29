package Sablon.Test.repository;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sablon.Test.model.Linija;

@Repository
public interface LinijaRepository extends JpaRepository<Linija, Long > {

	Linija findOneById(long id);
	
	Page<Linija> findByDestinacijaIgnoreCaseContainsAndCenaKarteLessThanAndPrevoznikId (String destinacija, Double cenaKarteMax, Long prevoznikId, Pageable pageable );
	
	Page<Linija> findByDestinacijaIgnoreCaseContainsAndCenaKarteLessThan (String destinacija, Double cenaKarteMax, Pageable pageabe);
	
	//Page<Linija> search(String destinacija, Long prevoznikId, Double cenaKarteDo);
}
