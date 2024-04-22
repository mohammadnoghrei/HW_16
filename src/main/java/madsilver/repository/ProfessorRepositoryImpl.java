package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Lesson;
import madsilver.model.Professor;
import madsilver.util.ApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProfessorRepositoryImpl extends BaseRepositoryImpl<Professor,Long> implements ProfessorRepository{
    public ProfessorRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Professor> getEntityClass() {
        return Professor.class;
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    @Override
    public long professorUnitsSum(long id,int term) {
        Session session = SessionFactorySingleton.getInstance().openSession();
        Professor professor = ApplicationContext.getProfessorService().findById(id);

//        professor.setId(5l);

//        Transaction transaction=session.beginTransaction();
//        String sumHql = "SELECT SUM(unit) FROM Lesson WHERE professor=:p ";
//        Query sumQuery = session.createQuery(sumHql);
//        sumQuery.setParameter("p", professor);
//        System.out.println(sumQuery.list().size()+"        size");
//        System.out.println(sumQuery.list().get(0)+"     xxxxx");
//
//        return (int) sumQuery.list().get(0);

        Query sumQuery= session.createQuery("select sum (unit) from Lesson  where professor=:p and term=:t",Long.class);
        sumQuery.setParameter("p", professor);
        sumQuery.setParameter("t", term);

        return (long) sumQuery.getSingleResult();
    }
}
