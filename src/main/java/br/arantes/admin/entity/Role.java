package br.arantes.admin.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "ADM_ROLES")
@Table(name = "ADM_ROLES")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tx_name")
	private String name;

	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Menu> menus;

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

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Boolean hasFuncionalidade(String value) {
		for (Menu menu : this.getMenus()) {
			for (Funcionalidade funcionalidade : menu.getFuncionalidades())
				if (funcionalidade.getValue().equals(value))
					return true;
		}
		return false;
	}

	public Boolean hasMenu(String value) {
		for (Menu menu : this.getMenus()) {
			if (menu.getName().equals(value))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return name;
	}

}
