package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

public class PersonRepositoryImpl extends BaseRepositoryImpl<Person,Long> implements PersonRepository {
    public PersonRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    @Override
    public Optional<Person> findByPersonalCode(String personalCode) {
        Session session = SessionFactorySingleton.getInstance().openSession();

        Query query = session.createQuery("FROM Person p WHERE p.personalCode=:personalCode");
        query.setParameter("personalCode", personalCode);
//        session.close();
        return Optional.ofNullable((Person) query.getSingleResult());
    }
}
