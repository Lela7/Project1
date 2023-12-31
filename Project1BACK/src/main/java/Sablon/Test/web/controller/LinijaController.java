package Sablon.Test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import Sablon.Test.model.Linija;
import Sablon.Test.service.LinijaService;
import Sablon.Test.service.PrevoznikService;
import Sablon.Test.support.LinijaDtoToLinija;
import Sablon.Test.support.LinijaToLinijaDto;
import Sablon.Test.web.dto.LinijaDTO;

@RestController
@RequestMapping(value = "/api/linije", produces= MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LinijaController {
	
	@Autowired
	private LinijaService linijaService;
	
	@Autowired
	private PrevoznikService prevoznikService;
	
	@Autowired
	private LinijaDtoToLinija toLinija;
	
	@Autowired
	private LinijaToLinijaDto toLinijaDto;
	
	  //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LinijaDTO> create (@Valid @RequestBody LinijaDTO linijaDTO) {
    	Linija linija = toLinija.convert(linijaDTO);
    	
    	if(linija.getPrevoznik() == null) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	Linija sacuvanaLinija = linijaService.save(linija);
    	
    	return new ResponseEntity<>(toLinijaDto.convert(sacuvanaLinija), HttpStatus.CREATED);
    }
    
  //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LinijaDTO> update(@PathVariable Long id, @Valid @RequestBody LinijaDTO linijaDTO ) {
    
    if(!id.equals(linijaDTO.getId())) {
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    Linija linija = toLinija.convert(linijaDTO);
    
    if(linija.getPrevoznik() == null) {
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Linija sacuvanaLinija = linijaService.update(linija);
    
    return new ResponseEntity<>(toLinijaDto.convert(sacuvanaLinija),HttpStatus.OK);
    }
    
  //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
    	Linija obrisanaLinija = linijaService.delete(id);
    	
    	if(obrisanaLinija != null) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	} else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    
    //@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<LinijaDTO> getOne(@PathVariable Long id){
    	Linija linija = linijaService.findOne(id);
    	
    	if(linija != null) {
    		return new ResponseEntity<>(toLinijaDto.convert(linija), HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    } 
    
    

    //@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<LinijaDTO>> getAll(
    		@RequestParam(required=false) String destinacija,
    		@RequestParam (required= false) Double cenaKarteMax,
    		@RequestParam (required=false) Long prevoznikId,
    		@RequestParam(required=false) String vremePolaska,
    		@RequestParam(required=false) Integer brojMesta,
    		@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
    	
    	Page<Linija> page;
    	
    	try {
    		page=linijaService.find(destinacija, cenaKarteMax, prevoznikId, pageNo);
    	}catch (Exception e) {
    		page = linijaService.findAll(pageNo);
    	}
    	

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

        return new ResponseEntity<>(toLinijaDto.convert(page.getContent()), headers, HttpStatus.OK);
    
    }
}


//obican prikaz:
//@PreAuthorize("hasRole('ADMIN')")
//@GetMapping
//public ResponseEntity<List<DrzavaDTO>> getAll(
//		@RequestParam(required = false) String name){
//	
//	List<Drzava> drzave = drzavaService.findAll();
//	return new ResponseEntity<>(toDrzavaDTO.convert(drzave), HttpStatus.OK);
//}
    		
    		
    


