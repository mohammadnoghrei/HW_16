package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Clerk;
import madsilver.repository.ClerkRepository;
import org.hibernate.SessionFactory;

public class ClerkServiceImpl extends BaseServiceImpl<Clerk,Long, ClerkRepository> implements ClerkService {
    public ClerkServiceImpl(ClerkRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }
}
