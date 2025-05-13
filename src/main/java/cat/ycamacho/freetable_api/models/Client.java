package cat.ycamacho.freetable_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Client {

    @Id
    @Column(length = 60)
    private String email;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private String numberPhone;

    // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    // private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "admin_email")
    private Admin admin;


    // Accesores
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name;}

    public String getNumberPhone() { return numberPhone; }
    public void setNumberPhone(String numberPhone) { this.numberPhone = numberPhone; }

    // public List<Reservation> getReservations() { return reservations; }
    // public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }

    public Admin getAdmin() { return admin; }
    public void setAdmin(Admin admin) { this.admin = admin; }
    
    @Override
    public String toString() {
        return "Client: {email:" + email + ", name:" + name + ", numberPhone:" + numberPhone + "}";
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
        Client other = (Client) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }
}
