package co.usa.g32.ciclo3.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g32.ciclo3.model.Bike;
import co.usa.g32.ciclo3.repository.crud.BikeCrudRepository;

import java.util.Optional;
import java.util.List;



@Repository

public class BikeRepository {
    
    @Autowired
    private BikeCrudRepository bikeCrudRepository;

    public List<Bike> getAll(){
        return (List<Bike>)bikeCrudRepository.findAll();

    }
    public Optional<Bike> getBike(int id){
        return bikeCrudRepository.findById(id);
    }

    public Bike save (Bike bike){
        return bikeCrudRepository.save(bike);
    }
     
    public void delete(Bike bike){
        bikeCrudRepository.delete(bike);
    }
    

}
