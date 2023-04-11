package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.BookLoggerDTO;
import kr.co.kosmo.mvc.vo.BookVO;

@Repository
public class BookDao {
	@Autowired
	private SqlSessionTemplate ss;

// ==============================================
	// 예약 로그
	public void addBookLogging(BookLoggerDTO vo) {
		ss.insert("book.booklogger_in", vo);
	}
// ==============================================
	// 예약
	// 예약 폼에 적용
	public LocalVO detailLocalTotal(int lid) {
		return ss.selectOne("book.detailLocalTotal", lid);
	}

	// ------------------------------
	// book
	public void addBook(BookVO bookvo) {
		ss.insert("book.addBook", bookvo);
	}

	// charge
	public void addChage(ChargeMVO chvo) {
		ss.insert("book.addBookCh", chvo);
	}

// ==============================================
	// 예약 리스트 출력 + 최근Top3
	public List<BookVO> listBook(BookVO bookvo) {
		return ss.selectList("book.listBookRank", bookvo);
	}

// ==============================================
	// 예약수정
	// 수정 폼에 적용
	public BookVO updateBookForm(int bid) {
		return ss.selectOne("book.updateBookForm", bid);
	}

	// ------------------------------
	// book
	public void updateBook(BookVO bookvo) {
		ss.update("book.updateBook", bookvo);
	}

	// charge
	public void updateChage(ChargeMVO chvo) {
		ss.update("book.updateBookCh", chvo);
	}

// ==============================================
	// 예약취소 로그 남기기 위해 Detail => 기존 로그에서 뽑아오기(예약/수정)
	public BookLoggerDTO delBookforLog(int bid) {
		return ss.selectOne("book.delBookforLog", bid);
	}
	// 예약취소
	public void delBook(BookVO bookvo) {
		ss.delete("book.delBook", bookvo);
	}
// ==============================================
	// 날짜 제한
	// uplimit 수정 : 0 수정가능 / 1 직접연락해서 수정
	// dellimit 취소 : 1일 직접연락 / 3일 50%환불 / 5일 70%환불 / 7일 100%환불
	public BookVO changeLimit(int bid) {
		return ss.selectOne("book.changeLimit", bid);
	}

//==============================================
	// 마이페이지 => useHistory에 출력
	public BookVO useHistory(int mnum) {
		return ss.selectOne("book.useHistory", mnum);
	}

//==============================================
	// 차트 적용
	// 예약 횟수 출력
	public List<BookVO> tourCount(int mnum) {
		return ss.selectList("book.tourcount", mnum);
	}
	// 방문 여행지
	public List<BookVO> visitSpot(int mnum) {
		return ss.selectList("book.visitSpot", mnum);
	}
	// 최대 여행기간
	public List<BookVO> periodMax(int mnum) {
		return ss.selectList("book.periodMax", mnum);
	}
	// 주 결제 방식
	public List<BookVO> costType(int mnum) {
		return ss.selectList("book.costType", mnum);
	}
	// 누적 여행 비용
	public List<BookVO> costTotal(int mnum) {
		return ss.selectList("book.costTotal", mnum);
	}

//==============================================
	// 상위리스트 출력
	public List<BookVO> rankLocal() {
		return ss.selectList("book.rankLocal");
	}

	// 객실 정보
	public List<ItemVO> detailItem(int lid) {
		return ss.selectList("book.detailItem", lid);
	}

	// 객실 확인
	public int checkItem(ItemVO vo) {
		return ss.selectOne("book.checkItem", vo);
	}

	// 숙박일수 받기
	public int getBookCnt(ItemVO vo) {
		return ss.selectOne("book.getBookCnt", vo);
	}
//==============================================
	// 호스트 ManageMent : 예약상태 수정
	public void updateBookHost(BookVO bookvo) {
		ss.update("book.updateBookHost", bookvo);
	}

	// 호스트 ManageMent 1-1 : 예약관리(예약 리스트)
	public List<LocalVO> hostBookList(HostVO vo) {
		return ss.selectList("book.hostBookList", vo);
	}
	// 호스트 ManageMent : 취소된 예약내역만 출력
	public List<BookLoggerDTO> hostBookDelList() {
		return ss.selectList("book.hostBookDelList");
	}
}
