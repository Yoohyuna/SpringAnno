package lee;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.AbstractCommandController;

//public class WriteActionController extends AbstractCommandController {

@Controller
public class WriteActionController{
	
	@Autowired
	BoardDAO dao;
	
	public void setDao(BoardDAO dao) { //<property name="dao"><ref bean="id명" /></properety>
		this.dao = dao;
		System.out.println("setDao() 호출됨!(dao)=>"+dao);
	}
     // @RequestParam("num") String num ->String num=request.getParameter("num")
	//형식) @RequestParam("전달받은 매개변수명") 반환받는 변수자료형 반환받는 변수명
	@RequestMapping("/write.do")
	public ModelAndView test(@RequestParam("title") String title,
			                               @RequestParam("author") String author,
			                               @RequestParam("content") String content) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("WriteActionController 실행됨!");
	
		/*
		String author=request.getParameter("author");
		String content=request.getParamert("content");
		String title=request.getParamert("title");*/
		
		int newNum=dao.getNewNum()+1;
		BoardCommand data=new BoardCommand();
		data.setNum(newNum);//새로 저장할 게시물번호까지 계산이 된 상태에서 저장
		data.setTitle(title);
		data.setAuthor(author);
		data.setContent(content);
		
		dao.write(data);//dao.write(data);
		return new ModelAndView("redirect:/list.do");
	}
}




