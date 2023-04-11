package kr.co.kosmo.mvc.controller.host;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.HostDaoInter;
import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.MemberVO;

@Controller
@RequestMapping(value = "/hlogin")
public class HLoginController {
	@Autowired
	private HostDaoInter hostdao;

//========================================================================
	// 로그인 : loginForm으로 이동
	@GetMapping(value = "/hloginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login/hostLogForm");
		return mav;
	}

	// 로그인 : Form에서 작성한 데이터로 loginInsert + 세션심기 => Main으로 이동
	@PostMapping(value = "/hloginProcess")
	public ModelAndView loginProcess(HttpSession session, HostVO vo) {
		HostVO dto = hostdao.hlogin(vo);
		ModelAndView mav = new ModelAndView("main/hostmainbody");
		if (dto == null) { // 로그인 실패
			System.out.println("로그인실패"); // test용 => 바꾸기
		} else {
			session.setAttribute("sessionHNum", dto.getHno());
			session.setAttribute("sessionHID", dto.getHid());
			session.setAttribute("sessionHName", dto.getHname());
			System.out.println("로그인성공!"); // test용 => 바꾸기
		}
		return mav;
	}

	// 로그아웃 : 세션지우기 => Main으로 이동
	@GetMapping(value = "/hlogoutProcess")
	public ModelAndView logoutProcess(HttpSession session) {
		ModelAndView mav = new ModelAndView("main/mainbody");

		session.removeAttribute("sessionHNum");
		session.removeAttribute("sessionHID");
		session.removeAttribute("sessionHName");
		
		System.out.println("로그아웃!"); // test용 => 바꾸기
		return mav;
	}


//========================================================================
	// ID&PWD찾기 페이지로 이동
	@GetMapping(value = "/idpwdSearch")
	public ModelAndView idpwdSearch() {
		ModelAndView mav = new ModelAndView("login/idpwdSearch");
		return mav;
	}

//========================================================================
	// ID찾기 : idSearchForm으로 이동
	@GetMapping(value = "/idSearch")
	public ModelAndView idSearch() {
		ModelAndView mav = new ModelAndView("login/idSearch");
		return mav;
	}

	// ID찾기 : Form에서 작성한 데이터 검사 및 메일발송/확인
	@PostMapping(value = "/idSearchProcess")
	public ModelAndView idSearchProcess() {
		ModelAndView mav = new ModelAndView("login/idSearchProcess");
		return mav;
	}

//========================================================================
	// PWD찾기 : pwdSearchForm으로 이동
	@GetMapping(value = "/pwdSearch")
	public ModelAndView pwdSearch() {
		ModelAndView mav = new ModelAndView("login/resetForm");
		return mav;
	}

	// PWD찾기 : Form에서 작성한 데이터 검사 및 메일발송
	@PostMapping(value = "/pwdSearchProcess")
	public ModelAndView pwdSearchProcess() {
		ModelAndView mav = new ModelAndView("login/pwdSearchProcess");
		return mav;
	}
	
}