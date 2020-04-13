package  br.com.fiap.helpers.repository;

import br.com.fiap.helpers.model.Service;
import br.com.fiap.helpers.model.Voluntier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoluntierRepository extends JpaRepository<Voluntier, Long> {

    //public Optional<List<Service>> getServices(Voluntier voluntier);
}
