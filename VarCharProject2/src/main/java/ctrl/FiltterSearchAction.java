package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.CarDAO;
import car.CarVO;

public class FiltterSearchAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		
		CarVO cvo=new CarVO();
		CarDAO cdao=new CarDAO();
	//	System.out.println(cvo.getCnt()+"asdasad");
		if(request.getParameter("cnt")==null) {
			cvo.setCnt(1);
			
		}
		else {
			int cnt=Integer.parseInt(request.getParameter("cnt"));
			System.out.println("cnt"+cnt);
			cvo.setCnt(cnt+1);
			request.setAttribute("cnt", cnt);


		}
		
		ArrayList<CarVO> datas= cdao.selectAllPage(cvo);
		System.out.println("로그:필터 서치 액션의 datas"+datas);
		request.setAttribute("cdatas", datas);
		
		//=======테스용 세션 반드시 지울것====================
//		HttpSession session = request.getSession();
//
//		session.setAttribute("cdatas", datas);

		//=========================================
		forward.setPath("fitterSearch.jsp");
		forward.setRedirect(false);
		return forward;
	}
	
}
