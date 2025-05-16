package cat.ycamacho.freetable_api.models.dto;

public class UserDTO {

    private String email;
    private String fullName;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    @Override
    public String toString() {
        return "UserDTO: {email=" + email + ", fullName=" + fullName + "}";
    }

}
