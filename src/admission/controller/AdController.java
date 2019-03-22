package admission.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admission.bean.GuestData;
import admission.model.SelectAdRecContext;
import admission.model.guest.AdRecGuestModelimpl;

@WebServlet("/AdController")
public class AdController extends HttpServlet {
	private static final long serialVersionUID = 25L;

	ServletContext ctx = null;

	public void init(ServletConfig config) {
		synchronized (this) {
			if (ctx == null) {
				ctx = config.getServletContext();
			}
		}
	}

	//入場者情報を取得
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(true);
		Connection conn = null;
		
		//ゲストの場合
		GuestData guestData = new GuestData();
		guestData.setName(request.getParameter("adName"));
		guestData.setPost(request.getParameter("adPost"));
		
		AdRecGuestModelimpl adRecGuestModelimpl = new AdRecGuestModelimpl(guestData);
		//ゲストの入場者情報を設定する
		SelectAdRecContext selectAdRecContext = new  SelectAdRecContext(adRecGuestModelimpl);
		
		boolean resuletset = selectAdRecContext.setAdrecContext();
		response.setContentType("text/html charset=utf-8");
		System.out.println(guestData.getName());
		System.out.println(guestData.getPost());
		
		//異常終了
		if(resuletset == false) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("adin/adin.jsp");
			dispatcher.forward(request, response);
			
		}else {		//正常終了
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/ad/adrec.jsp");
			dispatcher.forward(request, response);
			
		}

	}

}
