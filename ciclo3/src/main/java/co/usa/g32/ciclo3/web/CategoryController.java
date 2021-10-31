package co.usa.g32.ciclo3.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.usa.g32.ciclo3.model.Category;
import co.usa.g32.ciclo3.service.CategoryService;


import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping ("/api/Category")
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryController {
    
    
    @Autowired
    private CategoryService categoryService;
    

    @GetMapping("/all")
    public List<Category> getCategories(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
         return categoryService.save(category);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId) {
        return categoryService.deleteCategory(categoryId);
    } 
}