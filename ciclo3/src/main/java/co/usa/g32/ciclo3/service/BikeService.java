package co.usa.g32.ciclo3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g32.ciclo3.model.Bike;
import co.usa.g32.ciclo3.repository.BikeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.getAll();
    }
    public Optional<Bike> getBike (int  bikeId){
        return bikeRepository.getBike(bikeId);
    }
    public Bike save(Bike bike){
        if(bike.getId()==null){
            return bikeRepository.save(bike);
        }else{
            Optional<Bike> e=bikeRepository.getBike(bike.getId());
            if(e == null){
                return bikeRepository.save(bike);
            }else{
                return bike;
            }

        }
    }
   
    public Bike update(Bike bike){
        if(bike.getId()!=null){
            Optional<Bike> e=bikeRepository.getBike(bike.getId());
            if(e != null){
                if(bike.getName()!=null){
                    e.get().setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    e.get().setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    e.get().setYear(bike.getYear());
                }
                if(bike.getDescription()!=null){
                    e.get().setDescription(bike.getDescription());
                }
                if(bike.getCategory()!=null){
                    e.get().setCategory(bike.getCategory());
                }
                bikeRepository.save(e.get());
                return e.get();
            }else{
                return bike;
            }
        }else{
            return bike;
        }
    }


    public boolean deleteBike(int bikeId) {
        Boolean aBoolean = getBike(bikeId).map(bike -> {
            bikeRepository.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

