package kr.co.kosmo.mvc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.vo.LoginLoggerDTO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MembershipVO;

@Repository
public class MemberDao implements MemberDaoInter {
	@Autowired
	private SqlSessionTemplate ss;

//=======================================================
	// 회원가입
	@Override
	public void addMember(MemberVO vo) {
		ss.insert("member.addmem", vo);
	}
	// id체크 & 계정확인
	@Override
	public int idcheck(String mid) {
		return ss.selectOne("member.idchk", mid);
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO vo) {
		return ss.selectOne("member.login", vo);
	}
	// 로그인체크
	@Override
	public int loginchk(MemberVO vo) {
		return ss.selectOne("member.loginchk",vo);
	}

	// 회원수정
	@Override
	public void upMember(MemberVO vo) {
		ss.update("member.upmem", vo);
	}

	// 회원탈퇴
	@Override
	public void delMember(int mnum) {
		ss.delete("member.delmem", mnum);
	}

//=======================================================
	//mbti컬럼에 값을 넣을때 사용
	@Override
	public void upMbti(MemberVO vo) {
		ss.update("member.upmbti", vo);
	}
	//mbti테이블에서 mbti에 해당하는 pk num를 반환받음
	@Override
	public int mbtichk(String mbtitype) {
		return ss.selectOne("member.mbtichk",mbtitype);
	}
//=======================================================
	// 마이페이지
	@Override
	public MembershipVO memMembership(int mnum) {
		return ss.selectOne("member.membermbs", mnum);
	}

//=======================================================
	// 포인트 => 예약service에서 작업
	// 결제할때 마다 포인트 추가 => id / point 받기
	@Override
	public void upMPoint(MemberVO mvo) {
		ss.update("member.mpoint", mvo);
	}

	// 멤버십 등급 별 포인트 계산식
	@Override
	public MembershipVO mbsPoint(int mnum) {
		return ss.selectOne("member.pluspoint", mnum);
	}

//=======================================================
	// 멤버십 업그레이드 => 예약service에서 작업
	@Override
	public void updateMbs(int mnum) {
		ss.update("member.updatembs", mnum);
	}

	// 멤버십 업그레이드 차트 => 멤버 RestController에서 작업 => 마이페이지
	@Override
	public MembershipVO chartMbs(int mnum) {
		return ss.selectOne("member.chartmbs", mnum);
	}

//=======================================================
	// Login_Log
	@Override
	public void addLoginLogging(LoginLoggerDTO vo) {
		ss.insert("member.logger_in", vo);
	}

//=======================================================
	// KaKaoLogin
	@Override
	public String getAccessToken(String authorize_code) throws Throwable {
		System.out.println("==========1. getAccessToken==========");
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로

			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");

			sb.append("&client_id=5807f5504b2c080d19f04bd0614e4de4"); // REST_API키 본인이 발급받은 key 넣어주기
			sb.append("&redirect_uri=http://localhost/dTeam_semi_tour/login/kakaoLogin"); // REDIRECT_URI 본인이 설정한 주소
																							// 넣어주기

			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();

			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			// jackson objectmapper 객체 생성
			ObjectMapper objectMapper = new ObjectMapper();
			// JSON String -> Map
			Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
			});
			access_Token = jsonMap.get("access_token").toString();
			refresh_Token = jsonMap.get("refresh_token").toString();

			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
	}

	//@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> getUserInfo(String access_Token) throws Throwable {
		System.out.println("==========2. getUserInfo==========");
		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";

		try {
			URL url = new URL(reqURL); //url 객체만들기
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET"); //연결구성

			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8"); // charset=utf-8 추가
			
			//키값, 속성 적용
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			System.out.println("result type : " + result.getClass().getName()); // java.lang.String

			try {
				// jackson objectmapper 객체 생성
				ObjectMapper objectMapper = new ObjectMapper();
				// JSON String -> Map
				Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
				});

				System.out.println(jsonMap.get("properties"));

				Map<String, Object> properties = (Map<String, Object>) jsonMap.get("properties");
				Map<String, Object> kakao_account = (Map<String, Object>) jsonMap.get("kakao_account");

				//System.out.println("nickname => "+properties.get("nickname"));
				//System.out.println("email => "+kakao_account.get("email"));

				String nickname = properties.get("nickname").toString();
				String email = kakao_account.get("email").toString();

				userInfo.put("nickname", nickname);
				userInfo.put("email", email);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	//Login => 세션심기
	@Override
	public MemberVO kakaologin(MemberVO vo) {
		return ss.selectOne("member.kakaologin", vo);
	}

}
