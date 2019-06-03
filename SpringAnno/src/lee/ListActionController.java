package lee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;//������̼ǰ� ����Ŭ����
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;//������̼�
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

//��Ʈ�ѷ� Ŭ����=>����ڷκ��� ��û�� �޾Ƽ� ó�����ִ� Ŭ����(=�׼�Ŭ����)
//                          Controller�� ��ӹ޾ƾ� �ȴ�.=>handleRequest �޼��� �̿��ҷ���
//public class ListActionController implements Controller {

@Controller
public class ListActionController {
	
	BoardDAO dao;//BoardDAO dao=new BoardDAO();
	
	@Required
	@Autowired
	public void setDao(BoardDAO dao) { //<property name="dao"><ref bean="id��" /></properety>
		this.dao = dao;
		System.out.println("setDao() ȣ���!(dao)=>"+dao);
	}

	@RequestMapping("/list.do")
	public ModelAndView handleRequest(HttpServletRequest request, 
			                                              HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ListActionController �����!");
		//ArrayList list=dao.list();
		List list=dao.list();
		//--------------------------
		ModelAndView mav=new ModelAndView();//�������� ��Ƽ�->jsp�� �����ϴ� ����
		mav.setViewName("list");//�̵��� ���ϸ� ���-> /list.jsp
		//request.setAttribute("list",list);
		mav.addObject("list",list);//${list(Ű��)}
		return mav;
	}
}




