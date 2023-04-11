package kr.co.kosmo.mvc.controller.localtrip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.LocalService;
import kr.co.kosmo.mvc.dao.LocalDaoInter;
import kr.co.kosmo.mvc.dao.ReviewDaoInter;
import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.ReviewVO;

@Controller
@RequestMapping(value = "/local")
public class LocaltripController {
	@Autowired
	private LocalDaoInter localdaointer;

	@Autowired
	private ReviewDaoInter reviewDaoInter;

	@Autowired
	private LocalService localService;

	// 국내여행 View로 이동
	@GetMapping(value = "/localtrip")
	public ModelAndView localtrip() {
		ModelAndView mav = new ModelAndView("localtrip/localtrip");
		return mav;
	}

//============================================================================
	// insert 할 때 사용할 form으로 이동하는 메서드
	@GetMapping(value = "/localUpForm")
	public ModelAndView localUpForm() {
		ModelAndView mav = new ModelAndView("localtrip/localUpForm");
		return mav;
	}

	// form에서 insert할 때 사용하는 메서드
	@PostMapping(value = "/localUpProcess")
	public String localUpProcess(LocalVO dto, ItemVO itemvo, HttpServletRequest request) {
		// request를 가지고 이미지의 경로 받아 출력
		String img_path = "resources\\imgfile"; // 임시 저장 공간 *
		String r_path = request.getRealPath("");
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
			dto.getMfile().transferTo(f); // 복붙 ***
			// 이미지 이름을 db에 저장하기 위해 DTO값을 재설정 => 해당값 DB에 넣기!
			dto.setLimg(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		// ------------------------ List<ContentVO>
		List<ItemVO> list = new ArrayList<ItemVO>();

		char itype = 'A';
		String[] iname = request.getParameterValues("iname");
		String[] iprice = request.getParameterValues("iprice");
		List<MultipartFile> ifile = new ArrayList<MultipartFile>();
		ifile.add(itemvo.getIfile());
		if (itemvo.getIfile2() != null) {
			ifile.add(itemvo.getIfile2());
		}
		if (itemvo.getIfile3() != null) {
			ifile.add(itemvo.getIfile3());
		}
		if (itemvo.getIfile4() != null) {
			ifile.add(itemvo.getIfile4());
		}
		if (itemvo.getIfile5() != null) {
			ifile.add(itemvo.getIfile5());
		}
		if (itemvo.getIfile6() != null) {
			ifile.add(itemvo.getIfile6());
		}
		if (itemvo.getIfile7() != null) {
			ifile.add(itemvo.getIfile7());
		}
		if (itemvo.getIfile8() != null) {
			ifile.add(itemvo.getIfile8());
		}
		if (itemvo.getIfile9() != null) {
			ifile.add(itemvo.getIfile9());
		}
		if (itemvo.getIfile10() != null) {
			ifile.add(itemvo.getIfile10());
		}
		String[] istock = request.getParameterValues("istock");

		int i = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;

		for (String e : iname) {
			for (String e2 : iprice) {
				if (i == i2) {
					for (MultipartFile e3 : ifile) {
						if (i == i3) {
							for (String e4 : istock) {
								if (i == i4) {
									ItemVO vo = new ItemVO();

									vo.setItype(String.valueOf(itype));
									vo.setIname(iname[i]);
									vo.setIprice(Integer.parseInt(iprice[i2]));
									vo.setIstock(Integer.parseInt(istock[i4]));

									oriFn = ifile.get(i3).getOriginalFilename();
									path = new StringBuffer();
									path.append(r_path).append(img_path).append("\\").append(oriFn);

									f = new File(path.toString());

									try {
										ifile.get(i3).transferTo(f); // 복붙 ***
										// 이미지 이름을 db에 저장하기 위해 DTO값을 재설정 => 해당값 DB에 넣기!
										vo.setIimg(oriFn);
									} catch (IllegalStateException | IOException ex) {
										ex.printStackTrace();
									}

									list.add(vo);

									itype++;
									i4++;
								}
							}
							i3++;
						}
					}
					i2++;
				}
			}
			i++;
		}
		// ------------------------
		localService.insert(dto, list);

		//숙소 등록은 호스트만 가능하므로, 방 등록 후 보여주는 list는 호스트용!
		return "redirect:hostLocalList";
	}

//============================================================================	
	//멤버용 List
	@RequestMapping("/localboardList")
	public String localboardList(Model model,PageSearchDTO dto) {
		System.out.println(dto.getSearchType());
		System.out.println(dto.getSearchValue());
		List<LocalVO> list = localdaointer.getList(dto);
		model.addAttribute("list", list);

		return "localtrip/localboardList";
	}

	//호스트용 List
	@RequestMapping("/hostLocalList")
	public String hostLocalList(Model model,HttpSession session) {
		int hno = (int) session.getAttribute("sessionHNum");
		List<LocalVO> list = localdaointer.hostLocalList(hno);
		model.addAttribute("list", list);

		return "localtrip/localboardList";
	}

//============================================================================
	@RequestMapping("/localdetail")
	public String localdetail(Model m, int num) {
		LocalVO vo = localdaointer.detailLocal(num);
		m.addAttribute("vo", vo);

		// Review : 댓글기능 추가==========================
		ReviewVO rvo = new ReviewVO();
		rvo.setListchk(1); //리스트 출력방식 선택
		rvo.setRecode(num); //국내여행 pk 전달
		
		List<ReviewVO> listReview = reviewDaoInter.listReview(rvo);
		m.addAttribute("listReview", listReview);
		// ============================================

		return "localtrip/localDetail";
	}

//============================================================================	
	@RequestMapping("/localdelete")
	public String localdelete(int num) {
		localdaointer.delLocal(num);
		return "redirect:hostLocalList";
	}

//============================================================================	
	@GetMapping("/localmodifyForm")
	public String localmodifyform(Model m, int num) {
		LocalVO vo = localdaointer.detailLocal(num);
		m.addAttribute("vo", vo);
		return "localtrip/localmodify";
	}

	@PostMapping("/localmodify")
	public String localmodify(Model m, LocalVO dto, HttpServletRequest request) {

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
			dto.setLimg(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		localdaointer.localmodify(dto);

		return "redirect:hostLocalList";
	}

//============================================================================	
	// =================댓글 추가하기========================
	@RequestMapping(value = "/addReview")
	public String addReview(Model m, ReviewVO vo,HttpServletRequest request) {
		reviewDaoInter.addReview(vo);
		// HttpServletRequest reqeust referer = 이전 페이지로 돌아가기
		String referer = request.getHeader("Referer");
		// 경로를 이전 페이지로 연동해주기
		return "redirect:" + referer;
	}
}
