package Sablon.Test.service;



import org.springframework.data.domain.Page;

import Sablon.Test.model.Linija;

public interface LinijaService {
	
	Linija findOne(Long id);
	
	Page<Linija> findAll(Integer pageNo);
	
	Linija save(Linija linija);
	
	Linija update(Linija linija);
	
	Linija delete (Long id);
	
	Page<Linija> find (String destinacija, Double cenaKarteMax, Long prevoznikId, Integer pageNo);
	
	//List <Linija> findByPrevoznikId(Long prevoznikId);

}
