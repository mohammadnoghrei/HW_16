package madsilver.service;

import madsilver.base.service.BaseServiceImpl;
import madsilver.model.Clerk;
import madsilver.model.Student;
import madsilver.repository.ClerkRepository;
import madsilver.repository.StudentRepository;
import org.hibernate.SessionFactory;

public class StudentServiceImpl extends BaseServiceImpl<Student,Long, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return false;
    }

    @Override
    public double averageRate(long id) {
       double x =0;
        try {
            x=repository.averageRate(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return x;
    }
}
