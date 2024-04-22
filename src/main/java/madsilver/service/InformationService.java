package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Clerk;
import madsilver.model.Information;
import madsilver.model.Lesson;

import java.util.List;

public interface InformationService  extends BaseService<Information,Long>{

        boolean isExistsByUsername(String username);

        void rated(long student , long lesson ,double rate,long professor);
        List<Lesson> findStudentLesson(long id);
        List<Lesson> findStudentNewLesson(long id);
}
