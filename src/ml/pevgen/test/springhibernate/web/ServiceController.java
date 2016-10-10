package ml.pevgen.test.springhibernate.web;

import ml.pevgen.test.springhibernate.domain.Splmt;
import ml.pevgen.test.springhibernate.service.SplmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16.09.2016.
 */
@RestController
public class ServiceController {

//    @RequestMapping("/")
//    public String welcome() {//Welcome page, non-rest
//        return "Welcome to RestTemplate Example.";
//    }

    @Autowired
    private SplmtService splmtService;

    @RequestMapping(path = "/getSupplements", method = RequestMethod.GET)
    public List<Splmt> message() {//REST Endpoint.
        return splmtService.getPlainList();
    }




}
