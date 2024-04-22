package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Clerk;
import madsilver.model.Information;
import madsilver.model.Lesson;
import madsilver.repository.ClerkRepository;
import madsilver.repository.InformationRepository;
import madsilver.repository.InformationRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class InformationServiceImpl extends BaseServiceImpl<Information,Long, InformationRepository> implements InformationService{
    public InformationServiceImpl(InformationRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
//   SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
//    InformationRepositoryImpl informationRepository=new InformationRepositoryImpl(sessionFactory);


    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    @Override
    public void rated(long student, long lesson, double rate,long professor) {

//todo test1

//        try (Session session = sessionFactory.getCurrentSession()) {
//
//            informationRepository.rated(student,lesson,rate, professor);
//
////            return t;
//        } catch (Exception e) {
////            System.out.println("lesson or student is not found please enter correct id");
////            return null;
//            System.out.println(e.getMessage());


//        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
//            transaction = session.beginTransaction();
            repository.rated(student,lesson,rate, professor);
//            transaction.commit();
//            return
        } catch (Exception e) {
            e.getMessage();
//            assert transaction != null;
//            transaction.rollback();
//            return null;
    }

    }

    @Override
    public List<Lesson> findStudentLesson(long id) {

        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            List<Lesson> lessonList= repository.findStudentLesson(id);
            transaction.commit();
            return lessonList;
        } catch (Exception e) {
            e.getMessage();
            assert transaction != null;
            transaction.rollback();
            return null;
        }

//        return repository.findStudentLesson(id);
    }

    @Override
    public List<Lesson> findStudentNewLesson(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            List<Lesson> lessonList= repository.findStudentNewLesson(id);
            transaction.commit();
            return lessonList;
        } catch (Exception e) {
            e.getMessage();
            assert transaction != null;
            transaction.rollback();
            return null;
        }
//        return repository.findStudentNewLesson(id);
    }
}
