package cat.ycamacho.freetable_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
    
    @Id
    @Column(length = 60)
    private String email;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 15)
    private String password;

    // @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    // private List<Client> clients;

    // @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    // private List<Restaurant> restaurants;

    public Admin() { }
    public Admin(String email) { this.email = email; }

    // Accesores
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    // public List<Client> getClients() { return clients; }
    // public void setClients(List<Client> clients) { this.clients = clients; }

    // public List<Restaurant> getRestaurants() { return restaurants; }
    // public void setRestaurants(List<Restaurant> restaurants) { this.restaurants = restaurants; }

    @Override
    public String toString() {
        return "Admin: {name: " + name + ", email: " + email + ", password: " + password + "}";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Admin other = (Admin) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

}
