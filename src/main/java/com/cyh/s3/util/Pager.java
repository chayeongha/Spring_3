package com.cyh.s3.util;

public class Pager {
	
	
	private Integer curPage;//현재 페이지 번호

	private Integer perPage;// 블럭 당 페이지 개수
	
	
	//VIEW (jsp)
	
	private Integer startNum;//시작번호
	
	private Integer lastNum;//마지막번호
	
	
	private Integer curBlock;// 현재 블럭 번호
	
	private Integer totalBlock;// 전체 블럭 개수
	
	
	///DB
	
	private Integer startRow; // 시작 row번호 
	
	private Integer lastRow; // 마지막 row번호
	
	
	//List의 kind와 search를 받아온다.
	
	private String kind;
	
	private String search;
	
	////////////////////////////////////////////////////////////////////////////
	
	
	
	public Integer getCurPage() {
		if(curPage == null || curPage == 0) {
			this.curPage = 1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPerPage() {
		if(perPage == null || perPage == 0) {
			this.perPage = 10;
		}
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

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

	public Integer getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	
	////////////////////////////////////////////////////////////////////////////
	
	
	//make row
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage() * this.getPerPage();
	}
	
	
	
	//make page
	
		public void makePage(int totalCount) {
		  //1.	전체글의 갯수를 가져온다.
			
		 //2. 전체 페이지의 수
			int totalPage = totalCount/this.getPerPage();
			if(totalCount%this.getPerPage() != 0) {
				totalPage++;
			}
		 //3. 전체 블럭의 수를구한다.
			//지역변수선언 
			int perBlock=5;
			totalBlock= totalPage/perBlock;
			if(totalPage%perBlock !=0 ) {
				
				totalBlock++;
				
			}
		//4. curPage를 이용해서 현재 블럭번호(curBlock)가 몇번인지 알아야함.
			curBlock = this.getCurPage()/perBlock;
			if(this.getCurPage()%perBlock != 0) {
				curBlock++;
				
			}
			
		//5. curBlock으로 startNum과 lastNum을 구해야함.
			startNum= (curBlock-1)*perBlock+1;
			lastNum= curBlock*perBlock;
			
			if(curBlock == totalBlock) {
				lastNum = totalPage;
				
			}
			
			
			
		}
	
	
	
	
	
	
	

}
