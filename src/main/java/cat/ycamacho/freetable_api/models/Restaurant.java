package cat.ycamacho.freetable_api.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

enum Tag {
    MEDITERRANEO, ASIATICO, ITALIANO, VEGETARIANO, VEGANO, PARRILLA
}

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 60, unique = true)
    private String email;

    @Column(nullable = false, length = 300)
    private String description;

    private String address;
    private int numDiners;

    @ElementCollection
    @CollectionTable(name = "restaurant_tags", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "tag")
    private List<String> tags;

    @ElementCollection
    @CollectionTable(name = "restaurant_imgs", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "image")
    private List<String> images;

    // @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    // private List<Reservation> reservations; //

    @ManyToOne
    @JoinColumn(name = "admin_email")
    private Admin admin; 

    // Metodos

    /**
     * Obtiene un string con tags separador con coma ',' y los convierte en un 
     * List<String>
     * @param tagsString
     */
    public void setTagsString(String tagsString){
        String[] tagsArray = tagsString.split(",");
        List<String> tags = new ArrayList<String>();
        
        for (String tag : tagsArray) {
            try {
                // Limpia espacios y convierte el valor a mayúsculas para que coincida con el enum.
                Tag ejTag = Tag.valueOf(tag.trim().toUpperCase());
                tags.add(ejTag.toString());
            } catch (IllegalArgumentException e) {
                // Imprime un mensaje si el tag no es válido.
                System.err.println("Etiqueta no válida: " + tag);
            }
        }

        // Asigna la lista de tags a una variable de clase (si corresponde).
        this.tags = tags;
    }

    /**
     * Función que verifica que los tags de un restaurante sean válidos
     */
    public void testTags() {
        List<String> tags = this.getTags();
        
        for (String tag : tags) {
            try {
                // Aprovecha que el .valueOf() lanza una excepción si no hay coincidencia
                Tag ejTag = Tag.valueOf(tag.trim().toUpperCase());
                System.out.println(ejTag);// Es para que no marque el unused xd
            } catch (IllegalArgumentException e) {
                // Y lanza la misma excepción
                throw e;
            }
        }
    }
    
    // Accesores
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public int getNumDiners() { return numDiners; }
    public void setNumDiners(int numDiners) { this.numDiners = numDiners; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }
    
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }
    
    public List<String> getImages() { return images; }
    public void setImages(List<String> images) { this.images = images; }
    
    @Override
    public String toString() {
        return "Restaurant [id=" + id + ", name=" + name + ", email=" + email + ", description=" + description
                + ", address=" + address + ", numDiners=" + numDiners + ", tags=" + tags + ", images=" + images
                + ", admin=" + admin + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restaurant other = (Restaurant) obj;
        if (id != other.id)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }
}
