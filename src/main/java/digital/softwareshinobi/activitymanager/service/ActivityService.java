package digital.softwareshinobi.activitymanager.service;

import digital.softwareshinobi.activitymanager.model.Activity;
import digital.softwareshinobi.activitymanager.repository.ActivityRepository;
import jakarta.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = SQLException.class)
public class ActivityService {

    ActivityRepository activityTaskRepository;

    @Autowired
    public ActivityService(ActivityRepository activityTaskRepository) {
        this.activityTaskRepository = activityTaskRepository;
    }

    public Activity saveActivityTask(Activity activityTask) {
        return this.activityTaskRepository.save(activityTask);
    }

    public List<Activity> getAllActivityTasks() {
        return this.activityTaskRepository.findAll();
    }

    public void delete(Integer id) {
        this.activityTaskRepository.deleteById(id);
    }

}
