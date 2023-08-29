package online.softwareshinobi.activitymanagerdashboard.repository;

import online.softwareshinobi.activitymanagerdashboard.model.ActivityTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityTaskRepository extends JpaRepository<ActivityTask, Integer> {

    Optional<ActivityTask> findByIdAllIgnoreCase(Integer id);

}