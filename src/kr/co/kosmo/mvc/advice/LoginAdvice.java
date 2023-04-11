package kr.co.kosmo.mvc.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.LoginLoggerDTO;

@Component // controller가 아닌 일반 빈 생성
@Aspect // AOP_Advice : Around,Before..사용가능
public class LoginAdvice {
	private String userAgent;

	@Autowired
	private MemberDaoInter memberdao;

	@Around("execution(* kr.co.kosmo.mvc.controller.member.Login*.logProcess*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		ModelAndView rpath = null;

		// 1) 메서드의 이름을 가져와 로그인과 로그아웃을 구별한다.
		String methodName = jp.getSignature().getName();
		System.out.println("methodName: " + methodName);

		// 2) JoinPoint로부터 메서드의 타겟 객체의 메서드 인자값 받아오기
		Object[] fd = jp.getArgs();
		
		// 3) 메서드에 따라 로그인/로그아웃 구분
		if (methodName.equals("logProcessIn")) { //3-1) 로그인
			// =======================================
			try {
				rpath = (ModelAndView) jp.proceed(); // 로그인 메서드 호출
				//rpath: ModelAndView: reference to view with name 'main/mainbody'; model is null
			} catch (Throwable e) {
				e.printStackTrace();
			}
			// =======================================
			// getArgs: session_세션에 있는 id, request_ip, DTO_,userAgent_장치 -> 4개
			// session값 가져오기
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionID");
			System.out.println("uid: " + uid);
			// ip값 가져오기 -> localhost에 자신의 ip넣기
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr();
			System.out.println("ip: " + reip);
			// 유저 장치 가져오기 -> userAgent
			userAgent = (String) fd[3];
			System.out.println("agent: " + userAgent);

			// =========위에 설정된 값들을 DB에 넣기(로그인)=============
			LoginLoggerDTO vo = new LoginLoggerDTO();
			vo.setMidn(uid); // 멤버일때
			vo.setStatus("login");
			vo.setReip(reip);
			vo.setUagent(userAgent);
			vo.setRuntime(0);
			memberdao.addLoginLogging(vo);
		} else if (methodName.equals("logProcessOut")) { //3-2) 로그아웃
			// =======================================
			// getArgs: 세션,request(2개)
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionID");
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr();
			// =========위에 설정된 값들을 DB에 넣기(로그아웃)=============
			// 로그인~로그아웃 시간계산-----
			//int runtime = 0;
			// ---------------------			
			LoginLoggerDTO vo = new LoginLoggerDTO();
			vo.setMidn(uid); // 멤버일때
			vo.setStatus("logout");
			vo.setReip(reip);
			vo.setUagent(userAgent);
			//vo.setRuntime(runtime);
			vo.setRuntime(0);
			memberdao.addLoginLogging(vo);
			// =======================================
			try {
				rpath = (ModelAndView) jp.proceed(); // 로그아웃 메서드 호출
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return rpath;
	}

}
