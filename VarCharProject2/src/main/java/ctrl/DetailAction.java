package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.CarDAO;
import car.CarVO;

public class DetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CarDAO cdao =new CarDAO();
		CarVO cvo=new CarVO();
		
		cvo.setCnum(Integer.parseInt(request.getParameter("cnum")));
		cvo=cdao.selectOne(cvo);
		
		request.setAttribute("data", cvo);
		System.out.println(cvo);
		ActionForward forward = new ActionForward();
		forward.setPath("detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
