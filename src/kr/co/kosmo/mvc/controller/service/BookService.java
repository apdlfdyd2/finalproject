package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.MemberDao;
import kr.co.kosmo.mvc.dao.SendMailDao;
import kr.co.kosmo.mvc.dao.BookDao;
import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MembershipVO;
import kr.co.kosmo.mvc.vo.SendMailVO;
import kr.co.kosmo.mvc.vo.BookLoggerDTO;
import kr.co.kosmo.mvc.vo.BookVO;

@Service
public class BookService {
	@Autowired
	private BookDao bookdao;
	
	@Autowired 
	private SendMailDao smdao;


	@Autowired
	private MemberDao memdao;

//=============================================================
	// 예약 로그
	public void addBookLogging(BookLoggerDTO vo) {
		bookdao.addBookLogging(vo);
	}

//=============================================================
	// 예약 폼에 적용
	public LocalVO detailLocalTotal(int lid) {
		return bookdao.detailLocalTotal(lid);
	}

	// add
	// 단위처리 (예약+결제+멤버십포인트)
	@Transactional
	public void addBookCh(BookVO bookvo, ChargeMVO chvo, SendMailVO mailvo, int num) {
		// 예약--------------------------------------------
		bookdao.addBook(bookvo);

		// 결제--------------------------------------------
		bookdao.addChage(chvo);

		// 메일--------------------------------------------
		smdao.textupdate(mailvo);
		
		// 포인트&누적결제금액----------------------------------
		// 결제할때 마다 포인트 추가 => id / point 받기
		MemberVO mvo = new MemberVO();
		int mnum = num;
		mvo.setMnum(mnum);

		// point 계산----------
		// 결제금액 chvo.getChpay()
		int chpay = chvo.getChpay();
		// 등급 별 포인트 계산 0.02~0.1
		MembershipVO mbsvo = memdao.mbsPoint(mnum);
		float mbspoint = mbsvo.getMbspoint();
		// 추가될 포인트 : 결제금액*등급별 포인트 계산법
		int mpoint = (int) (chpay * mbspoint);
		// 사용한 포인트 차감
		int usepoint = chvo.getUsepoint();
		//System.out.println("사용포인트" + usepoint);
		mpoint = mpoint - usepoint;

		//System.out.println("================예약Insert================");
		//System.out.println("결제금액 : " + chpay);
		//System.out.println("등급 별 포인트  : " + mbspoint);
		//System.out.println("추가될 포인트(적립예정-사용)  : " + mpoint);

		// db에 전달
		mvo.setMpoint(mpoint); //포인트 추가
		mvo.setMcharge(chpay); //결제금액 추가

		memdao.upMPoint(mvo);

		// 누적결제금액에 따른 멤버십등급 변경------------------------
		memdao.updateMbs(mnum);
	}

//=============================================================
	// 예약 리스트 출력 + 최근Top3 => 멤버 컨트롤러에서 사용
	public List<BookVO> listBook(BookVO bookvo) {
		return bookdao.listBook(bookvo);
	}

//=============================================================
	// 예약수정 폼에 적용
	public BookVO updateBookForm(int bid) {
		return bookdao.updateBookForm(bid);
	}

	// update
	// 단위처리 (예약+결제+멤버십포인트)
	@Transactional
	public void updateBookCh(BookVO bookvo, ChargeMVO chvo, int num) {
		// 예약--------------------------------------------
		bookdao.updateBook(bookvo);

		// 결제--------------------------------------------
		bookdao.updateChage(chvo);

		// 포인트--------------------------------------------
		//1. 기존 포인트 추출
		// 기존 예약로그에서 결제 데이터 확인 => 적립되었던 포인트 차감
		BookLoggerDTO booklogvo;
		booklogvo = delBookforLog(bookvo.getBid());
		int prechpay = -(booklogvo.getPay());
		int prespoint = -(booklogvo.getSpoint());
		int preupoint = booklogvo.getUpoint();
		System.out.println("================예약Update(기존기록)================");
		System.out.println("결제금액(로그) : " + prechpay);
		System.out.println("적립포인트(로그)  : " + prespoint);
		System.out.println("사용포인트(로그)  : " + preupoint);
		
		//2. 변경된 결제건에 대한 포인트 적립
		MemberVO mvo = new MemberVO();
		int mnum = bookvo.getMid();
		mvo.setMnum(mnum);

		// point 계산----------
		// 결제금액 chvo.getChpay()
		int upchpay = chvo.getChpay();
		// 등급 별 포인트 계산 0.02~0.1
		MembershipVO mbsvo = memdao.mbsPoint(mnum);
		float mbspoint = mbsvo.getMbspoint();
		// 추가될 포인트 : 결제금액*등급별 포인트 계산법
		int upmpoint = (int) (upchpay * mbspoint);

		// (-기존 결제금액) + (변경 결제금액)
		// (-기존 적립된 포인트+사용했던포인트) + (변경 결제에 따른 포인트)
		int chpay = upchpay+prechpay;
		int mpoint = upmpoint+prespoint+preupoint;
		System.out.println("================예약Update(연산완료)================");
		System.out.println("결제금액 : " + chpay);
		System.out.println("등급 별 포인트  : " + mbspoint);
		System.out.println("추가될 포인트  : " + mpoint);

		// db에 전달
		mvo.setMpoint(mpoint); //포인트 추가
		mvo.setMcharge(chpay); //결제금액 추가

		memdao.upMPoint(mvo);

		// 누적결제금액에 따른 멤버십등급 변경------------------------
		memdao.updateMbs(mnum);
	}

//=============================================================
	// 예약취소 로그 남기기 위해 Detail => 기존 로그에서 뽑아오기(예약/수정)
	public BookLoggerDTO delBookforLog(int bid) {
		return bookdao.delBookforLog(bid);
	}
	// 예약취소
	@Transactional
	public void delBook(BookVO bookvo) {
		// 예약--------------------------------------------
		bookdao.delBook(bookvo);
		// 결제--------------------------------------------
		// 예약 삭제시 자동 삭제
		// 포인트--------------------------------------------
		// 기존 예약로그에서 결제 데이터 확인 => 적립되었던 포인트 차감
		BookLoggerDTO booklogvo;
		booklogvo = delBookforLog(bookvo.getBid());
		int chpay = -(booklogvo.getPay());
		int mpoint = -(booklogvo.getSpoint());
		int usepoint = booklogvo.getUpoint();
		System.out.println("================예약Delete================");
		System.out.println("결제금액(로그) : " + chpay);
		System.out.println("포인트(로그)  : " + mpoint);
		System.out.println("사용했던포인트  : " + usepoint);
		// 포인트 rollback처리
		mpoint = mpoint + usepoint;
		System.out.println("포인트(취합)  : " + mpoint);

		// db에 전달
		int mnum = bookvo.getMid();
		MemberVO mvo = new MemberVO();
		mvo.setMnum(mnum);
		mvo.setMpoint(mpoint); //포인트 추가
		mvo.setMcharge(chpay); //결제금액 추가
		
		memdao.upMPoint(mvo);

		// 누적결제금액에 따른 멤버십등급 변경------------------------
		memdao.updateMbs(mnum);
		
	}

//=============================================================
	// 날짜 제한
	// uplimit 수정 : 0 수정가능 / 1 직접연락해서 수정
	// dellimit 취소 : 1일 직접연락 / 3일 50%환불 / 5일 70%환불 / 7일 100%환불
	public BookVO changeLimit(int bid) {
		return bookdao.changeLimit(bid);
	}

//=============================================================
	// 마이페이지 => useHistory에 출력 => MemberController
	public BookVO useHistory(int mnum) {
		return bookdao.useHistory(mnum);
	}
//=============================================================
	// 차트 적용 => MemberRestController
	// 예약 횟수 출력
	public List<BookVO> tourCount(int mnum) {
		return bookdao.tourCount(mnum);
	}
	// 방문 여행지
	public List<BookVO> visitSpot(int mnum) {
		return bookdao.visitSpot(mnum);
	}
	// 최대 여행기간
	public List<BookVO> periodMax(int mnum) {
		return bookdao.periodMax(mnum);
	}
	// 주 결제 방식
	public List<BookVO> costType(int mnum) {
		return bookdao.costType(mnum);
	}
	// 누적 여행 비용
	public List<BookVO> costTotal(int mnum) {
		return bookdao.costTotal(mnum);
	}

//=============================================================
	// 상위리스트 출력
	public List<BookVO> rankLocal() {
		return bookdao.rankLocal();
	}

	// 객실 정보
	public List<ItemVO> detailItem(int lid) {
		return bookdao.detailItem(lid);
	}

	// 객실 확인
	public int checkItem(ItemVO vo) {
		return bookdao.checkItem(vo);
	}

	// 숙박일수
	public int getBookCnt(ItemVO vo) {
		return bookdao.getBookCnt(vo);
	}
//=============================================================
	// 호스트 ManageMent : 예약상태 수정
	public void updateBookHost(BookVO bookvo) {
		bookdao.updateBookHost(bookvo);
	}
	// 호스트 ManageMent 1-1 : 예약관리(예약 리스트)
	public List<LocalVO> hostBookList(HostVO vo) {
		return bookdao.hostBookList(vo);
	}
	// 호스트 ManageMent : 취소된 예약내역만 출력
	public List<BookLoggerDTO> hostBookDelList() {
		return bookdao.hostBookDelList();
	}

}
