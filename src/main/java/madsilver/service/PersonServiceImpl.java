package madsilver.service;

import madsilver.base.exeption.NotFoundException;
import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Clerk;
import madsilver.model.Person;
import madsilver.repository.ClerkRepository;
import madsilver.repository.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonServiceImpl extends BaseServiceImpl<Person,Long, PersonRepository> implements PersonService{
    public PersonServiceImpl(PersonRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    @Override
    public Person findByPersonalCode(String personalCode) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Person foundEntity = repository.findByPersonalCode(personalCode).get();
            session.getTransaction().commit();
            session.close();
            return foundEntity;
        } catch (Exception e) {
            throw new NotFoundException(String.format("entity with %s not found", personalCode));
        }
    }
}
