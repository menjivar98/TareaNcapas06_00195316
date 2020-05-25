package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(schema = "public", name="importancia")
public class Importancia {
	@Id
	@Column(name="c_importancia")
	private Integer cimportancia;
	
	@Column(name="s_importancia")
	private String simportancia;
	
	@OneToMany(mappedBy = "ccontribuyenrte",fetch = FetchType.EAGER)
	private List<Contribuyente> contribuyente;

	public Integer getCimportancia() {
		return cimportancia;
	}

	public void setCimportancia(Integer cimportancia) {
		this.cimportancia = cimportancia;
	}

	public String getSimportancia() {
		return simportancia;
	}

	public void setSimportancia(String simportancia) {
		this.simportancia = simportancia;
	}

	public List<Contribuyente> getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(List<Contribuyente> contribuyente) {
		this.contribuyente = contribuyente;
	}

	
	
}
