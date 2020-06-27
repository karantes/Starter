package br.arantes.admin.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.RequestMethod;

@Entity(name = "funcionalidades")
@Table(name = "funcionalidades")
public class Funcionalidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tx_name")
	private String name;

	@Column(name = "tx_value")
	private String value;

	@Column(name = "tx_method")
	@Enumerated(EnumType.STRING)
	private RequestMethod method;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public RequestMethod getMethod() {
		return method;
	}

	public void setMethod(RequestMethod method) {
		this.method = method;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, method, name, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Funcionalidade other = (Funcionalidade) obj;
		return Objects.equals(id, other.id) && method == other.method && Objects.equals(name, other.name) && Objects.equals(value, other.value);
	}

}
