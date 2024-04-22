package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Clerk;
import madsilver.model.Person;

import java.util.Optional;

public interface PersonRepository extends BaseRepository<Person, Long> {
    boolean isExistsByUsername(String username);
    Optional<Person> findByPersonalCode(String personalCode);
}
