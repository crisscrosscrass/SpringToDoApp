package crisscrosscrass.SpringToDoApp.controllers;

import crisscrosscrass.SpringToDoApp.models.Task;
import crisscrosscrass.SpringToDoApp.models.TaskData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String displayHome(Model model){
        model.addAttribute("myTodoList", TaskData.getAll());
        return "SpringToDoApp/index";
    }
    @RequestMapping("/add")
    public String displayAddToDoTask(){
        return "SpringToDoApp/add";
    }
    @RequestMapping("/remove")
    public String displayRemoveToDoTask(Model model){
        model.addAttribute("myTodoList",TaskData.getAll());
        return "SpringToDoApp/remove";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String processSaveTaskForList(@ModelAttribute Task addNewTask){
        TaskData.add(addNewTask);
        return "redirect:/";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String processDeleteTaskFromList(@RequestParam int[] taskIds){
        for (int taskId : taskIds){
            TaskData.remove(taskId);
        }
        return "redirect:/";
    }
}
