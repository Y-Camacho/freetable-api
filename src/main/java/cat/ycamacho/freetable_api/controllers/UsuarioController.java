package cat.ycamacho.freetable_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Usuario", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

    @GetMapping("/usuarios/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Devuelve los detalles de un usuario específico")
    public String obtenerUsuario(@PathVariable Long id) {
        return "Usuario con ID: " + id;
    }

    @PostMapping("/usuarios")
    @Operation(summary = "Crear un nuevo usuario", description = "Crea un usuario y devuelve la información creada")
    public String crearUsuario(@RequestBody String nombre) {
        return "Usuario creado: " + nombre;
    }
}

