package Sablon.Test.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Sablon.Test.model.Linija;
import Sablon.Test.repository.LinijaRepository;
import Sablon.Test.service.LinijaService;

@Service
public class JpaLinijaService implements LinijaService{

	@Autowired
	private LinijaRepository linijaRepository;
	
	@Override
	public Linija findOne(Long id) {
		return linijaRepository.findOneById(id);
	}

	@Override
	public Page<Linija> findAll(Integer pageNo) {
		return linijaRepository.findAll(PageRequest.of(pageNo, 2));
	}

//	@Override
//	public List<Linija> findAll() {
//		
//		return linijaRepository.findAll();
//	}
	
	@Override
	public Linija save(Linija linija) {
		return linijaRepository.save(linija);
	}

	@Override
	public Linija update(Linija linija) {
		return linijaRepository.save(linija);
	}

	@Override
	public Linija delete(Long id) {
		Linija linija = findOne (id);
		if (linija != null) {
			linija.getPrevoznik().getLinije().remove(linija);
			linija.setPrevoznik(null);
			linija=linijaRepository.save(linija);
			linijaRepository.delete(linija);
			return linija;
		}
		return linija;
	}

	@Override
	public Page<Linija> find(String destinacija, Double cenaKarteMax, Long prevoznikId, Integer pageNo) {
		
		if(destinacija == null) {
			destinacija = "";
		}
		if(cenaKarteMax == null) {
			cenaKarteMax = Double.MAX_VALUE;
		}
		
		if(prevoznikId == null) {
			return linijaRepository.findByDestinacijaIgnoreCaseContainsAndCenaKarteLessThan(destinacija, cenaKarteMax, PageRequest.of(pageNo, 2));
		}
		return linijaRepository.findByDestinacijaIgnoreCaseContainsAndCenaKarteLessThanAndPrevoznikId(destinacija, cenaKarteMax, prevoznikId, PageRequest.of(pageNo, 2));
	}

//	@Override
//	public List<Linija> findByPrevoznikId(Long prevoznikId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	}


