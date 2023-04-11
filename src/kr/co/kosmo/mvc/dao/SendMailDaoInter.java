package kr.co.kosmo.mvc.dao;

import kr.co.kosmo.mvc.vo.SendMailVO;

public interface SendMailDaoInter {
	public SendMailVO reservemail();
    public void textupdate(SendMailVO mailvo);
}
