package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webApp.TicketsSale;

/**
 * Servlet implementation class Cancel_all_Reservations_s
 */
@WebServlet("/Cancel_all_Reservations_s")
public class Cancel_all_Reservations_s extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cancel_all_Reservations_s() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TicketsSale model = (TicketsSale) getServletContext().getAttribute("kartenverkauf");
		model.cancel_all_reservations();
		request.getRequestDispatcher("Operation_erfolgreich_ausgefuehrt.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
