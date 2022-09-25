package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardVO;
import car.CarDAO;
import car.CarVO;

public class CarSearchAction implements Action{
	// 차량 테이블의 전체정보, 검색된 차량의 정보, 더보기 
	// 0829 - 필터 검색 부분 구현해내야함
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		// 차량 테이블의 전체정보
		CarDAO cDAO = new CarDAO();
		CarVO cVO = new CarVO();
		cVO.setCnum(Integer.parseInt(request.getParameter("cnum")));
		cVO.setCtitle(request.getParameter("ctitle"));
		cVO.setCsubtitle(request.getParameter("csubtitle"));
		cVO.setCcity(request.getParameter("ccity"));
		cVO.setCfuel(request.getParameter("cfuel"));
		cVO.setCimg(request.getParameter("cimg"));
		cVO.setCkm(Integer.parseInt(request.getParameter("ckm")));
		cVO.setCprice(Integer.parseInt(request.getParameter("cprice")));
		cVO.setCyear(Integer.parseInt(request.getParameter("cyear")));
		
		String paramCnt = request.getParameter("cnt");
		if(paramCnt == null || paramCnt.equals("")) {
			cVO.setCnt(35);
		} else {
			cVO.setCnt(Integer.parseInt(paramCnt));
		}
		ArrayList<CarVO> datas = cDAO.selectAll(cVO);
		request.setAttribute("datas", datas);
		request.setAttribute("cnt", cVO.getCnt());
		
		CarVO NextCvo = cVO;
		NextCvo.setCnt(cVO.getCnt() + 35);
		ArrayList<CarVO> nextDatas = cDAO.selectAll(NextCvo);
		request.setAttribute("noMoreContent", NextCvo.getCnt() - nextDatas.size() >= 35 ? true : false);
		if(cDAO.selectAll(cVO) != null) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		}
		
		// TODO Auto-generated method stub
		return forward;
	}
	

}
