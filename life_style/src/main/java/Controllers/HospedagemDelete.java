package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospedagemDao;


@WebServlet("/HospedagemDestroy")
public class HospedagemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HospedagemDelete() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int hospedagemId = Integer.parseInt(request.getParameter("hospedagemId"));
		HospedagemDao.delete(hospedagemId);
		
		HospedagemCreateEndFind hospedagemCreateEndFind = new HospedagemCreateEndFind();
		hospedagemCreateEndFind.doGet(request, response);
		
	}
}
