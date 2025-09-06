package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Data;

public interface DataRepository extends JpaRepository<Data, Long> {
}
