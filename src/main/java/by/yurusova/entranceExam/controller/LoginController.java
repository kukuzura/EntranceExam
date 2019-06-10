package by.yurusova.entranceExam.controller;


import by.yurusova.entranceExam.service.SecurityService;
import by.yurusova.entranceExam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Autowired
    SecurityService securityService;

    @Autowired
    @Resource(name = "userValidator")
    Validator validator;

    Logger logger = LoggerFactory
            .getLogger(RegistrationController.class);

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
}
