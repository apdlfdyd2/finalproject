package kr.co.kosmo.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.HostVO;

@Repository
public class HostDao implements HostDaoInter {
	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public void addHost(HostVO vo) {
		ss.insert("host.addhost", vo);
	}

	@Override
	public int hidcheck(String hid) {
		return ss.selectOne("host.hidchk", hid);
	}

	@Override
	public HostVO hlogin(HostVO vo) {
		return ss.selectOne("host.hlogin", vo);
	}

	@Override
	public HostVO hostpage(String hid) {
		return ss.selectOne("host.hostpage", hid);
	}

	@Override
	public void hostupdate(HostVO vo) {
		ss.update("host.uphost", vo);
	}

	@Override
	public void delHost(String hid) {
		ss.delete("host.delhost", hid);
	}

	@Override
	public int loginchk(HostVO vo) {
		return ss.selectOne("host.hloginchk",vo);
	}

}