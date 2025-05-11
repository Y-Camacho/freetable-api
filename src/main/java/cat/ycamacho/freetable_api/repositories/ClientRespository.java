package cat.ycamacho.freetable_api.repositories;

import org.springframework.data.repository.CrudRepository;

import cat.ycamacho.freetable_api.models.Client;

public interface ClientRespository extends CrudRepository<Client, String>{

}
