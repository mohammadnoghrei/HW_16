package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Clerk;
import madsilver.model.Lesson;

import java.util.List;

public interface LessonService extends BaseService<Lesson,Long> {
    boolean isExistsByUsername(String username);
    List<Lesson> findAll();
}
