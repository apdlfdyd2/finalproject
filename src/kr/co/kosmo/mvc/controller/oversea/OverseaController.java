package kr.co.kosmo.mvc.controller.oversea;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.OverseaDaoInter;
import kr.co.kosmo.mvc.dao.ReviewDaoInter;
import kr.co.kosmo.mvc.vo.OverseaVO;
import kr.co.kosmo.mvc.vo.ReviewVO;

@Controller
@RequestMapping(value = "/oversea")
public class OverseaController {
	@Autowired
	private OverseaDaoInter overseadaointer;
	@Autowired
	private ReviewDaoInter reviewDaoInter;
	
	//해외여행 view로 이동
	@GetMapping(value = "/overseatrip")
	public ModelAndView overseatrip() {
		ModelAndView mav = new ModelAndView("overseatrip/overseatrip");
		return mav;
	}
	//insert할 때 사용 할 form으로 이동하는 메서드
	@GetMapping(value = "/overseaUpForm")
	public ModelAndView overseaUpForm() {
		ModelAndView mav = new ModelAndView("overseatrip/overseaUpForm");
		return mav;
	}
	//form에서 insert할때 사용하는 메서드
	@PostMapping(value = "/overseaUpProcess")
	public String overseaUpProcess(Model m, OverseaVO dto, HttpServletRequest request) {
		//request를 가지고 이미지의 경로를 받아 출력
		String img_path = "resources\\imgfile";
		String r_path = request.getRealPath("/");
		System.out.println("r path : " + r_path);
		String oriFn = dto.getMfile().getOriginalFilename();
		System.out.println("oriFn: " + oriFn);

		// 이미지 사이즈 및 contentType 확인
		long size = dto.getMfile().getSize();
		// img파일만 받고 싶을 경우 등, 파일을 제어하고싶을 때 if문 써서 사용!
		String contentType = dto.getMfile().getContentType();
		System.out.println("파일크기:" + size);
		System.out.println("파일크기 type: " + contentType);
		
		// 메모리상(임시저장소)에 파일을 우리가 설정한 경로에 복사!
				// 이미지가 저장될 경로 만들기
				StringBuffer path = new StringBuffer();
				path.append(r_path).append(img_path).append("\\");
				path.append(oriFn);
				System.out.println("FullPath: " + path);
				File f = new File(path.toString());
				try {
					dto.getMfile().transferTo(f); // 복사
					// 이미지 이름을 db에 저장하기 위해 DTO값을 재설정 => 해당값 DB에 넣기!
					dto.setOimg(oriFn);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				overseadaointer.addOversea(dto);
				return "redirect:overseaboardList";

	}
	@RequestMapping("/overseadetail")
	public String localdetail(Model m, int num) {
		OverseaVO vo = overseadaointer.detailOver(num);
		m.addAttribute("vo", vo);

		// Review : 댓글기능 추가==========================
		ReviewVO rvo = new ReviewVO();
		rvo.setListchk(1); //리스트 출력방식 선택
		rvo.setRecode(num); //국내여행 pk 전달
		
		List<ReviewVO> listReview = reviewDaoInter.listReview(rvo);
		m.addAttribute("listReview", listReview);
		// ============================================
        
		return "overseatrip/overseaDetail";
	}

//============================================================================	
	@RequestMapping("/overseadelete")
	public String overseadelete(int num) {
		overseadaointer.delOver(num);
		return "redirect:overseaboardList";
	}

//============================================================================	
	@GetMapping("/overseamodifyForm")
	public String overseamodifyForm(Model m, int num) {
		OverseaVO vo = overseadaointer.detailOver(num);
		m.addAttribute("vo", vo);
		return "overseatrip/overseamodify";
	}

	@PostMapping("/overseamodify")
	public String overseamodify(Model m, OverseaVO dto, HttpServletRequest request) {

		String img_path = "resources\\imgfile";
		String r_path = request.getRealPath("/");
		System.out.println("r_path: " + r_path);

		// 업로드된 이미지의 이름을 받아 이미지 복사, 이미지 이름 확인
		String oriFn = dto.getMfile().getOriginalFilename();
		System.out.println("oriFn: " + oriFn);

		// 이미지 사이즈 및 contentType 확인
		long size = dto.getMfile().getSize();
		// img파일만 받고 싶을 경우 등, 파일을 제어하고싶을 때 if문 써서 사용!
		String contentType = dto.getMfile().getContentType();
		System.out.println("파일크기:" + size);
		System.out.println("파일크기 type: " + contentType);

		// 메모리상(임시저장소)에 파일을 우리가 설정한 경로에 복사!
		// 이미지가 저장될 경로 만들기
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("FullPath: " + path);

		// 추상경로(이미지를 저장할 경로) 객체 생성
		File f = new File(path.toString());
		// 임시메모리에 담긴 업로드한 파일의 값 => file클래스의 경로로 복사
		try {
			dto.getMfile().transferTo(f); // 복사
			// 이미지 이름을 db에 저장하기 위해 DTO값을 재설정 => 해당값 DB에 넣기!
			dto.setOimg(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		overseadaointer.overseamodify(dto);

		return "redirect:overseaboardList";
	}

//============================================================================	
	// =================댓글 추가하기========================
	@RequestMapping(value = "/addReview")
	public String addReview(Model m, ReviewVO vo) {
		reviewDaoInter.addReview(vo);
		return "redirect:overseaboardList";
	}
	@RequestMapping("/overseaboardList")
	public String overseaboardList(Model model) {
		List<OverseaVO> list = overseadaointer.getList();
		model.addAttribute("list", list);

		return "overseatrip/overseaboardList";
	}
	
}