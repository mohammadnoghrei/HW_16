package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Professor;


public interface ProfessorService extends BaseService<Professor,Long> {
    boolean isExistsByUsername(String username);
    long professorUnitsSum(long id,int term);
}
