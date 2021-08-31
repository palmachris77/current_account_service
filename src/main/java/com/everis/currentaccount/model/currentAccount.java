package com.everis.currentaccount.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.everis.currentaccount.consumer.webclient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "current-account")
public class currentAccount {
	@Id
	private String idCurrentAccount;
	private String profile;

	private String accountNumber = webclient.logic.get().uri("/generatedNumberLong/12").retrieve()
			.bodyToMono(String.class).block();

	private double amount = 0.0;
	private Date dateCreated = new Date();
	private String typeAccount = "Cuenta corriente.";
	private List<movements> movement = new ArrayList<movements>();

	@NotBlank(message = "Debe seleccionar un cliente.")
	private String idCustomer;

	public currentAccount() {
		this.profile = "";
	}

	public currentAccount(String idCustomer) {
		this.profile = "";
		this.idCustomer = idCustomer;
	}

	public currentAccount(String idCustomer, String profile) {
		this.profile = profile;
		this.idCustomer = idCustomer;
	}
}
