package br.com.fiap.helpers.repository;

import br.com.fiap.helpers.model.Donation;
import br.com.fiap.helpers.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {


}
