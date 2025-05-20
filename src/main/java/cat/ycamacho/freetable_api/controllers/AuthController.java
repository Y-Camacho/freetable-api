package cat.ycamacho.freetable_api.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cat.ycamacho.freetable_api.models.Admin;
import cat.ycamacho.freetable_api.models.dto.UserDTO;
import cat.ycamacho.freetable_api.repositories.AdminRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AdminRepository _AdminRepository;

    @PostMapping
    public Map<String, Object> login(@RequestBody Admin requesAdmin) {
        Admin admin = _AdminRepository.findById(requesAdmin.getEmail()).orElseThrow();
        if(!requesAdmin.getPassword().equals(admin.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(admin.getEmail());
        userDTO.setFullName(admin.getName());

        Map<String, Object> mapResponse = new HashMap<String, Object>();
        mapResponse.put("user", userDTO);
        mapResponse.put("token", UUID.randomUUID());
        

        return mapResponse;
    }
    
}
