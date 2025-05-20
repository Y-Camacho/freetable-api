package cat.ycamacho.freetable_api.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin
@RestController
@RequestMapping("/api/files")
public class FileController {

    private final String IMAGE_DIRECTORY = "src/main/resources/static/images/";

    @GetMapping
    public ResponseEntity<Resource> getImage(@RequestParam("imgName") String imgName) {
        try {
            // Construir la ruta de la imagen
            Path imagePath = Paths.get(IMAGE_DIRECTORY + imgName);
            Resource resource = new UrlResource(imagePath.toUri());

            // Verificar si el recurso existe y es legible
            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.notFound().build();
            }

            // Determinar el tipo de contenido de la imagen
            String contentType = "image/jpeg";  // Por defecto
            if (imgName.endsWith(".png")) contentType = "image/png";
            else if (imgName.endsWith(".gif")) contentType = "image/gif";

            // Crear la respuesta
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}