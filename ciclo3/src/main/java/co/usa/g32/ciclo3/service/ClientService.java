package co.usa.g32.ciclo3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.g32.ciclo3.model.Client;
import co.usa.g32.ciclo3.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient (int  idClient){
        return clientRepository.getClient(idClient);
    }
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if(e == null){
                return clientRepository.save(client);
            }else{
                return client;
            }

        }
    }
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(e != null){   
                                                      
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }     
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }               
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }                
                clientRepository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

