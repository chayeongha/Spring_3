package com.cyh.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.s3.model.board.NoticeVO;
import com.cyh.s3.service.board.NoticeService;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	
	//첫화면이 LIST    : /notice/noticeList  method :GET  
	//view:   /WEB-INF/views/notice/noticeList.jsp
	
	@RequestMapping("noticeList")
	public void noticeList(Model model) throws Exception{
		
        List<NoticeVO> ar=	noticeService.noticeList();
		model.addAttribute("list",ar);
		
	}
	
	//noticeSelect
	@RequestMapping(value="noticeSelect" , method = {RequestMethod.GET})
	public ModelAndView noticeSelect(int num) throws Exception{
		
		NoticeVO noticeVO  = new NoticeVO();
		
		noticeVO =noticeService.noticeSelect(num);
		
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("dto", noticeVO);
		
		mv.setViewName("notice/noticeSelect");
		
		return mv;
	}
	
	//noticeWrite
	@RequestMapping(value="noticeWrite", method= {RequestMethod.POST} )
	public ModelAndView noticeWrite(NoticeVO noticeVO)throws Exception {
			int result = noticeService.noticeWrite(noticeVO);
		
			ModelAndView mv= new ModelAndView();
			
			String msg= "실패";
			if (result==1) {
				msg="성공";
				
			}
			mv.addObject("msg", msg);
			mv.addObject("path","noticeList");
			mv.setViewName("common/common_result");
			
				
		
		return  mv;
		
	}
	
	@RequestMapping(value="noticeWrite" ,method= {RequestMethod.GET})
	public void noticeWrite()throws Exception{
		
	
	}
	
	//noticeUpdate
	@RequestMapping(value="noticeUpdate", method= {RequestMethod.GET})
	public NoticeVO noticeUpdate(int num ,Model model) throws Exception{
		
	       NoticeVO noticeVO  =noticeService.noticeSelect(num);
	       	
	       model.addAttribute("dto", noticeVO);
	       return noticeVO;
	}
	
	@RequestMapping(value="noticeUpdate" ,  method= {RequestMethod.POST})
	public ModelAndView noticeUpdate(NoticeVO noticeVO ) throws Exception{
		int result =noticeService.noticeUpdate(noticeVO);
		String msg= "실패";
		
		ModelAndView mv= new ModelAndView();
		if(result==1) {
		msg="성공";
	
		}
		mv.addObject("msg", msg);
		mv.addObject("path","noticeList");
		mv.setViewName("common/common_result");
		
		
		return mv;
		
	}
	@RequestMapping(value= "noticeDelete")
	public ModelAndView noticeDelete(int num) throws Exception{
		
	int result	=noticeService.noticeDelete(num);
		
	String msg= "실패";
	
	ModelAndView mv= new ModelAndView();
	if(result == 1) {
		
		msg="성공";
	}
	mv.addObject("msg", msg);
	mv.addObject("path", "noticeList");
	mv.setViewName("common/common_result");
	
	return mv;
	
		
		
	}
	
	
	
	
}
