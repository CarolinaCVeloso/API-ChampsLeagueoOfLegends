package carolina.sdw24.domain.ports;

import carolina.sdw24.domain.model.Champions;
import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
    List<Champions> findAll();
    Optional<Champions> findById(Long id);
}
