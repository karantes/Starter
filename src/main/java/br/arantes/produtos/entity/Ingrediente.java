package br.arantes.produtos.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "ingredientes")
@Table(name = "ingredientes")
public class Ingrediente {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "tx_nome")
	private String nome;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Calendar dtCadastro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

}
