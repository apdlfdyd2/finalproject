package kr.co.kosmo.mvc.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.BookService;
import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.dao.ReviewDaoInter;
import kr.co.kosmo.mvc.vo.BookVO;
import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MembershipVO;
import kr.co.kosmo.mvc.vo.ReviewVO;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	@Autowired
	private MemberDaoInter memberdao;
	
	@Autowired
	private BookService booksvc;

	@Autowired
	private ReviewDaoInter reviewDaoInter;

	//회원가입 : signupForm으로 이동
	@GetMapping(value = "/signUpForm")
	public ModelAndView signUpForm() {
		ModelAndView mav = new ModelAndView("member/signUpForm");
		return mav;
	}
	//회원가입 : Form에서 작성한 데이터 저장  => 메인으로 이동
	@PostMapping(value = "/signUpProcess")
	public String signUpProcess(MemberVO vo) {
		memberdao.addMember(vo);
		return "redirect:/main";
	}
//====================================================
	//마이페이지
	@GetMapping(value = "/mypage")
	public ModelAndView mypage(HttpSession session,int mnum) {
		ModelAndView mav = new ModelAndView("member/mypage");
		//멤버+멤버쉽------------------------------------
		MembershipVO mbsvo = memberdao.memMembership(mnum);
		mav.addObject("mbsvo", mbsvo);
		//나의 리뷰 개수-----------------------------------
		String mid = (String) session.getAttribute("sessionID");
		int rcnt = reviewDaoInter.cntReview(mid);
		mav.addObject("rcnt", rcnt);
		//--------------------------------------------
		return mav;
	}
	//마이페이지 디테일
	@GetMapping(value = "/mypageDetail" , produces = "application/json;charset=utf-8")
	public ModelAndView mypageDetail(int mnum) {
		ModelAndView mav = new ModelAndView("member/mypageDetail");
		//멤버+멤버쉽------------------------------------
		MembershipVO mbsvo = memberdao.memMembership(mnum);
		mav.addObject("mbsvo", mbsvo);
		//--------------------------------------------
		return mav;
	}
	//나의예약리스트
	@GetMapping(value = "/useHistoryList")
	public ModelAndView UseHistoryList(int mnum , int chk) {
		ModelAndView mav;
		//리스트 출력 or 최근이용내역TOP3 출력 선택하기 => listchk 구분
		int listchk = chk;
		BookVO vo = new BookVO();
		vo.setMid(mnum);
		vo.setListchk(listchk);

		//listchk 구분 후 View 각각 다르게 이동
		//System.out.println("listchk : "+listchk);
		if(listchk==1) {
			mav = new ModelAndView("member/useHistoryTop3");			
		}else{
			mav = new ModelAndView("member/useHistoryList");			
		}
		
		//데이터 넣기
		List<BookVO> blist = booksvc.listBook(vo);
		mav.addObject("blist", blist);

		BookVO bvo = booksvc.useHistory(mnum);		
		mav.addObject("bvo", bvo);
		
		return mav;
	}

	//마이페이지 차트
	@GetMapping(value = "/mypageChart")
	public ModelAndView mypageChart(int mnum) {
		ModelAndView mav = new ModelAndView("member/mypageChart");
		//멤버+멤버쉽------------------------------------
		MembershipVO mbsvo = memberdao.memMembership(mnum);
		mav.addObject("mbsvo", mbsvo);
		//--------------------------------------------
		return mav;
	}	
	
	//나의리뷰리스트
	@GetMapping(value = "/myReviewList")
	public ModelAndView myReviewList(String mid) {
		ModelAndView mav = new ModelAndView("member/myReviewList");

		//나의 리뷰 내역
		ReviewVO rvo = new ReviewVO();
		rvo.setListchk(2); //리스트 출력방식 선택
		rvo.setRewriter(mid); //멤버 fk 전달
		
		List<ReviewVO> listReview = reviewDaoInter.listReview(rvo);
		mav.addObject("listReview", listReview);
		
		//나의 리뷰 개수
		int rcnt = reviewDaoInter.cntReview(mid);
		mav.addObject("rcnt", rcnt);
		
		return mav;
	}
	
	
	//마이페이지 내 캘린더
	@GetMapping(value = "/mypageTest")
	public ModelAndView mypageTest() {
		ModelAndView mav = new ModelAndView("member/mypage_Test");
		return mav;
	}
	
	
//====================================================
	//회원수정 : 회원수정Form으로 이동
	@GetMapping(value = "/upmemForm")
	public ModelAndView upmemForm() {
		ModelAndView mav = new ModelAndView("member/upmemForm");
		return mav;
	}
	//회원수정 : 회원수정Form에서 작성한 데이터 저장  => 메인으로 이동
	@PostMapping(value = "/updateProcess")
	public String updateProcess(HttpSession session,MemberVO vo) {
		//수정내용 DB에 전달
		memberdao.upMember(vo);
		
		//저장되었던 세션 삭제
		session.removeAttribute("sessionNum");		
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");

		//수정내용에 따른 새로운 세션 부여
		MemberVO dto = memberdao.login(vo); //세션부여를 위해 해당메서드 불러오기
		session.setAttribute("sessionNum", dto.getMnum());
		session.setAttribute("sessionID", dto.getMid());
		session.setAttribute("sessionName", dto.getMname());

		return "redirect:/main";
	}
//====================================================
	//회원탈퇴 : 회원삭제 및 main으로 이동
	@GetMapping(value = "/delmem")
	public String delMember(int mnum , HttpSession session) {
		memberdao.delMember(mnum);
		//저장된 세션 삭제
		session.removeAttribute("sessionNum");
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");
		return "redirect:/main";
	}
//====================================================
	@GetMapping(value = "/mbti")
	public ModelAndView mbti() {
		ModelAndView mav = new ModelAndView("member/mbti");
		return mav;
	}
}
