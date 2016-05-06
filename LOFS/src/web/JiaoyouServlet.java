package web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.basicDao;
import dao.chooseDao;
import dao.noteDao;
import dao.userDao;
import entity.Basic;
import entity.Choose;
import entity.Note;
import entity.User;

public class JiaoyouServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path=request.getRequestURI();
		String action=path.substring(path.lastIndexOf("/"),path.lastIndexOf("."));
		if(action.equals("/login")){
			User user=null;
			userDao dao=new userDao();
			String username=(String)request.getParameter("username");
			String password=(String)request.getParameter("pwd");
			try {
				user=dao.findByName(username);
				if(user!=null&&password.equals(user.getPassword())){
					String pa=this.getServletContext().getRealPath("upload");
					File file=new File(pa+"/pic_"+user.getId());
					file.mkdirs();
					HttpSession session=request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("list.do");
				}else{
					request.setAttribute("login_err", "登陆错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}else if(action.equals("/regist")){
			String number1=request.getParameter("number");
			HttpSession session=request.getSession();
			String number2=(String)session.getAttribute("number");
			if(number2!=null&&!number1.equals(number2)){
				request.setAttribute("checkcode_err", "验证码错误");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
				return;
			}
			String username=request.getParameter("username");
			if(username.equals("")){
				request.setAttribute("name_err", "用户名不能为空");
				RequestDispatcher rd = request.getRequestDispatcher("regist.jsp");
					rd.forward(request, response);
					return;
			}
			String psw1 = request.getParameter("pwd");
			if(psw1.equals("")){
				//提示密码不能为空
			request.setAttribute("psw1_err", "密码不能为空");
			RequestDispatcher rd = request.getRequestDispatcher("regist.jsp");
				rd.forward(request, response);
				return;
			}
			String psw2 = request.getParameter("pwd");
			if(psw2.length()<6){
				//提示密码不能小于6位
			request.setAttribute("psw2_err", "密码不能小于6位");
			RequestDispatcher rd = request.getRequestDispatcher("regist.jsp");
				rd.forward(request, response);
				return;
			}
			String psw = request.getParameter("psw");
			String psww = request.getParameter("pwd");
			if(!psw.equals(psww)){
				//提示两次密码输入不一致
			request.setAttribute("psw_err", "两次输入密码不一致");
			RequestDispatcher rd = request.getRequestDispatcher("regist.jsp");
				rd.forward(request, response);
				return;
			}
			User user=null;
			userDao dao=new userDao();
			try {
				user=dao.findByName(username);
				if(user==null){
					user=new User();
					user.setGendar(request.getParameter("gendar"));
					user.setUsername(username);
					user.setPassword(request.getParameter("pwd"));
					user.setName(request.getParameter("name"));
					user.setAge(Integer.parseInt(request.getParameter("age")));
					user.setPhone(request.getParameter("phone"));
					long id=dao.save(user);
					session.setAttribute("userId", id+"");
					response.sendRedirect("note1.jsp");
				}else{
					request.setAttribute("exist", "exist");
					request.getRequestDispatcher("regist.jsp").
					forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}else if(action.equals("/basic")){
			String stature=request.getParameter("stature");
			String education=request.getParameter("education");
			String marriage=request.getParameter("marriage");
			String salary=request.getParameter("salary");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			String house=request.getParameter("house");
			String car =request.getParameter("car");
			HttpSession session=request.getSession();
			long userId=Long.parseLong((String)session.getAttribute("userId"));
			Basic basic=new Basic();
			basic.setCar(car);
			basic.setUserId(userId);
			basic.setCity(city);
			basic.setProvince(province);
			basic.setEducation(education);
			basic.setHouse(house);
			basic.setMarriage(marriage);
			basic.setSalary(salary);
			basic.setStature(stature);
			basicDao dao=new basicDao();
			try {
				dao.save(basic);
				response.sendRedirect("note2.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(action.equals("/note")){
			String text=request.getParameter("note");
			HttpSession session=request.getSession();
			long userId=Long.parseLong((String)session.getAttribute("userId"));
			noteDao dao=new noteDao();
			Note note=new Note();
			note.setText(text);
			note.setUserId(userId);
			try {
				dao.save(note);
				response.sendRedirect("note3.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/choose")){
			String stature=request.getParameter("stature");
			String education=request.getParameter("education");
			String marriage=request.getParameter("marriage");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			HttpSession session=request.getSession();
			long userId=Long.parseLong((String)session.getAttribute("userId"));
			Choose choose=new Choose();
			choose.setCity(city);
			choose.setEducation(education);
			choose.setProvince(province);
			choose.setMarriage(marriage);
			choose.setStature(stature);
			choose.setUserId(userId);
			chooseDao dao=new chooseDao();
			try {
				dao.save(choose);
				response.sendRedirect("registSuccess.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/list")){
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("user");
			if(user==null){
				response.sendRedirect("login.jsp");
				return;
			}
			userDao dao=new userDao();
			try {
				List<User> users=dao.findAll();
				request.setAttribute("users", users);
				request.getRequestDispatcher("userList.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/detail")){
			HttpSession session=request.getSession();
			long id=Long.parseLong((String)request.getParameter("id"));
//			long id=(Long)request.getAttribute("id");
			User us=(User)session.getAttribute("user");
			if(us==null){
				response.sendRedirect("login.jsp");
				return;
			}
			userDao dao=new userDao();
			try {
				User user=dao.findById(id);
				long userId=user.getId();
				noteDao nDao=new noteDao();
				basicDao bDao=new basicDao();
				chooseDao cDao=new chooseDao();
				Note note=null;
				Basic basic=null;
				Choose choose=null;
				note=nDao.findByUserId(userId);
				basic=bDao.findByUserId(userId);
				choose=cDao.findByUserId(userId);
				session.setAttribute("note", note);
				session.setAttribute("choose", choose);
				session.setAttribute("basic", basic);
				session.setAttribute("id", user.getId());
				session.setAttribute("u", user);
				request.getRequestDispatcher("userDetail.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/logout")){
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		}else if(action.equals("/load")){
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("user");
			if(user==null){
				response.sendRedirect("login.jsp");
				return;
			}
			DiskFileItemFactory   dfif = 
				new DiskFileItemFactory();
			ServletFileUpload sfu = 
				new ServletFileUpload(dfif);
			try {
//				sfu.setFileSizeMax(1024*50);
				ServletContext sctx=getServletContext();
				List<FileItem> items = 
					sfu.parseRequest(request);
				for(int i=0;i<items.size();i++){
					FileItem item = items.get(i);
						String opath = 
							sctx.getRealPath("upload/pic_"+user.getId());
						String fileName=item.getName();
						if(fileName==null||fileName==""){
							response.sendRedirect("detail.do?username="+user.getUsername());
							return;
						}
					//	System.out.println(opath+File.separator+fileName);
					//	fileName = fileName
					//	.substring(fileName.lastIndexOf("/") +1);
						File file = new File(opath+File.separator+fileName);
						item.write(file);
						response.sendRedirect("detail.do?id="+user.getId());
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/noteModi")){
			HttpSession session=request.getSession();
			long id=(Long)session.getAttribute("id");
			String text=request.getParameter("note");
			noteDao dao=new noteDao();
			userDao udao=new userDao();
			try {
				User user=udao.findById(id);
				dao.updateByUserId(id, text);
				response.sendRedirect("detail.do?id="+user.getId());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/detailModi")){
			HttpSession session=request.getSession();
			long id=(Long)session.getAttribute("id");
			userDao udao=new userDao();
			basicDao bdao=new basicDao();
			String phone=request.getParameter("phone");
			String name=request.getParameter("name");
			String stature=request.getParameter("stature");
			String education=request.getParameter("education");
			String marriage=request.getParameter("marriage");
			String salary=request.getParameter("salary");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			String house=request.getParameter("house");
			String car=request.getParameter("car");
			try {
				udao.update(id, name, phone);
				User user=udao.findById(id);
				bdao.update(id, stature, education,
						marriage, salary, province, city, house, car);
				response.sendRedirect("detail.do?id="+user.getId());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/chooseModi")){
			HttpSession session=request.getSession();
			long id=(Long)session.getAttribute("id");
			userDao udao=new userDao();
			chooseDao cdao=new chooseDao();
			String stature=request.getParameter("stature");
			String education=request.getParameter("education");
			String marriage=request.getParameter("marriage");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			try {
				User user=udao.findById(id);
				cdao.update(id, stature, education,
						marriage,province, city);
				response.sendRedirect("detail.do?id="+user.getId());
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}

}
