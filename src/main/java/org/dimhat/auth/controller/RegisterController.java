package org.dimhat.auth.controller;

import org.dimhat.auth.controller.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2017/3/1
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    public RegisterController() {
        logger.debug("controller is being creadted!!!");
        logger.info("controller is being creadted!!!");
        logger.error("controller is being creadted!!!");
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String register(Model model){
        List<UserVO> list = new ArrayList<>();
        list.add(new UserVO("a",1));
        list.add(new UserVO("b",1));
        model.addAttribute("userList",list);
        return "register";
    }
}
