package ctrl;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardSet;
import board.BoardVO;


public class BoardMainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		
		String paramCnt = request.getParameter("bcnt");
		//		System.out.println("paramCnt : " + paramCnt);
		if(paramCnt == null || paramCnt.equals("")){
			bvo.setBcnt(10); // 향후 초기화 매개변수 등으로 설정가능
		}
		else {
			bvo.setBcnt(Integer.parseInt(paramCnt));
		}

		
		String showContent = request.getParameter("showContent"); //search 객체에 input으로 받은 'search' 파라미터 값 저장
		request.setAttribute("cnt", bvo.getBcnt());
		bvo.setSearchTitle(showContent);
		
		System.out.println("showContent : [" + showContent + "]");

		HttpSession session = request.getSession(); // 출력할 게시글의 작성자를 세션에 저장 
		if(showContent != null) { // 게시판으로 가기/ 검색한 글 보기
			//search가 게시판.do인 경우
			if(showContent.equals("게시판.do")) { // 게시글 게시판으로 경로 변경 예정
				session.removeAttribute("moreContent"); // 세션 삭제 --> 전체 글 보기
			}
			else { // 내가 쓴 글
				session.setAttribute("moreContent", showContent); // 작성자 세션 저장
			//	System.out.println("moreContent : " + session.getAttribute("moreContent"));
				bvo.setMid(showContent); // 해당 작성자의 모든 게시글 출력하기 위한 mid set
			}
		}
		else { // 작성, 삭제 행동 --> showContent를 전달하지 않는다.
			// 그래서 세션에 있는 작성자 정보 이용
			// ex) 내가 쓴 글 보기(나의 mid 세션에 저장) --> -댓글 등 기능 수행(showContent 전달 X) 
			bvo.setMid((String)session.getAttribute("moreContent")); // 바로 직전에 세션에 저장된 작성자의 글을 출력(전체 게시글 포함)
		}		
		
		ArrayList<BoardSet> datas = bdao.selectAll(bvo);
		System.out.println(datas);
		request.setAttribute("datas", datas);
		request.setAttribute("cnt", bvo.getBcnt());
		
		// 모든 게시글 보면 더보기 버튼 비활성화
		BoardVO nextBvo = bvo;
		// 다음에 보여줄 게시글 (10개씩)
		nextBvo.setBcnt(bvo.getBcnt() + 10);
		ArrayList<BoardSet> nextDatas = bdao.selectAll(nextBvo);
		// cnt와 '다음에 보여줄 게시글 개수' 차이가 10보다 크거나 같으면 더보기 버튼 비활성화
		request.setAttribute("noMoreContent", nextBvo.getBcnt() - nextDatas.size() >= 10 ? true : false);
		//	System.out.println("noMoreContent : " + request.getAttribute("noMoreContent"));


		ActionForward forward = new ActionForward();
		forward.setPath("게시판.do");
		forward.setRedirect(false); //정보를 유지해야하므로 forward
		return forward;
	}

}
