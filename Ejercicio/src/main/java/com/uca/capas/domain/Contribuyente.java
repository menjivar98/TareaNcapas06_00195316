package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name=" contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_contribuyente ")
	private Integer ccontribuyenrte;
	
	@Column(name="c_importancia")
	private Integer c_importancia;
	
	public Integer getC_importancia() {
		return c_importancia;
	}

	public void setC_importancia(Integer c_importancia) {
		this.c_importancia = c_importancia;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}




	@Column(name="s_nombre")
	private String snombre;
	
	@Column(name="s_apellido")
	private String sapellido;
	
	@Column(name="s_nit ")
	private String snit;
	
	@Column(name="	f_fecha_ingreso")
	private Date ffecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;
	
	public Contribuyente() {}

	public Integer getCcontribuyenrte() {
		return ccontribuyenrte;
	}

	public void setCcontribuyenrte(Integer ccontribuyenrte) {
		this.ccontribuyenrte = ccontribuyenrte;
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
		
/*	//Delegate para conversion de importancia
	public String getImportancia() {
		String Importancia = " "; 
		if(this.cimportancia == null) {
			return Importancia;
		}else if(this.cimportancia == 1) {
			Importancia ="Grande";
		}else if(this.cimportancia == 2) {
			Importancia = "Mediano";
		}else {
			Importancia ="Otros";
		}
		
		
		return Importancia;
	}*/

}
