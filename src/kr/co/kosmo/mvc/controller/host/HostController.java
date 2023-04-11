package kr.co.kosmo.mvc.controller.host;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.BookService;
import kr.co.kosmo.mvc.dao.HostDaoInter;
import kr.co.kosmo.mvc.vo.BookLoggerDTO;
import kr.co.kosmo.mvc.vo.BookVO;
import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.MemberVO;

@Controller
@RequestMapping(value = "/host")
public class HostController {
	@Autowired
	private HostDaoInter hostdao;

	@Autowired
	private BookService booksvc;

//========================================================================
	// 회원가입 : signupForm으로 이동
	@GetMapping(value = "/hostSignup")
	public String hostsignUpForm() {
		return "host/hostSignup";
	}

	// 회원가입 : Form에서 작성한 데이터 저장 => 메인으로 이동
	// 등록버튼 누르면 디비에 데이터가 담기다.
	@PostMapping(value = "/hsignUpProcess")
	public String hsignUpProcess(HostVO vo) {
		hostdao.addHost(vo);
		return "redirect:/main";
	}

//========================================================================
	// 호스트페이지
	@GetMapping(value = "/hostpage")
	public ModelAndView hostpage(String hid) {
		ModelAndView mav = new ModelAndView("host/hostpage");
		HostVO hvo = hostdao.hostpage(hid);
		mav.addObject("hvo", hvo);

		return mav;
	}

//========================================================================
	// 회원 수정
	@GetMapping(value = "/uphostForm")
	public ModelAndView uphostForm() {
		ModelAndView mav = new ModelAndView("host/uphostForm");
		return mav;
	}

	@PostMapping(value = "/hostupdate")
	public String hostupdate(HostVO vo) {
		hostdao.hostupdate(vo);
		return "redirect:/main";
	}

//========================================================================
	// 회원탈퇴 : 회원삭제 및 main으로 이동
	@GetMapping(value = "/delhost")
	public String upmemForm(String hid, HttpSession session) {
		hostdao.delHost(hid);
		// 저장된 세션 삭제
		session.removeAttribute("sessionHNum");
		session.removeAttribute("sessionHID");
		session.removeAttribute("sessionHName");
		return "redirect:/main";
	}

//========================================================================
	// 호스트 ManageMent : 예약상태 수정
	@PostMapping(value = "/updateBookHost")
	public String updateBookHost(BookVO bookvo,HttpServletRequest request) {
		booksvc.updateBookHost(bookvo);
		// HttpServletRequest reqeust referer = 이전 페이지로 돌아가기
		String referer = request.getHeader("Referer");
		// 경로를 이전 페이지로 연동해주기
		return "redirect:" + referer;
	}

	// 호스트 ManageMent 1-1 : 예약관리(예약 리스트) => 예약대기
	@GetMapping(value = "/hostBookList")
	public ModelAndView hostBookList(String bstatus,HttpSession session) {
		ModelAndView mav = new ModelAndView("book/hostManageyBook");
		HostVO vo = new HostVO();
		int hno = (int) session.getAttribute("sessionHNum");
		vo.setBstatus(bstatus);
		vo.setHno(hno);
		List<LocalVO> locallist = booksvc.hostBookList(vo);

		mav.addObject("locallist", locallist);

		return mav;
	}

	// 호스트 ManageMent : 예약 수정/취소 요청(예약 리스트)
	@GetMapping(value = "/hostUpBookList")
	public ModelAndView hostUpBookList(String bstatus,HttpSession session) {
		ModelAndView mav = new ModelAndView("book/hostManageyUpBook");
		HostVO vo = new HostVO();
		int hno = (int) session.getAttribute("sessionHNum");
		vo.setBstatus(bstatus);
		vo.setHno(hno);
		List<LocalVO> locallist = booksvc.hostBookList(vo);

		mav.addObject("locallist", locallist);

		return mav;
	}
	// 호스트 ManageMent : 예약 수정/취소 요청(예약 리스트)
	@GetMapping(value = "/hostDelBookList")
	public ModelAndView hostDelBookList() {
		ModelAndView mav = new ModelAndView("book/hostManageyDelBook");
		List<BookLoggerDTO> dellist = booksvc.hostBookDelList();
		mav.addObject("locallist", dellist);

		return mav;
	}
	
//========================================================================

}