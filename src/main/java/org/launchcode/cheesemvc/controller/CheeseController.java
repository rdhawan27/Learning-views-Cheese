package org.launchcode.cheesemvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


/**
 * Created by anu on 5/17/2017.
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {
    static ArrayList<String>cheeses = new ArrayList<>();
    @RequestMapping(value="")
     public String index(Model model){

        model.addAttribute("cheeses",cheeses);
        model.addAttribute("title", "My Cheese");
        return "cheese/index";
    }
    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAddCheeseForm(Model model)
    {
        model.addAttribute("title","add cheese");
        return "cheese/add";}
    @RequestMapping(value="add", method= RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName)
    { //String cheeseName = request.getParameter("cheeseName");
        // to be used with HttpServletRequest
        cheeses.add(cheeseName);
        return "redirect:";


    }
}
