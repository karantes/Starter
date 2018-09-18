package br.arantes.produtos.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.arantes.admin.entity.User;

@Entity(name = "receitas")
@Table(name = "receitas")
public class Receita {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "tx_nome")
	private String nome;

	@Column(name = "tx_modo_de_fazer")
	private String modoDeFazer;

	@Column(name = "tx_observacao")
	private String observacao;

	@Column(name = "nr_rendimento")
	private Double rendimento;

	@Column(name = "nr_media_avaliacao")
	private Double mediaAvaliacao;

	@Column(name = "tx_status")
	private String status;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Calendar dtCadastro;

	@Column(name = "dt_alteracao")
	@Temporal(TemporalType.DATE)
	private Calendar dtAlteracao;

	@Column(name = "tx_tempo_de_preparo")
	private String tempoDePreparo;

//	@OneToOne
//	@LazyCollection(LazyCollectionOption.TRUE)
//	private User autor;
//
//	@ManyToMany
//	@LazyCollection(LazyCollectionOption.TRUE)
//	private List<Categoria> categorias;
//
//	@OneToMany
//	private List<Ingrediente> ingredientes;
//
//	@OneToMany
//	private List<Comentario> comentarios;
//
//	@OneToMany
//	@LazyCollection(LazyCollectionOption.TRUE)
//	private List<Imagem> imagens;

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

	public String getModoDeFazer() {
		return modoDeFazer;
	}

	public void setModoDeFazer(String modoDeFazer) {
		this.modoDeFazer = modoDeFazer;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Double getRendimento() {
		return rendimento;
	}

	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}

	public Double getMediaAvaliacao() {
		return mediaAvaliacao;
	}

	public void setMediaAvaliacao(Double mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getTempoDePreparo() {
		return tempoDePreparo;
	}

	public void setTempoDePreparo(String tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

//	public User getAutor() {
//		return autor;
//	}
//
//	public void setAutor(User autor) {
//		this.autor = autor;
//	}
//
//	public List<Categoria> getCategorias() {
//		return categorias;
//	}
//
//	public void setCategorias(List<Categoria> categorias) {
//		this.categorias = categorias;
//	}
//
//	public List<Ingrediente> getIngredientes() {
//		return ingredientes;
//	}
//
//	public void setIngredientes(List<Ingrediente> ingredientes) {
//		this.ingredientes = ingredientes;
//	}
//
//	public List<Comentario> getComentarios() {
//		return comentarios;
//	}
//
//	public void setComentarios(List<Comentario> comentarios) {
//		this.comentarios = comentarios;
//	}
//
//	public List<Imagem> getImagens() {
//		return imagens;
//	}
//
//	public void setImagens(List<Imagem> imagens) {
//		this.imagens = imagens;
//	}

}
