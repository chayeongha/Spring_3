package com.cyh.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cyh.s3.model.board.QnaVO;
import com.cyh.s3.service.board.QnaService;
import com.cyh.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Inject
	private QnaService qnaService;

	
	@RequestMapping(value = "qnaReply" , method ={RequestMethod.POST} )
	public ModelAndView qnaReply(QnaVO qnaVO) throws Exception{
		
		int result	= qnaService.qnaReply(qnaVO);
		
		ModelAndView mv= new ModelAndView();

		String msg= "실패";
		if (result==1) {
			msg="성공";

		}
		mv.addObject("msg", msg);
		mv.addObject("path","qnaList");
		mv.setViewName("common/common_result");



		return  mv;
	
	}
	
	
	@RequestMapping(value="qnaReply" , method ={RequestMethod.GET})
	public void qnaReply(int num, Model model) throws Exception{
		
		model.addAttribute("num" , num);
		
		
	}
	
	@RequestMapping(value ="qnaSelect" , method ={RequestMethod.GET})
	public void qnaSelect(int num ,Model model) throws Exception{
		
		QnaVO  qnaVO = new QnaVO();
		
		qnaVO= qnaService.qnaSelect(num);
		
		
		 model.addAttribute("dto",qnaVO);
		
		
	}
	

	@RequestMapping(value="qnaWrite" , method = RequestMethod.POST)
	public ModelAndView qnaWrite(QnaVO qnaVO) throws Exception{


		/*테스트 출력이잘되는지... 성공.
		 * System.out.println(qnaVO.getTitle()); System.out.println(qnaVO.getWriter());
		 * System.out.println(qnaVO.getContents());
		 */

		int result = qnaService.qnaWrite(qnaVO);

		ModelAndView mv= new ModelAndView();

		String msg= "실패";
		if (result==1) {
			msg="성공";

		}
		mv.addObject("msg", msg);
		mv.addObject("path","qnaList");
		mv.setViewName("common/common_result");



		return  mv;
		//return "redirect:./qna"
	}


	@RequestMapping(value="qnaWrite" , method = RequestMethod.GET)
	public void qnaWrite() throws Exception{

		//주소는 리턴할게읎다.	
	}



	@RequestMapping(value = "qnaList", method = RequestMethod.GET )
	public ModelAndView qnaList(Pager pager ) throws Exception{


		List<QnaVO> ar =qnaService.qnaList(pager);


		ModelAndView mv =new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("qna/qnaList");

		return mv;
	}



}
