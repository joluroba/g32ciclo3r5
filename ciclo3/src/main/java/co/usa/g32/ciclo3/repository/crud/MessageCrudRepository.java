package co.usa.g32.ciclo3.repository.crud;

import org.springframework.data.repository.CrudRepository;

import co.usa.g32.ciclo3.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
