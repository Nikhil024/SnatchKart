package ga.snatchkart.backend.repository;

import ga.snatchkart.backend.modal.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Optional<Users> findById(Long id);
    Optional<Users> findByEmail(String email);
    Boolean existsByEmail(String email);
}
