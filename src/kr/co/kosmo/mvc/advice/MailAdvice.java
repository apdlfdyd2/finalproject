package kr.co.kosmo.mvc.advice;

import javax.mail.internet.MimeMessage;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import kr.co.kosmo.mvc.dao.SendMailDaoInter;
import kr.co.kosmo.mvc.vo.SendMailVO;

@Component
@Aspect
public class MailAdvice {
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private SendMailDaoInter sendmaildao;

	@AfterReturning("execution(* kr.co.kosmo.mvc.controller.book.Book*.bookProcess(..))")
	public void reserveSendMail() {
		//====메일전송 시작=====
		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				SendMailVO vo = (SendMailVO) sendmaildao.reservemail();
				System.out.println("======AOPTest하는곳 시작!===========");
				System.out.println(vo.getChpay());
				System.out.println(vo.getSdate());
				System.out.println(vo.getEdate());
				System.out.println(vo.getMemail());
				System.out.println("=======AOPTest하는곳 끝!===========");
				String text="날짜 : "+vo.getSdate()+"~"+vo.getEdate()+"\n 예약금액 : "+vo.getChpay()+"원";
				
				mimeMsgHelperObj.setTo(vo.getMemail());
				mimeMsgHelperObj.setFrom("myspring1004@naver.com");
				mimeMsgHelperObj.setText(text);
				mimeMsgHelperObj.setSubject("예약성공");
				
			}
		});
		//====메일전송 끝=====
		System.out.println("\n 메일 전송 성공 \n");
	}
}
