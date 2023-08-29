package online.softwareshinobi.activitymanagerdashboard.service;

import jakarta.transaction.Transactional;
import online.softwareshinobi.activitymanagerdashboard.model.ActivityTask;
import online.softwareshinobi.activitymanagerdashboard.repository.ActivityTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional(rollbackOn = SQLException.class)
public class ActivityTaskService {

    ActivityTaskRepository activityTaskRepository;

    @Autowired
    public ActivityTaskService(ActivityTaskRepository activityTaskRepository) {
        this.activityTaskRepository = activityTaskRepository;
    }

    public ActivityTask saveActivityTask(ActivityTask activityTask) {
        return this.activityTaskRepository.save(activityTask);
    }

    public List<ActivityTask> getAllActivityTasks() {
        return this.activityTaskRepository.findAll();
    }

    public void delete(Integer id) {
        this.activityTaskRepository.deleteById(id);
    }

}