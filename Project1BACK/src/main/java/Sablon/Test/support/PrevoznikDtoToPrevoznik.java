package Sablon.Test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Prevoznik;
import Sablon.Test.service.PrevoznikService;
import Sablon.Test.web.dto.PrevoznikDTO;

@Component
public class PrevoznikDtoToPrevoznik implements Converter<PrevoznikDTO, Prevoznik>{

	@Autowired 
	PrevoznikService prevoznikService;
	
	@Override
	public Prevoznik convert(PrevoznikDTO dto) {
		 Prevoznik entity;
		 
		 if(dto.getId() == null) {
			 entity = new Prevoznik();
		 } else {
			 entity = prevoznikService.findOne(dto.getId());
		 }
		 
		 if (entity != null) {
			 entity.setAdresa(dto.getAdresa());
			 entity.setNaziv(dto.getNaziv());
			 entity.setPIB(dto.getPIB());
		 }
		 return entity;
	}

}
