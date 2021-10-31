package co.usa.g32.ciclo3.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g32.ciclo3.model.Category;
import co.usa.g32.ciclo3.repository.crud.CategoryCrudRepository;

import java.util.Optional;
import java.util.List;



@Repository

public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>)categoryCrudRepository.findAll();

    }
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save (Category category){
        return categoryCrudRepository.save(category);
    }
    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }

}

