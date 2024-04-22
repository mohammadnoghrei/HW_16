package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Clerk;
import madsilver.model.Person;
import madsilver.repository.ClerkRepository;

import java.util.Optional;

public interface PersonService extends BaseService<Person,Long> {
    boolean isExistsByUsername(String username);
    Person findByPersonalCode(String personalCode);
}
