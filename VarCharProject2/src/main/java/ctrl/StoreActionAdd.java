package ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.CarDAO;
import car.CarVO;
import store.StoreSet;
import store.StoreVO;
//StoreVO 이용한 version
public class StoreActionAdd implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		CarVO cvo=new CarVO();
		CarDAO cdao=new CarDAO();
		//예약하기를 클릭했을때 cnum 정보를 받음
		cvo.setCnum(Integer.parseInt(request.getParameter("cnum")));
		cvo=cdao.selectOne(cvo);	//클릭한 cnum의 모든 정보를 찾음
		System.out.println("로그 storeAction에서 배열에 저장될 친구"+cvo);
		//store datas 
		ArrayList<CarVO> sdatas=new ArrayList<CarVO>();
		sdatas.add(cvo);	//찾은 정보를 추가
		
		HttpSession session = request.getSession(); //찜을 세션정보로 저장할 예정
		System.out.println("세션에서 받아온 친구"+session.getAttribute("sdatas"));  
		ArrayList<CarVO> sdatas2=(ArrayList<CarVO>)session.getAttribute("sdatas");
		if(sdatas2==null) { //처음에 장바구니가 없을때 (비어 있을때 실행)
			System.out.println("세션세팅 전에 확인(세션 널) sdatas"+sdatas);
			session.setAttribute("sdatas", sdatas);
		}else {
			sdatas2.add(cvo);
			System.out.println("세션세팅 전에 확인 sdatas"+sdatas2);
			session.setAttribute("sdatas", sdatas2);
		}
//		System.out.println("세션세팅 전에 확인 sdatas"+sdatas);
//		session.setAttribute("sdatas", sdatas);
		
//		System.out.println("세션에서 받아온 친구"+session.getAttribute("sdatas"));  //<<--안받아짐
//		//sdatas=(ArrayList<CarVO>)session.getAttribute("sdatas");
//		System.out.println("세션세팅 전에 확인 sdatas"+sdatas);
//		session.setAttribute("sdatas", sdatas);
		
//		StoreVO svo = new StoreVO();
//		svo.setCnum(request.getParameter("cnum")); //찜 추가 시 car의 pk값 저장
//		svo.setCtitle(request.getParameter("ctitle")); //car의 제목 저장
//		svo.setCprice(Integer.parseInt(request.getParameter("cprice"))); //car의 가격 저장
//		svo.setCfuel(request.getParameter("cfuel")); //car의 연료정보 저장
//		
//		System.out.println(svo);
//		
//		ArrayList<StoreVO> storeList = new ArrayList<StoreVO>(); //svo에 담긴 정보들을 저장할 배열
//		storeList.add(svo); //svo의 값을 저장
//		
//		StoreSet sset = new StoreSet();
//		sset.setMid(request.getParameter("mid")); //member의 id값 저장
//		sset.setsList(storeList); //찜목록에 svo 값들이 저장된 배열값 저장
//		
//		System.out.println(sset);
//		
//		ArrayList<StoreSet> zzim = new ArrayList<StoreSet>(); //id와 찜한목록 정보 저장할 배열객체 생성
//		zzim.add(sset); // zzim 배열객체에 mid값과 찜한 목록의 정보(배열값) 저장
//	
//		HttpSession session = request.getSession(); //찜을 세션정보로 저장할 예정
//		session.setAttribute("storeList", zzim); // storeList 속성명으로 zzim 데이터 세션저장
//		
		forward.setPath("filterSearch.do"); //게시판.do로 바꿀 예정임
		forward.setRedirect(false);	 //정보가 유지되어야 하므로 forward로 전송
		return forward;

	}
	
}
