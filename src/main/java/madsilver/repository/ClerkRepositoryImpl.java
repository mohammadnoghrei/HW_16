package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Clerk;
import org.hibernate.SessionFactory;

public class ClerkRepositoryImpl extends BaseRepositoryImpl<Clerk,Long> implements ClerkRepository {
    public ClerkRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Clerk> getEntityClass() {return Clerk.class;}

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }
}
