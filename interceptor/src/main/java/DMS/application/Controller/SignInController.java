package DMS.application.Controller;

import DMS.application.Service.Impl.SignInServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

public class SignInController {
    @Autowired
    SignInServiceImpl signInService;

    @ResponseBody
    @PostMapping("v1/signup")
    public int signinrequest(){
        System.out.println("SIGNIN");
        return signInService.authoriseUser();
    }


    }
