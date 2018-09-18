package br.arantes.produtos.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.arantes.admin.entity.User;

@Entity(name = "comentarios")
@Table(name = "comentarios")
public class Comentario {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "tx_mensaem")
	private String mensagem;

	@Column(name = "nr_avaliacao")
	private Double avaliacao;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Calendar dtCadastro;

	@Column(name = "dt_alteracao")
	@Temporal(TemporalType.DATE)
	private Calendar dtAlteracao;

	@OneToOne
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Calendar getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Calendar dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}