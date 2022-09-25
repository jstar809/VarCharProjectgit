package car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.JDBCUtil;

public class CarDAO {
	Connection conn;
	PreparedStatement pstmt;
	//====================크롤링 용 sql문(크롤링 안해도 쓰이긴함 )=====================================
	// 자동차 추가
	final String sql_insert = "INSERT INTO CAR VALUES((SELECT NVL(MAX(CNUM),0)+1 FROM CAR),?,?,?,?,?,?,?,?)";
	final String sql_sample = "SELECT COUNT(*) AS CNUM FROM CAR";
	//filterSearchAction에서 페이징 할떄 사용
	final String sql_selectAllOneToTwelve="SELECT * FROM (SELECT C.*, ROWNUM FROM (SELECT * FROM CAR ORDER BY ROWNUM ) C WHERE ROWNUM <= ? ) WHERE ROWNUM >= 1";
	final String sql_selectAll="SELECT * FROM CAR";
	//======================크롤링 끝====================================================
	// 자동차 정보 수정(다른 사항은 변경 할 수 없으므로 가격과 지역만 변경 가능)
	final String sql_update = "UPDATE CAR SET CPRICE=?, CCITY=? WHERE CNUM=?";
	// 자동차 삭제
	final String sql_delete = "DELETE FROM CAR WHERE CNUM=?";
	// 자동차 검색
	 final String sql_selectF = "SELECT * FROM CAR WHERE CTITLE IN (SELECT FROM CTITLE CAR) AND CYEAR IN(SELECT FROM CYEAR WHERE CAR) AND CFUEL IN(SELECT FROM CFUEL WHERE CAR) AND CKM IN(SELECT FROM CKM WHERE CAR) AND CPRICE IN(SELECT FROM CPRICE WHERE CAR)";
	   final String sql_selectS = "SELECT * FROM CAR WHERE CTITLE IN REPLACE((SELECT FROM CTITLE CAR),'SELECT FROM CTITLE CAR','?')";
	   final String sql_selectAll_Recent="SELECT * FROM (SELECT C.*, ROWNUM FROM (SELECT * FROM CAR ORDER BY ROWNUM DESC) C WHERE ROWNUM <= 12 ) WHERE ROWNUM >= 1 ";
	   
	final String sql_selectOne="SELECT * FROM CAR WHERE CNUM=?";

	//===================Crawling data============
	//////////////////////////자동차 추가/////////////////////////////////
	 // Crawling data
	   public boolean insert(CarVO vo) {
	      conn = JDBCUtil.connect();
	      try {
	         pstmt = conn.prepareStatement(sql_insert);
	         pstmt.setString(1, vo.getCtitle()); 
	         pstmt.setString(2, vo.getCsubtitle()); 
	         pstmt.setInt(3, vo.getCyear()); 
	         pstmt.setString(4, vo.getCfuel());
	         pstmt.setInt(5, vo.getCkm()); 
	         pstmt.setInt(6, vo.getCprice()); 
	         pstmt.setString(7, vo.getCcity()); 
	         pstmt.setString(8, vo.getCimg()); 

	         pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	         return false;
	      } finally {
	         JDBCUtil.disconnect(pstmt, conn);
	      }
	      return true;
	   }
	   public ArrayList<CarVO> selectAll(CarVO vo){
			ArrayList<CarVO> datas=new ArrayList<CarVO>();
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(sql_selectAll);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					CarVO data=new CarVO();
					data.setCnum(rs.getInt("cnum"));
					data.setCtitle(rs.getString("CTITLE"));
					data.setCsubtitle(rs.getString("CSUBTITLE"));
					data.setCyear(rs.getInt("CYEAR"));
					data.setCfuel(rs.getString("CFUEL"));
					data.setCkm(rs.getInt("CKM"));
					data.setCprice(rs.getInt("CPRICE"));
					data.setCcity(rs.getString("CCITY"));
					data.setCimg(rs.getString("CIMG"));
					datas.add(data);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}		
			return datas;
		}
	   // 샘플데이터가 있는지?
	   public boolean hasSample(CarVO vo) {
	      conn = JDBCUtil.connect();
	      try {
	         pstmt = conn.prepareStatement(sql_sample);
	         ResultSet rs = pstmt.executeQuery();
	         rs.next();
	         int cnum = rs.getInt("CNUM");
	         if (cnum >= 1) {
	            return true;
	         }
	         return false;
	      } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	      } finally {
	         JDBCUtil.disconnect(pstmt, conn);
	      }
	   }
	//=========================크롤링 끝 ===============================
	
	//////////////////////////자동차 정보 수정/////////////////////////////////
	public boolean update(CarVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setInt(1, vo.getCprice());
			pstmt.setString(2, vo.getCcity());
			pstmt.setInt(3, vo.getCnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	//////////////////////////자동차 삭제/////////////////////////////////
	public boolean delete(CarVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_delete);
			pstmt.setInt(1,vo.getCnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	//디테일 페이지에서 사용 
	//찜하기 할때 에서 사용
	public CarVO selectOne(CarVO vo) {
		CarVO data=new CarVO();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1,vo.getCnum());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data.setCnum(rs.getInt("cnum"));
				data.setCtitle(rs.getString("CTITLE"));
				data.setCsubtitle(rs.getString("CSUBTITLE"));
				data.setCyear(rs.getInt("CYEAR"));
				data.setCfuel(rs.getString("CFUEL"));
				data.setCkm(rs.getInt("CKM"));
				data.setCprice(rs.getInt("CPRICE"));
				data.setCcity(rs.getString("CCITY"));
				data.setCimg(rs.getString("CIMG"));
				return data;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	   public ArrayList<CarVO> selectAll_R(CarVO cvo){
		   ArrayList<CarVO> datas=new ArrayList<CarVO>();
		   conn=JDBCUtil.connect();
		   try {
		      pstmt=conn.prepareStatement(sql_selectAll_Recent);
		      ResultSet rs=pstmt.executeQuery();
		      while(rs.next()) {
		         CarVO carVO=new CarVO();
		         carVO.setCtitle(rs.getString("CTITLE"));
		         carVO.setCprice(rs.getInt("CPRICE"));
		         carVO.setCfuel(rs.getString("CFUEL"));
		         datas.add(carVO);
		      }
		   }catch (SQLException e) {
		      e.printStackTrace();
		   } finally {
		      JDBCUtil.disconnect(pstmt, conn);
		   }
		   return datas;
		}
	   public ArrayList<CarVO> selectAllPage(CarVO vo){
			ArrayList<CarVO> datas=new ArrayList<CarVO>();
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(sql_selectAllOneToTwelve);
				pstmt.setInt(1, (vo.getCnt()*12));  // 보여줄 최댓값 12*cnt
				
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					CarVO data=new CarVO();
					data.setCnum(rs.getInt("cnum"));
					data.setCtitle(rs.getString("CTITLE"));
					data.setCsubtitle(rs.getString("CSUBTITLE"));
					data.setCyear(rs.getInt("CYEAR"));
					data.setCfuel(rs.getString("CFUEL"));
					data.setCkm(rs.getInt("CKM"));
					data.setCprice(rs.getInt("CPRICE"));
					data.setCcity(rs.getString("CCITY"));
					data.setCimg(rs.getString("CIMG"));
					datas.add(data);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}		
			return datas;
		}
	
}