package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.connection.SessionFactorySingleton;
import madsilver.model.Lesson;
import madsilver.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student,Long> implements StudentRepository{
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    @Override
    public double averageRate(long id) {
        Student student1 = new Student();
        student1.setId(id);
        Session session = SessionFactorySingleton.getInstance().openSession();
        String sumHql = "SELECT avg (rate) FROM Information WHERE student=:s AND rate!=0 ";
        Query avgQuery = session.createQuery(sumHql);
        avgQuery.setParameter("s", student1);
        double studentRateAVG = (double) avgQuery.list().get(0);
        return (studentRateAVG);
    }
}
