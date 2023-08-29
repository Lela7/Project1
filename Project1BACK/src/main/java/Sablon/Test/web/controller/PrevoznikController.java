package Sablon.Test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Sablon.Test.model.Prevoznik;
import Sablon.Test.service.LinijaService;
import Sablon.Test.service.PrevoznikService;
import Sablon.Test.support.LinijaToLinijaDto;
import Sablon.Test.support.PrevoznikDtoToPrevoznik;
import Sablon.Test.support.PrevoznikToPrevoznikDto;
import Sablon.Test.web.dto.PrevoznikDTO;

@RestController
@RequestMapping(value = "/api/prevoznici", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class PrevoznikController {
	
	@Autowired
	private PrevoznikService prevoznikService;
	
	@Autowired 
	private LinijaService linijaService;
	
	@Autowired
	private PrevoznikDtoToPrevoznik toPrevoznik;
	
	@Autowired
	private PrevoznikToPrevoznikDto toPrevoznikDto;
	
	@Autowired
	private LinijaToLinijaDto toLinijaDto;
	
	//@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrevoznikDTO> create(@Valid @RequestBody PrevoznikDTO prevoznikDTO) {
		Prevoznik prevoznik = toPrevoznik.convert(prevoznikDTO);
		Prevoznik sacuvaniPrevoznik = prevoznikService.save(prevoznik);
		
		return new ResponseEntity<>(toPrevoznikDto.convert(sacuvaniPrevoznik), HttpStatus.CREATED);
	}
    
    //@PreAuthorize ("hasAnyRole ('KORISNIK' , 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<PrevoznikDTO> getOne(@PathVariable Long id) {
    	Prevoznik prevoznik = prevoznikService.findOne(id);
    	
    	if(prevoznik != null) {
    		return new ResponseEntity<>(toPrevoznikDto.convert(prevoznik), HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    }
    //@PreAthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<PrevoznikDTO>> getAll (
    		@RequestParam(required=false) String naziv,
    		@RequestParam(required=false) String adresa,
    		@RequestParam(required=false) String PIB) {
    	
    	List<Prevoznik> prevoznici = prevoznikService.find(naziv, adresa, PIB);
    	
    	return new ResponseEntity<>(toPrevoznikDto.convert(prevoznici), HttpStatus.OK);
    	
    }
    		
    		
    

}
