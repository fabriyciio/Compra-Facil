package com.project.cotafacil.controller.provider;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cotafacil.exception.provider.ProviderFoundException;
import com.project.cotafacil.exception.provider.ProviderInvalidUpdateException;
import com.project.cotafacil.model.dto.response.Response;
import com.project.cotafacil.model.dto.provider.ProviderDTO;
import com.project.cotafacil.model.dto.provider.ProviderRequestDTO;
import com.project.cotafacil.model.provider.Provider;
import com.project.cotafacil.service.provider.ProviderService;
import io.swagger.annotations.ApiOperation;



import java.util.Optional;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/providers")
public class ProviderController {
	
	@Autowired
	private ProviderService service;
	

	@Autowired
	public ProviderController(ProviderService providerService) {
		this.service = providerService;
	}
	
	
	@GetMapping
	@ApiOperation(value = "Rota que busca todos os usuários ativos")
	public ResponseEntity<Response<Page<ProviderDTO>>> findAll( @PageableDefault(page = 0, size = 10, sort = {"id"}) Pageable pageable) throws ProviderFoundException{
		Response<Page<ProviderDTO>> response = new Response<>();
		
		Page<Provider> findProvider = service.findByExcludedFalsePageable(pageable);
		
		if(findProvider.isEmpty()) {
			throw new ProviderFoundException("Nenhum usuário encontrado!");
		}
		
		Page<ProviderDTO> providers = findProvider.map(u -> u.convertEntityToDTO());
		
		response.setData(providers);
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(value = "Rota que busca um usuário")
	public ResponseEntity<Response<ProviderDTO>> findById(@PathVariable Integer id) throws ProviderFoundException{
		Response<ProviderDTO> response = new Response<>();
		
		Optional<Provider> provider = service.findById(id);
		if(provider.isEmpty()) {
			throw new ProviderFoundException("Usuário não encontrado");
		}
		
		Provider providerEntity = provider.get();	
		response.setData(providerEntity.convertEntityToDTO());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Rota que cria um novo usuário")
	public ResponseEntity<Response<ProviderDTO>> create(@Valid @RequestBody ProviderRequestDTO providerDTO, BindingResult result) throws ProviderFoundException{
		Response<ProviderDTO> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		//Provider provider  = providerDTO.convertDTOToEntity();
	    //Provider providerToCreate = service.save(provider);
		
		//response.setData(providerToCreate.convertEntityToDTO());
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping
	@ApiOperation(value = "Rota que atua os dados do usuário")
	public ResponseEntity<Response<ProviderDTO>> update(@Valid @RequestBody ProviderRequestDTO providerDTO, BindingResult result) throws ProviderFoundException, ProviderInvalidUpdateException{
		Response<ProviderDTO> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Optional<Provider> providerToFind = service.findById(providerDTO.getId());
		if(!providerToFind.isPresent()) {
			throw new ProviderFoundException("Fornecedor não encontrado para realizar a atualização. ID:" + providerDTO.getId());
		}
		
		Provider provider = providerDTO.convertDTOToEntity();
		Provider providerToUpdate = service.update(provider, providerToFind.get());
		
		response.setData(providerToUpdate.convertEntityToDTO());
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	@ApiOperation(value = "Rota que busca um usuário")
	public ResponseEntity<Response<String>> delete(@PathVariable Integer id) throws ProviderFoundException{
		Response<String> response = new Response<>();
		
		Optional<Provider>  provider = service.findById(id);
		if(provider.isEmpty()) {
			throw new ProviderFoundException("Fornecedor não encontrado");
		}
		
		Provider providerEntity = provider.get();	
		
		service.delete(providerEntity);
		
		response.setData("Fornecedor deletado com sucesso!");
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
