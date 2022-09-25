//package ctrl;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import car.CarDAO;
//import car.CarVO;
//import ctrl.ActionForward;
////차량 상세페이제, CarDAO에 차량 selectone추가하였음
//public class InfoMainAction implements Action{
//
//	@Override
//	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ActionForward forward = null;
//		CarDAO cdao = new CarDAO();
//		CarVO cvo = new CarVO();
//
//		cvo.setCnum(Integer.parseInt(request.getParameter("cnum"))); //car테이블의 pk값 받아와서 sql에 사용
//
////		CarVO cInfo = cdao.selectOne(cvo); //cnum 값을 받아와 selectOne으로 테이블에서 해당 cnum에 해당하는 데이터를 cInfo에 저장
////
////		forward = new ActionForward();
////		forward.setPath(null); //게시판.do 경로 설정 예정
////		forward.setRedirect(false); //정보를 가지고 보내야 한다.
////
////		return forward;
//	}
//
//}
//
//////차량 상세페이지에 사용될 sql문
////final String sql_selectOne="SELECT * FROM CAR WHERE CNUM=?";  //차량 선택할 때 해당 차량의 CNUM값으로 출력
////
//////차량 선택
////	 public CarVO selectOne(CarVO vo) {
////			conn=JDBCUtil.connect();
////			try {
////				pstmt=conn.prepareStatement(sql_selectOne);
////				pstmt.setInt(1, vo.getCnum());
////				ResultSet rs=pstmt.executeQuery();
////				if(rs.next()) {
////					CarVO data=new CarVO();
////					data.setCtitle(rs.getString("ctitle"));
////					data.setCsubtitle(rs.getString("csubtitle"));
////					data.setCprice(rs.getInt("cprice"));
////					data.setCkm(rs.getInt("ckm"));
////					data.setCfuel(rs.getString("cfuel"));
////					data.setCcity(rs.getString("ccity"));
////					data.setCimg(rs.getString("cimg")); //img url을 가지고 이미지 출력에 사용
////					return data;
////				}
////				
////			} catch (SQLException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}finally {
////				JDBCUtil.disconnect(pstmt, conn);
////			}
////			return null;
////		}