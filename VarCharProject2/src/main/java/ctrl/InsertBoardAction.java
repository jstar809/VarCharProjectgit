package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;

public class InsertBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		
		bVO.setMid(request.getParameter("mid"));
		bVO.setBtitle(request.getParameter("btitle"));
		bVO.setBcontent(request.getParameter("bcontent"));
		bVO.setMnickname(request.getParameter("mnickname"));
		
		if(bDAO.insert(bVO)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			throw new Exception("insertB 오류");
		}
		// TODO Auto-generated method stub
		return forward;
	}
	
}
