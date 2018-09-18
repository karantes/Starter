package br.arantes.produtos.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "imagens")
@Table(name = "imagens")
public class Imagem {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "tx_url")
	private String url;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Calendar dtCadastro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

}
