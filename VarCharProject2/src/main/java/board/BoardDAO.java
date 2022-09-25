package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.JDBCUtil;

public class BoardDAO {
	Connection conn;	// DB연결 객체 선언
	PreparedStatement pstmt;	// SQL문 수행할 PreparedStatement 객체 선언

	// SQL문
	// 문의글 추가
	final String sql_insert = "INSERT INTO CBOARD VALUES((SELECT NVL(MAX(BNUM),0) +1 FROM CBOARD),?,?,?,?,(SELECT SYSDATE FROM DUAL))";
	// 문의글에 댓글 추가
	final String sql_insert_R = "INSERT INTO REPLY(RID,MID,BNUM,CMSG) VALUES((SELECT NVL(MAX(RID),0) +1 FROM CREPLY),?,?,?)";
	// 문의글 삭제
	final String sql_delete = "DELETE FROM CBOARD WHERE BNUM=?";
	// 문의글에 댓글 삭제
	final String sql_delete_R = "DELETE FROM CREPLY WHERE RID=?";
	// 문의글 수정
	final String sql_update = "UPDATE CBOARD SET BTITLE=?, CONTENT=?, WHERE BNUM=?";
	// 문의글 상세보기
	final String sql_selectOne = "SELECT * FROM CBOARD WHERE BNUM=?";
	// 문의글 목록보기
	final String sql_selectAll = "SELECT * FROM (SELECT * FROM CBOARD ORDER BY BNUM DESC) WHERE ROWNUM <=?";
	// 내가 작성한 문의글 보기
	final String sql_selectAll_M = "SELECT * FROM (SELECT * FROM CBOARD WHERE MID=? ORDER BY BNUM DESC) WHERE ROWNUM <=?";
	// 문의글 댓글 보기
	final String sql_selectAll_R="SELECT * FROM CREPLY WHERE BNUM=? ORDER BY RID DESC";
	// 문의글 제목 검색
	final String sql_selectAll_T="SELECT * FROM CBOARD WHERE BTITLE LIKE '%'||?||'%' ORDER BY BID DESC";
	///////////////////////////문의 글 추가///////////////////////////////////////
	public boolean insert(BoardVO bvo) {	// vo로 인자값을 받아 유지보수 용이
		conn = JDBCUtil.connect(); // DB연결
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, bvo.getMid()); //사용자 ID
			pstmt.setString(2, bvo.getBcontent()); //사용자가 작성한 문의 글 내용
			pstmt.setString(3, bvo.getMnickname()); //사용자 닉네임
			pstmt.setString(4, bvo.getBtitle()); //문의글 제목
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		} 
		return true;
	}
	///////////////////////////문의 글에 댓글 추가///////////////////////////////////////
	public boolean insertR(ReplyVO rvo) {	// vo로 인자값을 받아 유지보수 용이
		conn = JDBCUtil.connect(); // DB연결
		try {
			pstmt=conn.prepareStatement(sql_insert_R);
			pstmt.setString(1, rvo.getMid()); //사용자 ID
			pstmt.setInt(2, rvo.getBnum()); // 문의글 pk값
			pstmt.setString(3, rvo.getCmsg()); // 문의글 내용
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		} 
		return true;
	}
	////////////////////////////문의 글 삭제//////////////////////////////////////
	public boolean delete(BoardVO bvo) { // vo로 인자값을 받아 유지보수 용이
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setInt(1, bvo.getBnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	////////////////////////////문의 글에 달린 댓글삭제//////////////////////////////////////
	public boolean deleteR(ReplyVO rvo) { // vo로 인자값을 받아 유지보수 용이
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete_R);
			pstmt.setInt(1, rvo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	////////////////////////////문의 글 수정/////////////////////////////////////
	public boolean update(BoardVO bvo) {// vo로 인자값을 받아 유지보수 용이
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_update);
			pstmt.setString(1, bvo.getBtitle());
			pstmt.setString(2, bvo.getBcontent());
			pstmt.setInt(3, bvo.getBnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	/////////////////////////////문의 글 상세보기////////////////////////////////////
	public BoardVO selectOne(BoardVO bvo) {// vo로 인자값을 받아 유지보수 용이
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, bvo.getBnum());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				BoardVO data = new BoardVO();
				data.setBnum(rs.getInt("BNUM"));
				data.setMid(rs.getString("MID"));
				if(rs.getString("MNICKNAME") != null) {
					data.setMnickname(rs.getString("MNICKNAME"));
				}else {
					data.setMnickname("탈퇴한회원");
				}
				data.setBcontent(rs.getString("BCONTENT"));
				data.setBtitle(rs.getString("BTITLE"));
				data.setBdate(rs.getString("BDATE"));
				return data;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return null;
	}
	////////////////////////////문의 글 목록 보기/////////////////////////////////////
	public ArrayList<BoardSet> selectAll(BoardVO bvo){
		ArrayList<BoardSet> datas=new ArrayList<BoardSet>();
		conn=JDBCUtil.connect();
		try {
			if(bvo.getMid() == null) { // 로그인 하지 않았을 때 전체보기
				pstmt=conn.prepareStatement(sql_selectAll);
				pstmt.setInt(1, bvo.getBcnt());
			} else { // 로그인 하면 내가 쓴 글 보기 기능 활성화
				pstmt=conn.prepareStatement(sql_selectAll_M);
				pstmt.setString(1, bvo.getMid());
				pstmt.setInt(2, bvo.getBcnt());
			}
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardSet bs = new BoardSet();

				BoardVO data=new BoardVO();
				data.setBnum(rs.getInt("BNUM"));
				data.setMid(rs.getString("MID"));
				if(rs.getString("MNICKNAME") != null) {
					data.setMnickname(rs.getString("MNICKNAME"));
				}else {
					data.setMnickname("탈퇴한회원");
				}
				data.setBcontent(rs.getString("BCONTENT"));
				data.setBtitle(rs.getString("BTITLE"));
				data.setBdate(rs.getString("BDATE"));
				bs.setBoardVO(data);

				ArrayList<ReplyVO> rList=new ArrayList<ReplyVO>();
				pstmt=conn.prepareStatement(sql_selectAll_R);
				pstmt.setInt(1, rs.getInt("BID")); // 현재 BID
				ResultSet rs2=pstmt.executeQuery();
				while(rs2.next()) {
					ReplyVO cbVO=new ReplyVO();

					cbVO.setBnum(rs2.getInt("BNUM"));
					cbVO.setMid(rs2.getString("MID"));
					cbVO.setRid(rs2.getInt("RID"));
					cbVO.setCmsg(rs2.getString("CMSG"));
					rList.add(cbVO);
				}
				bs.setrList(rList);
				
				datas.add(bs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return datas;
	}
	////////////////////////////문의 글 제목 검색/////////////////////////////////////
	public ArrayList<BoardVO> selectAll_searchTitle(BoardVO bvo){
		ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectAll_T);
			pstmt.setString(1, bvo.getSearchTitle());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBnum(rs.getInt("BNUM"));
				data.setMid(rs.getString("MID"));
				if(rs.getString("MNICKNAME") != null) {
					data.setMnickname(rs.getString("MNICKNAME"));
				}else {
					data.setMnickname("탈퇴한회원");
				}
				data.setBcontent(rs.getString("BCONTENT"));
				data.setBtitle(rs.getString("BTITLE"));
				data.setBdate(rs.getString("BDATE"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}		
		return datas;
	}


















}
