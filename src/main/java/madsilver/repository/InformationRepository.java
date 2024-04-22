package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Information;
import madsilver.model.Lesson;

import java.util.List;

public interface InformationRepository extends BaseRepository<Information, Long> {
    boolean isExistsByUsername(String username);
    void rated(long student , long lesson ,double rate,long professor);
    List<Lesson> findStudentLesson(long id);
    List<Lesson> findStudentNewLesson(long id);
}
