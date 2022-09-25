package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.ReplyVO;

public class InsertManagerReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		BoardDAO bDAO = new BoardDAO();
		ReplyVO rVO = new ReplyVO();
		
		rVO.setMid(request.getParameter("mid"));
		rVO.setBnum(Integer.parseInt(request.getParameter("bnum")));
		rVO.setCmsg(request.getParameter("cmsg"));
		
		if(bDAO.insertR(rVO)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			throw new Exception("insertR 오류");
		}
		return forward;
	}
	
}
