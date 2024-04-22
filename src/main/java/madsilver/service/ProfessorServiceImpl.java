package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Clerk;
import madsilver.model.Professor;
import madsilver.repository.ClerkRepository;
import madsilver.repository.ProfessorRepository;
import org.hibernate.SessionFactory;

public class ProfessorServiceImpl extends BaseServiceImpl<Professor,Long, ProfessorRepository> implements ProfessorService {
    public ProfessorServiceImpl(ProfessorRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    @Override
    public long professorUnitsSum(long id,int term) {
//        int x =0;
//        try {
//            x=repository.professorUnitsSum(id);
//        }catch (Exception e){
//            e.printStackTrace();
//        }return x;
    return repository.professorUnitsSum(id,term);
    }
}
