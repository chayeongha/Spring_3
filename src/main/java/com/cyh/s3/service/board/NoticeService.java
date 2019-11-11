package com.cyh.s3.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cyh.s3.dao.board.NoticeDAO;
import com.cyh.s3.model.board.NoticeVO;

@Service
public class NoticeService {


	@Inject
		private NoticeDAO noticeDAO;
	
	
		public int noticeUpdate(NoticeVO noticeVO) throws Exception{
			
			return noticeDAO.noticeUpdate(noticeVO);
		}
		
	
		public int noticeDelete(int num) throws Exception{
			
		return	noticeDAO.noticeDelete(num);
			
		}
		
		
		
		
		public int noticeWrite(NoticeVO noticeVO) throws Exception{
			
			
		return	noticeDAO.noticeWrite(noticeVO);
			
		}
		
		
		
		public NoticeVO  noticeSelect(int num) throws Exception{
			
			
		return	noticeDAO.noticeSelect(num);
			
		}
	
		//curPage매개변수를 받는다
		public Map<String, Object> noticeList(int curPage)throws Exception{
			int startRow =(curPage-1)*10 + 1;
			int lastRow=(curPage)*10;
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("startRow", startRow);
			map.put("lastRow", lastRow);
		
			//////////////////////////////////////////////////////////////
			//1.총글의 갯수
			int totalCount = noticeDAO.noticeCount();
			
			//2.totalPage는 얼마나있을까??
			int totalPage= totalCount/10;
			if(totalCount%10 != 0) {
				//만약 나머지가 0이아닌수들은 페이지를 1씩 더해준다.
				totalPage++;
			}
			//3. 리턴이 두개이므로
		Map<String, Object> map2= new HashMap<String, Object>();
			map2.put("totalPage", totalPage);
			map2.put("list", noticeDAO.noticeList(map));
			
			return map2;
		}
		
		
		
		
		
}
