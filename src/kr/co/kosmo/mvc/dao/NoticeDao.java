package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.NoticeVO;
import kr.co.kosmo.mvc.vo.PageSearchDTO;
@Repository
public class NoticeDao implements NoticeInter {
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addinsert(NoticeVO vo) {
		ss.insert("notice.add", vo);
	}

	@Override
	public List<NoticeVO> noList() {
		List<NoticeVO> list = ss.selectList("notice.list");
		return list;
	}

	@Override
	public int getCnt(PageSearchDTO vo) {
		return ss.selectOne("notice.totalCount",vo);
	}

	@Override
	public List<NoticeVO> getList(PageSearchDTO vo) {
		return ss.selectList("notice.listpage",vo);
	}

}
