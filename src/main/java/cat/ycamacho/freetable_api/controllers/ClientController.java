package cat.ycamacho.freetable_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.ycamacho.freetable_api.models.Client;
import cat.ycamacho.freetable_api.repositories.ClientRespository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientRespository _ClientRespository;

    @GetMapping
    public List<Client> getClients() {
        return (List<Client>)_ClientRespository.findAll();
    }

    @GetMapping("/{clientEmail}")
    public Client getMethodName(@PathVariable String clientEmail) {
        return _ClientRespository.findById(clientEmail).orElseThrow();
    }
    
    
}