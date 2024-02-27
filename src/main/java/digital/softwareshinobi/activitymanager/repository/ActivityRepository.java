package digital.softwareshinobi.activitymanager.repository;

import digital.softwareshinobi.activitymanager.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    Optional<Activity> findByIdAllIgnoreCase(Integer id);

}