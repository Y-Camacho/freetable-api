package cat.ycamacho.freetable_api.repositories;

import org.springframework.data.repository.CrudRepository;
import cat.ycamacho.freetable_api.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {

}
