package Sablon.Test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Sablon.Test.model.Prevoznik;
import Sablon.Test.web.dto.PrevoznikDTO;

@Component
public class PrevoznikToPrevoznikDto implements Converter <Prevoznik, PrevoznikDTO>{

	@Override
	public PrevoznikDTO convert(Prevoznik prevoznik) {
		PrevoznikDTO dto= new PrevoznikDTO();
		dto.setId(prevoznik.getId());
		dto.setAdresa(prevoznik.getAdresa());
		dto.setNaziv(prevoznik.getNaziv());
		dto.setPIB(prevoznik.getPIB());
		return dto;
	}
	
	public List<PrevoznikDTO> convert(List<Prevoznik> prevoznici) {
		List<PrevoznikDTO> prevozniciDto = new ArrayList<>();
		
		for (Prevoznik prevoznik: prevoznici) {
			prevozniciDto.add(convert(prevoznik));
		}
		return prevozniciDto;
	}

}
