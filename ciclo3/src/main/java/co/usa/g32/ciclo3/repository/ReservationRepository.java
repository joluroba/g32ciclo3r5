package co.usa.g32.ciclo3.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g32.ciclo3.model.Reservation;
import co.usa.g32.ciclo3.repository.crud.ReservationCrudRepository;
import co.usa.g32.ciclo3.model.Client;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Repository

public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();

    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save (Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    public List<Reservation> ReservacionStatusRepositorio (String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    
    public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    
    }
    
    public List<CountClients> getClientesRepositorio(){
        List<CountClients> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new CountClients((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }


}