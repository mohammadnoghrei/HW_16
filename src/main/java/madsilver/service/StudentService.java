package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Clerk;
import madsilver.model.Student;

public interface StudentService extends BaseService<Student,Long> {
    boolean isExistsByUsername(String username);
    double averageRate(long id);
}
