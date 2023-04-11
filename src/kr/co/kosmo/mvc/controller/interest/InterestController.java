package kr.co.kosmo.mvc.controller.interest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.InterestDaoInter;
import kr.co.kosmo.mvc.vo.InterestVO;
import kr.co.kosmo.mvc.vo.LocalVO;

@Controller
@RequestMapping(value = "/interest")
public class InterestController {
	@Autowired
	InterestDaoInter dao;

	// Member
	private int nowPage = 1;
	private int numPerPage = 10;
	private int pagePerBlock = 5;

	@GetMapping(value = "/addCart")
	public String addCart(HttpSession session, int lid) {
		int mnum = (int) session.getAttribute("sessionNum");
		InterestVO vo = new InterestVO();

		vo.setMid(mnum);
		vo.setLid(lid);

		dao.addCart(vo);

		return "redirect:/main";
	}

	@GetMapping(value = "/listCart")
	public ModelAndView listCart(HttpSession session, String nowPage) {
		ModelAndView mav = new ModelAndView("interest/localCart");
		int mnum = (int) session.getAttribute("sessionNum");
		
		// ----------------------------------------- 1. Range에 쓰일 값
		int totalRecord = dao.countCart(mnum);
		int totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		// ----------------------------------------- 2. Index에 쓰일 값
		if (nowPage != null) {
			this.nowPage = Integer.parseInt(nowPage);
		}

		int startPage = ((this.nowPage - 1) / pagePerBlock) * pagePerBlock + 1; // 5x + 1(x = 0, 1, 2, ...) -> pagePerBlock * ((nowPage - 1) / pagePerBlock) + 1
		int endPage = startPage + pagePerBlock - 1; // 5x + 5(x = 0, 1, 2, ...) -> startPage - 1 + pagePerBlock
		// Index의 Range 제한
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		// ----------------------------------------- 3. Paginating된 list ***
		if (nowPage != null) {
			this.nowPage = Integer.parseInt(nowPage);

			System.out.println("this.nowPage = " + this.nowPage);
		}

		int startNum = numPerPage * (this.nowPage - 1) + 1; // 10x + 1(x = 0, 1, 2, ...) -> numPerPage * (nowPage - 1) + 1
		int endNum = startNum - 1 + numPerPage; // 10x + 10(x = 0, 1, 2, ...) -> startNum - 1 + numPerPage

		InterestVO vo = new InterestVO();

		vo.setMid(mnum);
		vo.setStartNum(startNum);
		vo.setEndNum(endNum);

		List<LocalVO> list = dao.listCart(vo);
		// -----------------------------------------
		// 1. Range에 쓰일 값
		mav.addObject(pagePerBlock);
		mav.addObject("totalPage", totalPage);
		// 2. Index에 쓰일 값
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("nowPage", this.nowPage);
		// 3. Paginating된 list
		mav.addObject("list", list);
		
		return mav;
	}
}