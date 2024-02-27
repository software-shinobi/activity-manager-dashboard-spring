package digital.softwareshinobi.activitymanager.controller;

import digital.softwareshinobi.activitymanager.model.Activity;
import digital.softwareshinobi.activitymanager.service.ActivityService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ActivityController {

    @Autowired
    ActivityService activityTaskService;

    public ActivityController() {

        System.out.println("we started from the bottom, now we here");

    }

    @Autowired
    public ActivityController(ActivityService activityTaskService) {

        this.activityTaskService = activityTaskService;

    }

    @GetMapping("/")
    public String displayHomeScreen(Model model, HttpServletRequest request) {

        System.out.println("enter > displayHomeScreen");

        List<Activity> activityTaskList = activityTaskService.getAllActivityTasks();

        System.out.println("the list of activity task:");

        System.out.println(activityTaskList);

        model.addAttribute("activityTaskList", activityTaskList);

        model.addAttribute("activityTask", new Activity());

        System.out.println("exit > displayHomeScreen");

        return "index";

    }

    @PostMapping("/save-new-activity")
    public String saveNewActivityTask(@ModelAttribute Activity activityTask, Model model) {

        System.out.println(">> save-new-activity " + activityTask);

        System.out.println("in:  " + activityTask);

        Activity activityTask1 = this.activityTaskService.saveActivityTask(activityTask);

        System.out.println("out: " + activityTask1);

        if (activityTask1 == null) {

            model.addAttribute("error", "something went wrong saving new activity");

            System.out.println("something went wrong saving new activity");

        } else {

            model.addAttribute("toast", "new activity '$$' added".replace("##", activityTask.getDescription()));

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
