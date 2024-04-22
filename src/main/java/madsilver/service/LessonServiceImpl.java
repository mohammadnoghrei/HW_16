package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Clerk;
import madsilver.model.Lesson;
import madsilver.repository.ClerkRepository;
import madsilver.repository.LessonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class LessonServiceImpl extends BaseServiceImpl<Lesson,Long, LessonRepository> implements LessonService  {
    public LessonServiceImpl(LessonRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    @Override
    public List<Lesson> findAll() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
             List<Lesson> lessonList= repository.findAll();
            transaction.commit();
            return lessonList;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            return null;
        }
    }
}
