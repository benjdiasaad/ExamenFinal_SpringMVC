package com.humains.controllers;

import com.humains.entities.Employee;
import com.humains.exceptions.ResourceNotFoundException;
import com.humains.security.SHA1;
import com.humains.services.DepartementService;
import com.humains.services.EmployeeService;
import com.humains.services.RemunerationService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Aspect
//@RequestMapping("/employee")
@RequestMapping(value = {"","/employee"})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartementService departementService;

    @Autowired
    private RemunerationService remunerationService;

    @GetMapping(value = {""})
    public String indexLogin(ModelMap model , Employee user){
        model.addAttribute("user", user);
        return "user/user-login";
    }


    @PostMapping(value = {"/login"})
    public String login(@ModelAttribute("user") Employee user, BindingResult result, ModelMap model , HttpSession session) throws ResourceNotFoundException, Exception {
        if(result.hasErrors()){
            model.addAttribute("user",user);
            System.out.println(result);
            return "user/user-login";
        }
        String hachedPass = SHA1.getSHA1(user.getPassword());

        if(employeeService.findEmployeeByEmailAndPassword(user.getEmail(), hachedPass)){
            System.out.println("Welcome Back");
            session.setAttribute("fullName", employeeService.findEmployeeByEmail(user.getEmail()).getNom()+" " + employeeService.findEmployeeByEmail(user.getEmail()).getPrenom());
            session.setAttribute("role", employeeService.findEmployeeByEmail(user.getEmail()).getRole());
            session.setAttribute("ConnectedUser", employeeService.findEmployeeByEmail(user.getEmail()));
            session.setAttribute("image", employeeService.findEmployeeByEmail(user.getEmail()).getImage());
            return "redirect:/article/";
        }else{
            user.setEmail(null);
            user.setPassword(null);
            System.out.println("Unvailable");
            return "user/user-login";
        }
    }

}
