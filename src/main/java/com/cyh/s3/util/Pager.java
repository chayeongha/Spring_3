package com.cyh.s3.util;

public class Pager {

	private Integer curPage;//현재페이지 번호

	private Integer perPage;//불러올 글의 개수...

	//View(JSP)
	private Integer startNum;  //시작번호
	private Integer lastNum;		// 끝번호
	private Integer culBlock;   //현재 블럭 번호
	private Integer totalBlock; //전체블럭갯수
	
	

	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}
	public Integer getCulBlock() {
		return culBlock;
	}
	public void setCulBlock(Integer culBlock) {
		this.culBlock = culBlock;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}

	//DB
	private Integer startRow; //시작 rownum
	private Integer lastRow; // 마지막 rownum

	private int curBlock;

	public Integer getCurPage() {
		if(curPage ==null || curPage==0) {
			curPage =1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if(perPage==null || perPage==0) {
			perPage=10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getLastRow() {
		return lastRow;
	}
	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}

	//makeRow
	
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()* this.getPerPage();
	}
		
	
	//makePage
	
	public void makePage(int totalCount) {
		//2. 전체 페이지수 totalPage
		int totalPage = totalCount/this.getCurPage();
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;
		}
		
		//3. 전체블럭수 totalBlock
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0 ) {
			totalBlock++;
			
		}
		//4. 현재 curPage로 curBlock 구하기.
		curBlock = this.getCurPage()/perBlock;
		if(this.getCurPage()%perBlock != 0) {
			curBlock++;
		}
		
		//5.curBlock  으로 startnum , lastNUm;
		startNum=(curBlock-1)*perBlock+1;
		lastNum= curBlock*perBlock;
		
		if(curBlock == totalBlock) {
			lastNum = totalPage;
			
		}
		
	}


	


}
