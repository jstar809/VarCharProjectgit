package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;


public class SearchReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		ArrayList<BoardVO> datas = bDAO.selectAll_searchTitle(bVO);
		
		bVO.setBtitle(request.getParameter("btitle"));
		
		if(datas.size() != 0) { //만약 datas에 검색된 내용이 있다면 
			request.setAttribute("datas", datas);
			forward=new ActionForward();
			forward.setPath("main.do"); // 게시글 메인으로 (변경필요) 
			forward.setRedirect(false); 
			
		}else {
			throw new Exception("SearchReply 오류");
		}
		return forward;
	}
}