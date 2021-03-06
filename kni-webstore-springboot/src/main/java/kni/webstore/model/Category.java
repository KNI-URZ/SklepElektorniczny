package kni.webstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {
	
	private static final long serialVersionUID = -2076423689506877852L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(cascade= CascadeType.REMOVE, mappedBy="category", fetch=FetchType.EAGER)
	private List<SubCategory> subCategories;
	
	public Category(String name, List<SubCategory> subCategories) {
		this.name = name;
		this.subCategories = subCategories;
	}
	
	public Category(String name) {
		this.name = name;
		this.subCategories = new ArrayList<SubCategory>();
	}
	
	public Category() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public void addSubCategory(SubCategory subCat) {
		if (this.subCategories.contains(subCat)) 
			return;
		
		this.subCategories.add(subCat);
		subCat.setCategory(this);
	}
	
	public void removeSubCategory(SubCategory subCat) {
		this.subCategories.remove(subCat);
		subCat.setCategory(null);
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
