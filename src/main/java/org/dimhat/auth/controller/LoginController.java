package org.dimhat.auth.controller;

import org.dimhat.auth.Constants;
import org.dimhat.auth.controller.form.LoginForm;
import org.dimhat.auth.exception.user.PasswordErrorException;
import org.dimhat.auth.exception.user.UserFreezeException;
import org.dimhat.auth.exception.user.UserNotFindException;
import org.dimhat.auth.service.CompanyService;
import org.dimhat.auth.service.dto.CompanyDTO;
import org.dimhat.auth.web.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author : zwj
 * @data : 2017/3/3
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String login(Model model, LoginForm form){
        model.addAttribute("form",form);
        return "/login";
    }

    @RequestMapping(value="",method = RequestMethod.POST)
    public String doLogin(Model model, @Validated LoginForm form, Errors errors, RedirectAttributes ra, HttpSession session){
        if(errors.hasErrors()){
            ra.addFlashAttribute(Constants.MSG,errors.getFieldError().getDefaultMessage());
            return login(model,form);
        }
        if(form.getUsername().indexOf(Constants.USERNAME_SPLIT)!=-1){//company login
            CompanyDTO companyDTO = null;
            try {
                companyDTO = companyService.login(form.getUsername(), form.getPassword());
            } catch (UserNotFindException e) {
                ra.addFlashAttribute(Constants.CODE,-1);
                ra.addFlashAttribute(Constants.MSG,"账户名不存在");
            } catch (PasswordErrorException e) {
                ra.addFlashAttribute(Constants.CODE,-2);
                ra.addFlashAttribute(Constants.MSG,"密码错误");
            } catch (UserFreezeException e) {
                ra.addFlashAttribute(Constants.CODE,-3);
                ra.addFlashAttribute(Constants.MSG,"账户已被冻结");
            }
            session.setAttribute("userInfo",buildUserInfo(companyDTO));
        }else{//employee login

        }
        return "";
    }

    private UserInfo buildUserInfo(CompanyDTO company){
        UserInfo userInfo = new UserInfo();
        userInfo.setCompanyId(company.getId());
        userInfo.setCompanyName(company.getName());
        userInfo.setCompanyUsername(company.getUsername());
        userInfo.setCompanyType(company.getType());

        return userInfo;
    }
}
