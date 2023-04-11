package kr.co.kosmo.mvc.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.kosmo.mvc.controller.service.BookService;
import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.BookLoggerDTO;
import kr.co.kosmo.mvc.vo.BookVO;
import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.MembershipVO;

@Component // controller가 아닌 일반 빈 생성
@Aspect // AOP_Advice : Around,Before..사용가능
public class BookAdvice {

	@Autowired
	private BookService bookdao;

	@Autowired
	private MemberDaoInter memdao;

	@Around("execution(* kr.co.kosmo.mvc.controller.book.Book*.bookProcess*(..))")
	public String bookLogger(ProceedingJoinPoint jp) {
		String rpath = null;

		// 1) 메서드의 이름을 가져와 예약/수정/삭제 구별한다.
		String methodName = jp.getSignature().getName();
		// System.out.println("methodName: " + methodName);

		// 2) JoinPoint로부터 메서드의 타겟 객체의 메서드 인자값 받아오기
		// BookVO bookvo,
		// ChargeMVO chvo,
		// HttpServletRequest request,
		// HttpSession session
		// SendMailVO mailvo...
		Object[] fd = jp.getArgs();

		// 3) 메서드에 따라 예약/수정/삭제 구분에 따른 처리
		if (methodName.equals("bookProcessInsert")) { // 3-1) 예약
			// =======================================
			try {
				rpath = (String) jp.proceed(); // 예약 메서드 호출
			} catch (Throwable e) {
				e.printStackTrace();
			}
			// =======================================
			// [1]BookVO값 가져오기
			// [2]ChargeMVO값 가져오기
			BookVO bookvo = null;
			ChargeMVO chvo = null;
			for (Object arg : fd) {
				if (arg instanceof BookVO) {
					bookvo = (BookVO) arg;
				} else if (arg instanceof ChargeMVO) {
					chvo = (ChargeMVO) arg;
				}
			}
			// [3]HttpServletRequest값 가져오기
			HttpServletRequest request = (HttpServletRequest) fd[3];
			// [0]session값 가져오기
			HttpSession session = (HttpSession) fd[0];
			String mid = (String) session.getAttribute("sessionID");
			// System.out.println("mid: " + mid);

			int bid = 0;
			int pay = 0;
			int spoint = 0;
			int upoint = 0;
			// 결제금액 + 계산된 포인트 값 추출하기
			if (bookvo != null && chvo != null) {
				bid = chvo.getChno(); // bid = chno이므로 시퀀스값 대신 뽑아오기
				pay = chvo.getChpay();
				upoint = chvo.getUsepoint();
				int mnum = (int) request.getSession().getAttribute("sessionNum");
				MembershipVO mbsvo = memdao.mbsPoint(mnum);
				float mbspoint = mbsvo.getMbspoint();
				spoint = (int) (pay * mbspoint);

				// System.out.println("================결제로그(예약)================");
				// System.out.println("bid 값 : " + bid);
				// System.out.println("결제 값 : " + pay);
				// System.out.println("포인트 값 : " + spoint);
				// System.out.println("사용포인트 값 : " + upoint);
			}

			// =========위에 설정된 값들을 DB에 넣기(예약)=============
			BookLoggerDTO vo = new BookLoggerDTO();
			vo.setBid(bid);
			vo.setMid(mid);
			vo.setStatus("예약");
			vo.setPay(pay);
			vo.setSpoint(spoint);
			vo.setUpoint(upoint);
			bookdao.addBookLogging(vo);
		} else if (methodName.equals("bookProcessUpdate")) { // 3-2) 수정
			// =======================================
			try {
				rpath = (String) jp.proceed(); // 예약수정 메서드 호출
			} catch (Throwable e) {
				e.printStackTrace();
			}
			// =======================================
			// [1]BookVO값 가져오기
			// [2]ChargeMVO값 가져오기
			BookVO bookvo = null;
			ChargeMVO chvo = null;
			for (Object arg : fd) {
				if (arg instanceof BookVO) {
					bookvo = (BookVO) arg;
				} else if (arg instanceof ChargeMVO) {
					chvo = (ChargeMVO) arg;
				}
			}
			// [3]HttpServletRequest값 가져오기
			HttpServletRequest request = (HttpServletRequest) fd[3];
			// [0]session값 가져오기
			HttpSession session = (HttpSession) fd[0];
			String mid = (String) session.getAttribute("sessionID");
			// System.out.println("mid: " + mid);

			int bid = 0;
			int pay = 0;
			int spoint = 0;
			int upoint = 0;
			// 수정금액 + 계산된 포인트 값 추출하기
			if (bookvo != null && chvo != null) {
				bid = bookvo.getBid(); // bid = chno이므로 시퀀스값 대신 뽑아오기
				pay = chvo.getChpay();
				upoint = chvo.getUsepoint();
				int mnum = (int) request.getSession().getAttribute("sessionNum");
				MembershipVO mbsvo = memdao.mbsPoint(mnum);
				float mbspoint = mbsvo.getMbspoint();
				spoint = (int) (pay * mbspoint);

				 System.out.println("================결제로그(수정)================");
				 System.out.println("bid 값 : " + bid);
				 System.out.println("결제 값 : " + pay);
				 System.out.println("포인트 값 : " + spoint);
				 System.out.println("사용포인트 값 : " + upoint);
			}

			// =========위에 설정된 값들을 DB에 넣기(수정)=============
			BookLoggerDTO vo = new BookLoggerDTO();
			vo.setBid(bid);
			vo.setMid(mid);
			vo.setStatus("수정");
			vo.setPay(pay);
			vo.setSpoint(spoint);
			vo.setUpoint(upoint);
			bookdao.addBookLogging(vo);
		} else if (methodName.equals("bookProcessDelete")) { // 3-3) 취소
			// =======================================
			try {
				rpath = (String) jp.proceed(); // 취소 메서드 호출
			} catch (Throwable e) {
				e.printStackTrace();
			}
			// =======================================
			// [1]BookVO값 가져오기
			BookVO bookvo = null;
			for (Object arg : fd) {
				if (arg instanceof BookVO) {
					bookvo = (BookVO) arg;
				}
			}
			// bid값 활용하여 기존 최신 기록 가져오기
			BookLoggerDTO booklogvo;
			booklogvo = bookdao.delBookforLog(bookvo.getBid());

			// [0]session값 가져오기
			HttpSession session = (HttpSession) fd[0];
			String mid = (String) session.getAttribute("sessionID");

			// 취소금액 + 계산된 포인트 값 추출하기
			int bid = bookvo.getBid();
			int pay = booklogvo.getPay();
			int spoint = booklogvo.getSpoint();
			int upoint = 0;
			//System.out.println("================결제로그(취소)================");
			//System.out.println("bid 값 : " + bid);
			//System.out.println("결제 값 : " + pay);
			//System.out.println("포인트 값 : " + bpoint);

			// =========위에 설정된 값들을 DB에 넣기(취소)=============
			BookLoggerDTO vo = new BookLoggerDTO();
			vo.setBid(bid);
			vo.setMid(mid);
			vo.setStatus("취소");
			vo.setPay(pay);
			vo.setSpoint(spoint);
			vo.setUpoint(upoint);
			bookdao.addBookLogging(vo);
		}
		return rpath;
	}

}
