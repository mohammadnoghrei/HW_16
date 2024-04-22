package madsilver.repository;

import madsilver.base.repository.BaseRepository;
import madsilver.model.Clerk;

public interface ClerkRepository extends BaseRepository<Clerk, Long> {
    boolean isExistsByUsername(String username);
}
