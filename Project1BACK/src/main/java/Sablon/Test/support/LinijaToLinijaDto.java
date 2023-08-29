package Sablon.Test.support;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Linija;
import Sablon.Test.web.dto.LinijaDTO;

@Component
public class LinijaToLinijaDto implements Converter<Linija, LinijaDTO>{


	
	@Override
	public LinijaDTO convert(Linija linija) {
		LinijaDTO linijaDTO = new LinijaDTO();
		linijaDTO.setId(linija.getId());
		linijaDTO.setBrojMesta(linija.getBrojMesta());
		linijaDTO.setCenaKarte(linija.getCenaKarte());
		linijaDTO.setDestinacija(linija.getDestinacija());
		linijaDTO.setVremePolaska(linija.getVremePolaska());
		linijaDTO.setPrevoznikId(linija.getPrevoznik().getId());
		linijaDTO.setPrevoznikNaziv(linija.getPrevoznik().getNaziv());
		
		return linijaDTO;
	}
	
	public List<LinijaDTO> convert (List <Linija> linije) {
		List<LinijaDTO> linijeDto = new ArrayList<>();
		
		for(Linija linija : linije) { 
			linijeDto.add(convert(linija));
			}
		return linijeDto;
	}

}
