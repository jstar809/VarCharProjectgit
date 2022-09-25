package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.ReplyVO;

public class DeleteManagerReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		BoardDAO bDAO = new BoardDAO();
		ReplyVO rVO = new ReplyVO();
		
		rVO.setRid(Integer.parseInt(request.getParameter("rid")));
		if(bDAO.deleteR(rVO)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			throw new Exception("deleteR 오류");
		}
		// TODO Auto-generated method stub
		return forward;
	}
	
}
