package co.usa.g32.ciclo3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g32.ciclo3.model.Reservation;
import co.usa.g32.ciclo3.repository.CountClients;
import co.usa.g32.ciclo3.repository.ReservationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * Clase Reservacion 
 */

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
/**
 * GET  lista Reservacion 
 */


    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation (int  idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    /**
 * Save   lista Reservacion 
 */

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
            if(e == null){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }

        }
    }
      /**
 * Update   lista Reservacion 
 */
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(e != null){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    /**
 * Delete   lista Reservacion 
 */

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public StatusReservations reporteStatusServicio (){
        List<Reservation>completed= reservationRepository.ReservacionStatusRepositorio("completed");
        List<Reservation>cancelled= reservationRepository.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservations(completed.size(), cancelled.size() );
    }
    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepository.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }
        public List<CountClients> reporteClientesServicio(){
            return reservationRepository.getClientesRepositorio();
        }

    }


