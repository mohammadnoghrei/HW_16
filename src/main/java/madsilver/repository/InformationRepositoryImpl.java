package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Clerk;
import madsilver.model.Information;
import madsilver.model.Lesson;
import madsilver.model.Student;
import madsilver.util.ApplicationContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class InformationRepositoryImpl extends BaseRepositoryImpl<Information, Long> implements InformationRepository {
    public InformationRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    //    private SessionFactory sessionFactory;
    @Override
    public Class<Information> getEntityClass() {
        return Information.class;
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    @Override
    public void rated(long student, long lesson, double rate, long professor) {
        Student student1 = new Student();
        student1.setId(student);

        Lesson lesson1 = new Lesson();
        lesson1.setId(lesson);

        Session session = SessionFactorySingleton.getInstance().openSession();
        Query<Information> query = session.createQuery("FROM Information i WHERE i.student = :student AND i.lesson = :lesson AND i.rate =0 ", Information.class);
        query.setParameter("student", student1);
        query.setParameter("lesson", lesson1);
        Information information = query.uniqueResult();
        if (information.getLesson().getProfessor().getId() == professor) {
            information.setRate(rate);
            if (ApplicationContext.getInformationService().validate(information)){
            ApplicationContext.getInformationService().saveOrUpdate(information);}
        }
        session.close();
    }

    @Override
    public List<Lesson> findStudentLesson(long id) {
        Student student=new Student();
        student.setId(id);
        Session session=SessionFactorySingleton.getInstance().getCurrentSession();
//                Transaction transaction = session.beginTransaction();
        Query<Lesson> query = session.createQuery("select lesson FROM Information i WHERE i.student = :student ", Lesson.class);
        query.setParameter("student",student);
        List<Lesson> lessonList=query.list();
//        transaction.commit();
//        session.close();
        return lessonList;
    }

    @Override
    public List<Lesson> findStudentNewLesson(long id) {
        Student student=new Student();
        student.setId(id);
        Session session=SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Lesson> query = session.createQuery("select lesson FROM Information i WHERE i.student = :student and rate=0 ", Lesson.class);
        query.setParameter("student",student);
        List<Lesson> lessonList=query.list();
        return lessonList;
    }


}
