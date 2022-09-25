package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.JDBCUtil;
import board.BoardVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;

	//로그인 
	final String sql_selectOne="SELECT * FROM CMEMBER WHERE MID=? AND MPW=?";
	// 회원정보변경 -> mid만으로 사용자 데이터 보기
	final String sql_selectOne_M="SELECT * FROM MEMBER WHERE MID=?";
	//회원가입 
	final String sql_insert="INSERT INTO CMEMBER VALUES(?,?,?,?,?,?,?,?)";
	//회원가입 시 아이디 중복확인 
	final String sql_idcheck="SELECT * FROM CMEMBER WHERE MID=?";
	//회원 리스트 조희 (필요없으면 삭제!!) 
	final String sql_selectAll ="SELECT * FROM CMEMBER";
	//회원 정보 수정 
	final String sql_update = "UPDATE CMEMBER SET MPW=?, MNAME=?, MNICKNAME=?, MADD=?, MPHONE=?, MEMAIL=?, ROLE = ? WHERE MID=?";
	//회원 탈퇴 
	final String sql_delete = "DELETE FROM CMEMBER WHERE MID=? AND MPW=?";
	// 회원 탈퇴시 리뷰 ID (알수없음) - 트랜잭션
	final String sql_bupdate = "UPDATE CBOARD SET MID= '(알수없음)' WHERE MID =?";
	// 해당 MID에 게시글 전부 삭제 - 트랜잭션 
	final String sql_bdelete = "DELETE FROM CBOARD WHERE MID=?"; 



	//로그인 
	public MemberVO selectOne(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setMnickname(rs.getString("mnickname"));
				data.setMadd(rs.getString("madd"));
				data.setMphone(rs.getString("mphone"));
				data.setMemail(rs.getString("memail"));
				data.setRole(rs.getString("role"));
				return data;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return null;
	}

	// 회원정보변경 -> mid만으로 사용자 데이터 보기
	public MemberVO selectOne_M(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getMid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setMnickname(rs.getString("mnickname"));
				data.setMadd(rs.getString("add"));
				data.setMphone(rs.getString("mphone"));
				data.setMemail(rs.getString("memail"));
				data.setRole(rs.getString("role"));
				return data;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return null;
	}

	//회원가입
	public boolean insert(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMnickname());
			pstmt.setString(5, vo.getMadd());
			pstmt.setString(6, vo.getMphone());
			pstmt.setString(7, vo.getMemail());
			pstmt.setString(8, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

	//회원가입 시 아이디 중복확인 
	public int idcheck(String id) {
		conn=JDBCUtil.connect();
		int result = -1;
		try {
			pstmt=conn.prepareStatement(sql_idcheck);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				result=0; //중복된 아이디
			}else {
				result=1; //사용가능한 아이디
			}
			System.out.println("아이디 중복체크결과 : "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return result;
	}

	//회원 리스트 조회 
	public ArrayList<MemberVO> selectAll(MemberVO vo){
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				data.setMname(rs.getString("mname"));
				data.setMnickname(rs.getString("mnickname"));
				data.setMadd(rs.getString("add"));
				data.setMphone(rs.getString("mphone"));
				data.setMemail(rs.getString("memail"));
				data.setRole(rs.getString("role"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}

	//회원 정보 수정 
	public boolean update(MemberVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getMname());
			pstmt.setString(3, vo.getMnickname());
			pstmt.setString(4, vo.getMadd());
			pstmt.setString(5, vo.getMphone());
			pstmt.setString(6, vo.getMemail());
			pstmt.setString(7, vo.getMid());
			pstmt.setString(8, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}

	//회원 탈퇴 
	// 1 == 게시글 모두 삭제 / -1 == 알수없음으로 변경 
	public boolean delete(BoardVO bvo ,MemberVO vo) {
		conn = JDBCUtil.connect();
		try {
			// 트랜잭션 시작
			conn.setAutoCommit(false);
			// 만약 로그인한상태라면
			if(vo.getMid() != null) {
				// sql delete문 사용
				pstmt = conn.prepareStatement(sql_delete);
				// 위 sql문에 필요한 값들을 set해줌
				pstmt.setString(1, vo.getMid());
				pstmt.setString(2, vo.getMpw());
				pstmt.executeUpdate();   
				// 게시글 처리
				// 아래 bdelete() 함수를 사용
				if(bdelete(bvo)) {
					// commit일 경우 bdelete 함수가 잘 수행된것 
					conn.commit();
				} else {
					// bdelete함수가 잘 수행되지 않았다면 rollback
					conn.rollback();
					// 이후 return false
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean bdelete(BoardVO bvo) {
		conn = JDBCUtil.connect();
		try {
			// 로그인 한 상태라면
			if(bvo.getMid() != null) {
				// 게시글 삭제 여부를 가리는 VO 내 멤버변수 res
				// 1일땐 게시글을 모두 삭제하고,
				if(bvo.getRes() == 1) {
					pstmt = conn.prepareStatement(sql_bdelete);   
					pstmt.setString(1, bvo.getMid());
					// -1일 즉 else 일땐 알수 없음으로 변경되게끔한다.
				} else {
					pstmt = conn.prepareStatement(sql_bupdate);
					pstmt.setString(1, bvo.getMid());
				}
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

//         전부삭제 1 모두 유지 0 