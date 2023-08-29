package Sablon.Test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Linija;
import Sablon.Test.service.LinijaService;
import Sablon.Test.service.PrevoznikService;
import Sablon.Test.web.dto.LinijaDTO;

@Component
public class LinijaDtoToLinija implements Converter<LinijaDTO, Linija>{

	@Autowired
	private LinijaService linijaService;
	
	@Autowired 
	private PrevoznikService prevoznikService;
	
	@Override
	public Linija convert(LinijaDTO dto) {
		Linija linija;
		
		if(dto.getId() == null) {
			linija = new Linija();
		} else {
			linija= linijaService.findOne(dto.getId());
		}
		
		if(linija != null) {
			linija.setBrojMesta(dto.getBrojMesta());
			linija.setCenaKarte(dto.getCenaKarte());
			linija.setDestinacija(dto.getDestinacija());
			linija.setPrevoznik(prevoznikService.findOne(dto.getPrevoznikId()));
		}
		return linija;
	}

}
