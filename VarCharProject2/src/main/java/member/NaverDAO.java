package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.JDBCUtil;

public class NaverDAO {

	Connection conn;
	PreparedStatement pstmt;
	
	final String INSERTMEMBER="INSERT INTO CMEMBER (MID,MNAME,MNICKNAME,MEMAIL) VALUES(?,?,?,?)";
	final String selectOne="SELECT * FROM CMEMBER WHERE MID=?";
	final String selectAll="SELECT * FROM CMEMBER";
	final String selectAll_mid="SELECT MID FROM CMEMBER";
	
	
	//네이버 API 로 로그인시 자동으로 회원가입 하게 만드는 로직
	//단 회원가입 할떄 아이디가 중복이면 실행 안함
	
	public boolean insertMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			//회원 가입 하기전에 중복되는 아이디 찾기
			pstmt=conn.prepareStatement(selectAll_mid);
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				String mid=res.getString("mid");
				if(mid.equals(vo.getMid())) {
					return true;    
					//만약에 회원가입 할라는 아이디와 테이블에 아이디가 존재 한다면? 함수 종료
					//중복인데 false가 아닌 true값을 주는 이유
					//테이블에 중복되는 아이디가 있다는것은 이미 네이버 로 회원가입 했단 증거(회원 가입 x)
					// true 값을 주어서 NaverLoginAction 에 세션에 등록하기위해 true
				}
			}
			//회원가입
			pstmt=conn.prepareStatement(INSERTMEMBER);
			System.out.println(vo.getMid());
			System.out.println(vo.getMname());
			System.out.println(vo.getMnickname());
			System.out.println(vo.getMemail());
			
			
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMname());
			pstmt.setString(3, vo.getMnickname());
			pstmt.setString(4, vo.getMemail());
			
			int rs=pstmt.executeUpdate();
			if(rs==1) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
			
		}
		
		
		return false;
	}
	//네이버 API로그인시 MID의 정보를 가져오는 로직
	public MemberVO selectOne(MemberVO vo) {
		MemberVO data =new MemberVO();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(selectOne);
			pstmt.setString(1, vo.getMid());
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("mpw"));
				data.setMadd(rs.getString("madd"));
				data.setMname(rs.getString("Mname"));
				data.setMnickname(rs.getString("Mnickname"));
				data.setMphone(rs.getString("Mphone"));
				data.setRole(rs.getString("Mrole"));
				data.setMemail(rs.getString("Memail"));
				
				return data;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
