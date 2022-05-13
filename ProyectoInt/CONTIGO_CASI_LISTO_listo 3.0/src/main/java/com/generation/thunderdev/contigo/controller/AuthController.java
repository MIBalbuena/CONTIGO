package com.generation.thunderdev.contigo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController implements ErrorController{
	
    private final static String PATH = "/error";
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return "No Mapping Found";
    }

    @RequestMapping("/")
    public String index() {
    			 
		 return "redirect:/red_social/publicacionesComunidad";
        
    }
    
    
    @RequestMapping("/red_social/publicacionesComunidad")
    public ModelAndView publicacionesComunidad() {
    	 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("red_social/publicacionesComunidad");
		 return modelAndView;
        
    }
    

    @GetMapping("/login")
    public ModelAndView login() {
    	 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("login");
		 return modelAndView;
         
    }

    @PostMapping("/login")
    public String loginPost() {
        return "redirect:/login-error";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @RequestMapping("/calendar")
    public String top() {
        return "/index";
    }
    
    
    @RequestMapping("/red_social/publicacionUser")
    public ModelAndView publicacionUser() {
    	 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("red_social/publicacionUser");
		 return modelAndView;
        
    }
    
    @RequestMapping("/index1")
    public ModelAndView PaginaDeInicio() {
    	 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("index1");
		 return modelAndView;
        
    }
    
    @RequestMapping("/contactanos")
    public ModelAndView contactanos() {
    	 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("contactanos");
		 return modelAndView;
        
    }
    

    
    
    

    @RequestMapping("/quienes_somos")
    public ModelAndView quienes_somos() {
    	 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("quienes_somos");
		 return modelAndView;
        
    }
    
    @RequestMapping("/red_social/recursos")
    public ModelAndView recursos() {
    	 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("red_social/recursos");
		 return modelAndView;
        
    }
    
   
    
    @RequestMapping("/red_social/articulo")
    public ModelAndView articulo() {
    	 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("red_social/articulo");
		 return modelAndView;
        
    }
    
    @RequestMapping("/registro")
    public ModelAndView registro() {
    	 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("registro");
		 return modelAndView;
        
    }
    
    

    
         
    

}