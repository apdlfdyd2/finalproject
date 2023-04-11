package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.SendMailVO;

@Repository
public class SendMailDao implements SendMailDaoInter{
	@Autowired
	private SqlSessionTemplate ss;

	//sendmail 테이블에서 SendMailVO를 반환값으로
	//예약정보 관련 내용을 뽑아온다
	@Override
	public SendMailVO reservemail() {
		// TODO Auto-generated method stub
		return ss.selectOne("mail.reservemail");
	}

	//sendmail테이블에 하나의 로우의 데이터만 존재하며
	//트랜잭션 처리가 될 때 bookform에서 받아오는 값들을 통해
	//update문으로 수정함
	@Override
	public void textupdate(SendMailVO mailvo) {
		ss.update("mail.textupdate",mailvo);
	}


}
