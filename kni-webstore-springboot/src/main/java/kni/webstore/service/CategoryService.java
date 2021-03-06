package kni.webstore.service;

import java.util.List;

import kni.webstore.model.Category;
import kni.webstore.model.SubCategory;

public interface CategoryService {
	
	//Kategoria
	
	Category addCategory(Category category);
	void deleteCategoryById(Long id);
	Category updateCategory(Long id, Category category);
	Category getCategoryById(Long id);
	Category getCategoryByName(String name);
	List<Category> getAllCategories();
	Boolean categoryExist(String name);

	//Podkategoria
	
	SubCategory addSubCategory(Category parent, SubCategory subCategory);
	SubCategory updateSubCategoryOfCategory(Long categoryId, SubCategory subCategory);
	void deleteSubCategoryById(Long id);
	void deleteSubCategoryByName(String name);
	SubCategory getSubCategoryById(Long id);
	SubCategory getSubCategoryByName(String name);
	List<SubCategory> getAllSubCategories();


	// TODO subCategoryExists()
}
