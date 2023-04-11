package kr.co.kosmo.mvc.dao;

import java.util.HashMap;

import kr.co.kosmo.mvc.vo.LoginLoggerDTO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MembershipVO;

public interface MemberDaoInter {
	public void addMember(MemberVO vo); //Insert
	public int idcheck(String mid); //IdCheck & existchk
	public MemberVO login(MemberVO vo); //Login
	public int loginchk(MemberVO vo); //LoginCheck
	public void upMember(MemberVO vo); //Update	
	public void delMember(int mnum); //Delete
	//====================================================
	public void upMbti(MemberVO vo);//mbti컬럼에 값을 넣을때 사용
	public int mbtichk(String mbtitype);//mbti테이블에서 mbti에 해당하는 pk num를 반환받음
	//====================================================
	public MembershipVO memMembership(int mnum); //Detail(mypage1)
	//====================================================
	public void upMPoint(MemberVO vo); //Update_mpoint&mcharge 
	public MembershipVO mbsPoint(int mnum); //등급별 point계산식 출력
	//====================================================
	public void updateMbs(int mnum); //멤버십등급 업그레이드
	public MembershipVO chartMbs(int mnum); //멤버십등급 업그레이드 차트
	//====================================================
	public void addLoginLogging(LoginLoggerDTO vo); //Login_Log : AOP에서 사용
	//====================================================
	//KaKaoLogin
	String getAccessToken(String authorize_code) throws Throwable; 
	public HashMap<String, Object> getUserInfo(String access_Token) throws Throwable;
	public MemberVO kakaologin(MemberVO vo); //Login => 세션심기
	//====================================================
	
	
}
