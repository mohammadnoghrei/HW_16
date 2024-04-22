package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Clerk;
import madsilver.model.Lesson;

import java.util.List;

public interface LessonRepository extends BaseRepository<Lesson, Long> {
    boolean isExistsByUsername(String username);
    List<Lesson> findAll();
}
