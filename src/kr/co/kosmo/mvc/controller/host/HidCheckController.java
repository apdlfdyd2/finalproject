package kr.co.kosmo.mvc.controller.host;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.HostDaoInter;
import kr.co.kosmo.mvc.vo.HostVO;

//RestController => json, 값을 커스텀뷰로 전달하는 목적

@RestController
public class HidCheckController {
    @Autowired
    private HostDaoInter hostdao;

    // 반드시 id란 파라미터가 있어야 한다.(체크 대상) 
    @GetMapping(value="/hidcheck")
    public int idCheck(@RequestParam String hid) {
        int cnt = hostdao.hidcheck(hid);
        return cnt;
    }
    @GetMapping(value = "/hloginChk")
    public int hloginChk(HostVO vo) {
    	int chk=hostdao.loginchk(vo);
    	//System.out.println(chk);
    	return chk;
    }
}