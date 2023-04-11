package kr.co.kosmo.mvc.dao;

import kr.co.kosmo.mvc.vo.HostVO;

public interface HostDaoInter {
	public void addHost (HostVO vo); //Insert
    public int hidcheck(String hid); //IdCheck
    public HostVO hlogin(HostVO vo); //Login
    public int loginchk(HostVO vo); //LoginCheck
    public HostVO hostpage(String hid); //Mypage
    public void hostupdate(HostVO vo); //update
    public void delHost(String hid); //Delete
}
