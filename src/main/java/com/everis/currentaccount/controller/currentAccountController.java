package com.everis.currentaccount.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.currentaccount.dto.message;
import com.everis.currentaccount.model.currentAccount;
import com.everis.currentaccount.model.movements;
import com.everis.currentaccount.service.currentAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping
public class currentAccountController {
	@Autowired
	currentAccountService service;

	@PostMapping("/save")
	public Mono<Object> created(@RequestBody @Valid currentAccount model, BindingResult bindinResult) {
		String msg = "";

		if (bindinResult.hasErrors()) {
			for (int i = 0; i < bindinResult.getAllErrors().size(); i++)
				msg = bindinResult.getAllErrors().get(0).getDefaultMessage();
			return Mono.just(new message(msg));
		}
		return service.save(model);
	}

	@PostMapping("/movememts")
	public Mono<Object> registedMovememts(@RequestBody @Valid movements model, BindingResult bindinResult) {
		String msg = "";

		if (bindinResult.hasErrors()) {
			for (int i = 0; i < bindinResult.getAllErrors().size(); i++)
				msg = bindinResult.getAllErrors().get(0).getDefaultMessage();
			return Mono.just(new message(msg));
		}

		return service.saveMovements(model);
	}

	@PostMapping("/addTransfer")
	public Mono<Object> addTransfer(@RequestBody @Valid movements model, BindingResult bindinResult) {
		String msg = "";

		if (bindinResult.hasErrors()) {
			for (int i = 0; i < bindinResult.getAllErrors().size(); i++)
				msg = bindinResult.getAllErrors().get(0).getDefaultMessage();
			return Mono.just(new message(msg));
		}

		return service.saveTransfer(model);
	}

	@GetMapping("/")
	public Flux<Object> findAll() {
		return service.getAll();
	}

	@GetMapping("/byNumberAccount/{number}")
	public Mono<Object> findOneByNumberAccount(@PathVariable("number") String number) {
		return service.getOne(number);
	}

	@GetMapping("/verifyByNumberAccount/{number}")
	public Mono<Boolean> verifyByNumberAccount(@PathVariable("number") String number) {
		return service._verifyByNumberAccount(number);
	}

	@GetMapping("/byCustomer/{id}")
	public Flux<Object> findByCustomer(@PathVariable("id") String id) {
		return service.getByCustomer(id);
	}
}
