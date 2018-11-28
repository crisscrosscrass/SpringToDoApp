package crisscrosscrass.SpringToDoApp.controllers;

import crisscrosscrass.SpringToDoApp.models.Task;
import crisscrosscrass.SpringToDoApp.models.TaskData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String displayHome(Model model){
        model.addAttribute("myTodoList", TaskData.getAll());
        return "SpringToDoApp/index";
    }
    @RequestMapping("/add")
    public String displayAddToDoTask(Model model){
        model.addAttribute(new Task());
        return "SpringToDoApp/add";
    }
    @RequestMapping("/remove")
    public String displayRemoveToDoTask(Model model){
        model.addAttribute("myTodoList",TaskData.getAll());
        return "SpringToDoApp/remove";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String processSaveTaskForList(@ModelAttribute @Valid Task addNewTask,
                                         Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "title");
            return "SpringToDoApp/add";
        }

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
