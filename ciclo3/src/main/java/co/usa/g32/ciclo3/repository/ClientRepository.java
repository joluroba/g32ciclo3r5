package co.usa.g32.ciclo3.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.g32.ciclo3.model.Client;
import co.usa.g32.ciclo3.repository.crud.ClientCrudRepository;

import java.util.Optional;
import java.util.List;



@Repository

public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>)clientCrudRepository.findAll();

    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save (Client client){
        return clientCrudRepository.save(client);
    }
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }

}

