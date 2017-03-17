package org.dimhat.usercenter.controller;

import org.dimhat.usercenter.controller.form.RegisterForm;
import org.dimhat.usercenter.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author : zwj
 * @data : 2017/3/1
 */
@Controller
@RequestMapping("/")
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    private CompanyService companyService;

    public RegisterController() {
        logger.debug("controller is being creadted!!!");
        logger.info("controller is being creadted!!!");
        logger.error("controller is being creadted!!!");
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(Model model,RegisterForm form){
        model.addAttribute("form",form);
        return "register";
    }

    @RequestMapping(value="register",method = RequestMethod.POST)
    public String doRegister(@Validated RegisterForm form, Errors errors, Model model, RedirectAttributes ra){
        if(errors.hasErrors()){
            ra.addFlashAttribute("error",errors.getFieldError().getDefaultMessage());
            return register(model,form);
        }
        Long companyId = companyService.register(form.getUsername(),form.getEmail(),form.getPassword(),form.getType());
        logger.info("register success! username:{},type:{},companyId:{}",form.getUsername(),form.getType(),companyId);
        return "redirect:/login";
    }


}
