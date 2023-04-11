package kr.co.admin.mvc.controller.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import kr.co.admin.mvc.dao.ListDaoInter;

@Controller
@RequestMapping(value = "/list")
public class ListController {
    //@Autowired
    //ListDaoInter dao;

    @GetMapping(value = "/member") // list/member.jsp에 Forward 방식으로 이동
    public String member(String nowPage) {
        return "list/member";
    }
}