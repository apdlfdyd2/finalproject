package kr.co.kosmo.mvc.controller.email;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mail") //위에 쓰일 주소http://localhost/spring2023_0106_Aop_login/mail/sendEmail
public class EmailController {
	static final String emailFromRecipient = "본인메일주소@naver.com";

	@Autowired
	private JavaMailSenderImpl mailSender;

	@GetMapping(value = "/emailForm")
	public String emailForm() {
		return "email/emailForm";//반환할 jsp주소
		
	}
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmailToClient(HttpServletRequest request) {
		String emaiSubject = request.getParameter("subject");
		String emailMessage = request.getParameter("message");
		String emailToRecipient = request.getParameter("mailTo");
		// 메일 전송을 시작하는 메서드에게 데이터를 입력

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setFrom(emailFromRecipient);
				mimeMsgHelperObj.setText(emailMessage);
				mimeMsgHelperObj.setSubject(emaiSubject);

			}
		});
		System.out.println("\n 메일 전송 성공 \n");

		ModelAndView mav = new ModelAndView("success", "messageObj", "메일 전송 성공");
		return mav;
	}

}