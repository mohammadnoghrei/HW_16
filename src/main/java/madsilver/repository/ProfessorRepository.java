package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Clerk;
import madsilver.model.Professor;

public interface ProfessorRepository extends BaseRepository<Professor, Long> {
    boolean isExistsByUsername(String username);
    long professorUnitsSum(long id,int term);
}
