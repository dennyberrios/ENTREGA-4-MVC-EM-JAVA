package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospedagemDao;
import model.Hospedagem;

@WebServlet("/HospedagemUpdate")
public class HospedagemFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HospedagemFindAndUpdate() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int hospedagemId = Integer.parseInt(request.getParameter("hospedagemId"));
		Hospedagem hospedagem = HospedagemDao.findByPk(hospedagemId);
		
		request.setAttribute("hospedagem", hospedagem);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("hospedagemUpdate.jsp");
		requestDispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Hospedagem hospedagem = new Hospedagem();

		hospedagem.setNomeHotel(request.getParameter("nomeHotel"));
		hospedagem.setEndereco(request.getParameter("endereco"));
		hospedagem.setEstado(request.getParameter("estado"));
		hospedagem.setValor(request.getParameter("valor"));
		hospedagem.setCheckIn(request.getParameter("checkIn"));
		hospedagem.setCheckOut(request.getParameter("checkOut"));
		hospedagem.setTelefoneHotel(request.getParameter("telefoneHotel"));
		hospedagem.setId(Integer.parseInt(request.getParameter("id")));
		
		HospedagemDao.update(hospedagem);
		
		HospedagemCreateEndFind hospedagemCreateEndFind = new HospedagemCreateEndFind();
		hospedagemCreateEndFind.doGet(request, response);

	}

}
