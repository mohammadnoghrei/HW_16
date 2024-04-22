package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LessonRepositoryImpl extends BaseRepositoryImpl<Lesson,Long> implements LessonRepository{
    public LessonRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Lesson> getEntityClass() {
        return Lesson.class;
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    public List<Lesson> findAll(){
        Session session = SessionFactorySingleton.getInstance().openSession();
//        Transaction transaction = session.beginTransaction();
        Query<Lesson> queryStudent = session.createQuery("FROM Lesson ", Lesson.class);
        List<Lesson> studentList = queryStudent.list();
//        transaction.commit();
        session.close();
        return studentList;
    }
}
