package com.edenuncie.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edenuncie.api.domain.Denuncia;
import com.edenuncie.api.services.DenunciaService;

@RestController
@RequestMapping(value="/denuncias")
public class DenunciaResource {

	@Autowired
	private DenunciaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {

		Denuncia obj = service.buscar(id); 
		return ResponseEntity.ok().body(obj);
	}
}