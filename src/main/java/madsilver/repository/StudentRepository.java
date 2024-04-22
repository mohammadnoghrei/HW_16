package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Clerk;
import madsilver.model.Student;

public interface StudentRepository extends BaseRepository<Student, Long> {
    boolean isExistsByUsername(String username);
    double averageRate(long id);
}
