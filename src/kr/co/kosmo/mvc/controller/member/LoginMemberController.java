package kr.co.kosmo.mvc.controller.member;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberVO;

@Controller
@RequestMapping(value = "/login")
public class LoginMemberController {
	@Autowired
	private MemberDaoInter memberdao;
	
//========================================================================
	// 카카오톡 로그인 API 적용
	@GetMapping(value = "/kakaoLogin", produces = "application/json;charset=utf-8")
	public ModelAndView kakaoLogin(@RequestParam(value = "code", required = false) String code,HttpSession session) throws Throwable {
		ModelAndView mav;
		// 1번 : 카카오톡에 사용자 코드 받기(jsp의 a태그 href에 경로 있음)
		System.out.println("KaKaoLogin code:" + code);

		// 2번 : 받은 code를 iKakaoS.getAccessToken로 보냄 ###access_Token###로 찍어서 잘 나오면은 다음단계진행
		String access_Token = memberdao.getAccessToken(code);
		System.out.println("###access_Token#### : " + access_Token);
		// 위의 access_Token 받는 걸 확인한 후에 밑에 진행

		// 3번 : 받은 access_Token를 iKakaoS.getUserInfo로 보냄 userInfo받아옴, userInfo에 nickname,email정보가 담겨있음
		HashMap<String, Object> userInfo = memberdao.getUserInfo(access_Token);
		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		System.out.println("###email#### : " + userInfo.get("email"));
		
		//VO에 값 저장-------------------------------------------------
		MemberVO vo = new MemberVO();
		vo.setMname((String) userInfo.get("nickname"));
		vo.setMemail((String) userInfo.get("email"));
		//db와 연동해서 로그인--------------------------------------------
		MemberVO dto = memberdao.kakaologin(vo);
		if (dto == null) { // 로그인 실패
			System.out.println("카카오 로그인실패"); // test용 => 바꾸기
			mav = new ModelAndView("member/signUpForm");
		} else {
			mav = new ModelAndView("main/mainbody");
			session.setAttribute("sessionNum", dto.getMnum());
			session.setAttribute("sessionID", dto.getMid());
			session.setAttribute("sessionName", dto.getMname());
			session.setAttribute("sessionEmail", dto.getMemail());
			System.out.println("sessionEmail=>" + session.getAttribute("sessionEmail"));
		}
		return mav;
	}

//========================================================================
	// 로그인 : loginForm으로 이동
	@GetMapping(value = "/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login/loginForm");
		return mav;
	}

	// 로그인 : Form에서 작성한 데이터로 loginInsert + 세션심기 => Main으로 이동
	@PostMapping(value = "/loginProcess")
	public ModelAndView logProcessIn(HttpSession session, HttpServletRequest request, MemberVO vo,
			@RequestHeader("User-Agent") String userAgent) {
		MemberVO dto = memberdao.login(vo);
		ModelAndView mav;
		if (dto == null) { // 로그인 실패
			mav = new ModelAndView("login/loginForm");
			System.out.println("로그인실패"); // test용 => 바꾸기
		} else {
			mav = new ModelAndView("main/mainbody");
			session.setAttribute("sessionNum", dto.getMnum());
			session.setAttribute("sessionID", dto.getMid());
			session.setAttribute("sessionName", dto.getMname());
			session.setAttribute("sessionEmail", dto.getMemail());
			System.out.println("sessionEmail=>" + session.getAttribute("sessionEmail"));
		}
		return mav;
	}

	// 로그아웃 : 세션지우기 => Main으로 이동
	@GetMapping(value = "/logoutProcess")
	// public ModelAndView logProcessOut(HttpSession session,HttpServletRequest
	// request) {
	public ModelAndView logOutProcess(HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("main/mainbody");
		session.removeAttribute("sessionNum");
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");
		session.removeAttribute("sessionEmail");
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
