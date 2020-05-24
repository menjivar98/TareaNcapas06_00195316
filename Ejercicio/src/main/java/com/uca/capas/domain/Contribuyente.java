package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name=" contribuyente")
public class Contribuyente {
	
	@Id
	@Column(name="c_contribuyente ")
	private Integer ccontribuyenrte;
	
	@Column(name="c_importancia")
	private Integer cimportancia;
	
	@Column(name="s_nombre")
	private String snombre;
	
	@Column(name="s_apellido")
	private String sapellido;
	
	@Column(name="s_nit ")
	private String snit;
	
	@Column(name="	f_fecha_ingreso")
	private Date ffecha;
	
	public Contribuyente() {}

	public Integer getCcontribuyenrte() {
		return ccontribuyenrte;
	}

	public void setCcontribuyenrte(Integer ccontribuyenrte) {
		this.ccontribuyenrte = ccontribuyenrte;
	}

	public Integer getCimportancia() {
		return cimportancia;
	}

	public void setCimportancia(Integer cimportancia) {
		this.cimportancia = cimportancia;
	}

	public String getSnombre() {
		return snombre;
	}

	public void setSnombre(String snombre) {
		this.snombre = snombre;
	}

	public String getSapellido() {
		return sapellido;
	}

	public void setSapellido(String sapellido) {
		this.sapellido = sapellido;
	}
	
	

	public String getSnit() {
		return snit;
	}

	public void setSnit(String snit) {
		this.snit = snit;
	}

	public Date getFfecha() {
		return ffecha;
	}

	public void setFfecha(Date ffecha) {
		this.ffecha = ffecha;
	}
	
	//DELEGATE FORM
	
	//Delegate para conversion de fecha
		public String getFechaDelegate(){
			if(this.ffecha == null){
				return "";
			}
			else{
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String shortdate = sdf.format(this.ffecha.getTime());
				return shortdate;
			}
		}

}
