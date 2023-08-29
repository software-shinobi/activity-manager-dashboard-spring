package online.softwareshinobi.activitymanagerdashboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import online.softwareshinobi.activitymanagerdashboard.model.ActivityTask;
import online.softwareshinobi.activitymanagerdashboard.service.ActivityTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class ActivityTaskController {

    @Autowired
    ActivityTaskService activityTaskService;

    public ActivityTaskController() {

        System.out.println("we started from the bottom, now we here");

    }

    @Autowired
    public ActivityTaskController(ActivityTaskService activityTaskService) {

        this.activityTaskService = activityTaskService;

    }

    @GetMapping("/")
    public String displayHomeScreen(Model model, HttpServletRequest request) {

        System.out.println("enter > displayHomeScreen");

        List<ActivityTask> activityTaskList = activityTaskService.getAllActivityTasks();

        System.out.println("the list of activity task:");

        System.out.println(activityTaskList);

        model.addAttribute("activityTaskList", activityTaskList);

        model.addAttribute("activityTask", new ActivityTask());

        System.out.println("exit > displayHomeScreen");

        return "index";

    }

    @PostMapping("/save-new-activity")
    public String saveNewActivityTask(@ModelAttribute ActivityTask activityTask, Model model) {

        System.out.println(">> save-new-activity " + activityTask);

        System.out.println("in:  " + activityTask);

        ActivityTask activityTask1 = this.activityTaskService.saveActivityTask(activityTask);

        System.out.println("out: " + activityTask1);

        if (activityTask1 == null) {

            model.addAttribute("error", "something went wrong saving new activity");

            System.out.println("something went wrong saving new activity");

        } else {

            model.addAttribute("toast", "new activity '$$' added".replace("##",activityTask.getDescription()));

        }

        displayHomeScreen(model, null);

        return "index";

    }

    @GetMapping("/delete-activity")
    public String delete(@RequestParam Integer id, Model model, HttpServletRequest request) {

        this.activityTaskService.delete(id);

        displayHomeScreen(model, null);

        return "index";

    }
}

