package br.arantes.produtos.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "categorias")
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "tx_nome")
	private String nome;

	@OneToOne
	private Imagem imagem;

	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.DATE)
	private Calendar dtCadasto;

//	@ManyToMany(mappedBy = "categorias")
//	@LazyCollection(LazyCollectionOption.TRUE)
//	private List<Receita> receitas;

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

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public Calendar getDtCadasto() {
		return dtCadasto;
	}

	public void setDtCadasto(Calendar dtCadasto) {
		this.dtCadasto = dtCadasto;
	}

//	public List<Receita> getReceitas() {
//		return receitas;
//	}
//
//	public void setReceitas(List<Receita> receitas) {
//		this.receitas = receitas;
//	}

}
