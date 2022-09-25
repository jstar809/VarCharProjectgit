package ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;

public class DeleteBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		bVO.setBnum(Integer.parseInt(request.getParameter("bnum")));
		
		if(bDAO.delete(bVO)) {
			forward = new ActionForward();
			forward.setPath("main.do"); // 게시글 메인으로 (변경필요) 
			forward.setRedirect(false);
		}
		else {
			throw new Exception("deleteB 오류");
		}
		return forward;
	}

}