package madsilver.service;

import madsilver.base.service.BaseService;
import madsilver.model.Clerk;

public interface ClerkService extends BaseService<Clerk,Long> {
    boolean isExistsByUsername(String username);
}
