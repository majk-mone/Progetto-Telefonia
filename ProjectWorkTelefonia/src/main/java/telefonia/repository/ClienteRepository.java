package telefonia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import telefonia.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

}
