package kr.co.kosmo.mvc.controller.diary;

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

import kr.co.kosmo.mvc.dao.DiaryDaoInter;
import kr.co.kosmo.mvc.vo.DiaryVO;

@Controller
@RequestMapping(value = "/diary")
public class DiaryController {
	@Autowired
	private DiaryDaoInter diaryDaoInter;

	// =================================================
	// ====================경로==========================

	// 다이어리 폼
	@GetMapping(value = "/diaryForm")
	public String diaryPath() {
		return "diary/diaryForm";
	}

	@GetMapping(value = "/photo")
	public String photo() {
		return "diary/photo";
	}

	// =================================================
	// ===================업로드==========================

	@PostMapping(value = "/addDiary")
	public String addDiary(DiaryVO vo, HttpServletRequest request) {
		// request를 가지고 이미지의 경로 받아 출력
		String img_path = "resources\\imgfile";
		String r_path = request.getRealPath("/");
		System.out.println("r_path: " + r_path);

		// 업로드된 이미지의 이름을 받아 이미지 복사, 이미지 이름 확인
		String oriFn = vo.getMfile().getOriginalFilename();
		System.out.println("oriFn: " + oriFn);

		// 이미지 사이즈 및 contentType 확인
		long size = vo.getMfile().getSize();
		// img파일만 받고 싶을 경우 등, 파일을 제어하고싶을 때 if문 써서 사용!
		String contentType = vo.getMfile().getContentType();
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
			vo.getMfile().transferTo(f); // 복사
			vo.setDimg(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		diaryDaoInter.addDiary(vo);

		return "redirect:diaryList?dwriter=" + vo.getDwriter();
	}

	// =================================================
	// ===================리스트==========================
	@RequestMapping(value = "/diaryList")
	public String diaryList(Model m, String dwriter) {
		List<DiaryVO> list = diaryDaoInter.listDiary(dwriter);
		m.addAttribute("list", list);
		return "diary/diaryList";
	}

	// =================================================
	// ===================디테일==========================
	@RequestMapping(value = "/diaryDetail")
	public String updateDetail(Model m, int num) {
		DiaryVO vo = diaryDaoInter.detailDiary(num);
		m.addAttribute("vo", vo);
		return "diary/diaryDetail";
	}

	// =================================================
	// =====================수정==========================
	@RequestMapping(value = "/updatePath")
	public String updatePath(Model m, int num) {
		DiaryVO vo = diaryDaoInter.detailDiary(num);
		m.addAttribute("vo", vo);
		return "diary/diaryUpdate";
	}

	@PostMapping(value = "/updateDiary")
	public String updateDiary(Model m, DiaryVO vo, HttpServletRequest request) {
		String img_path = "resources\\imgfile";
		String r_path = request.getRealPath("/");
		System.out.println("r_path: " + r_path);

		// 업로드된 이미지의 이름을 받아 이미지 복사, 이미지 이름 확인
		String oriFn = vo.getMfile().getOriginalFilename();
		System.out.println("oriFn: " + oriFn);

		// 이미지 사이즈 및 contentType 확인
		long size = vo.getMfile().getSize();
		// img파일만 받고 싶을 경우 등, 파일을 제어하고싶을 때 if문 써서 사용!
		String contentType = vo.getMfile().getContentType();
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
			vo.getMfile().transferTo(f); // 복사
			vo.setDimg(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		diaryDaoInter.updateDiary(vo);
		return "redirect:diaryList?dwriter=" + vo.getDwriter();

	}

	// =================================================
	// =====================삭제==========================
	@RequestMapping(value = "/deleteDiary")
	public String deleteDiary(int num) {
		diaryDaoInter.deleteDiary(num);
		return "diary/deleteImg";
		// delete에서는 도저히 안 넘어가서 걍 다른 jsp파일 사이에 끼고 파라미터값 넘김 흙흙..
	}
}
