package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDao;
import model.Destino;


@WebServlet("/DestinoUpdate")
public class DestinoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DestinoFindAndUpdate() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int destinoId = Integer.parseInt(request.getParameter("destinoId"));
		Destino destino = DestinoDao.findByPk(destinoId);
		
		request.setAttribute("destino", destino);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("destinoFormUpdate.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Destino destino = new Destino();
		destino.setNome(request.getParameter("nome"));
		destino.setCidade(request.getParameter("cidade"));
		destino.setEstado(request.getParameter("estado"));
		destino.setDataIda(request.getParameter("dataIda"));
		destino.setDataVolta(request.getParameter("dataVolta"));
		destino.setValor(request.getParameter("valor"));
		destino.setId(Integer.parseInt(request.getParameter("id")));
		
		DestinoDao.update(destino);
		
		DestinoCreateAndFind destinoCreateAndFind = new DestinoCreateAndFind();
		destinoCreateAndFind.doGet(request, response);
	}

}
