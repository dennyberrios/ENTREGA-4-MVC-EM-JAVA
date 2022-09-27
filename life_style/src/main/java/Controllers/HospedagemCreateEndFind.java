package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospedagemDao;
import model.Hospedagem;

@WebServlet("/CreateEndFindHospedagem")
public class HospedagemCreateEndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HospedagemCreateEndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pesquisa = request.getParameter("pesquisa");
		if(pesquisa == null) {
			pesquisa = "";
		}
		
		List<Hospedagem> hospedagens = HospedagemDao.find(pesquisa);
		request.setAttribute("hospedagens", hospedagens);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaHospedagens.jsp");
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
		
		
		HospedagemDao.create(hospedagem);
		
		
		doGet(request, response);
		
	}

}
