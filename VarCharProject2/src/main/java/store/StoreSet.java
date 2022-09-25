package store;

import java.util.ArrayList;

public class StoreSet {
	private String mid; //회원의 아이디값
	private ArrayList<StoreVO> sList = new ArrayList<StoreVO>(); //찜한 목록들어갈 배열객체
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public ArrayList<StoreVO> getsList() {
		return sList;
	}
	public void setsList(ArrayList<StoreVO> sList) {
		this.sList = sList;
	}
	@Override
	public String toString() {
		return "StoreSet [mid=" + mid + ", sList=" + sList + "]";
	}
	
}
