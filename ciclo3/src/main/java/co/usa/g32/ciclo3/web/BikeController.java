package co.usa.g32.ciclo3.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import co.usa.g32.ciclo3.model.Bike;
import co.usa.g32.ciclo3.service.BikeService;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping ("/api/Bike")
@CrossOrigin(origins = "*" , methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class BikeController {
    
    
    @Autowired
    private BikeService bikeService;
    

    @GetMapping("/all")
    public List<Bike> getBikes(){
        return bikeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Bike> getBike(@PathVariable("id") int bikeId){
        return bikeService.getBike(bikeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike bike){
         return bikeService.save(bike);
    }
     
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody Bike bike) {
        return bikeService.update(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int bikeId) {
        return bikeService.deleteBike(bikeId);
    } 
}
