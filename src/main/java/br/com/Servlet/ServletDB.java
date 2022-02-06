package br.com.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.entidade.User;
import br.com.entidade.UserDAO;


/**
 * Servlet implementation class ServletDB
 */
@WebServlet("/ServletDB")
public class ServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDB() {
        super();
        // TODO Auto-generated constructor stub  
        dao = new UserDAO(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		String id = request.getParameter("id");
		String telefone = request.getParameter("telefone");
		
		String option = request.getParameter("option");
		if (option == null) {
			option = "qualquer coisa";
			}
		
		if(option.equals("insertForm")) {
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}else if (option.equals("indexfrm")) {
			request.getRequestDispatcher("/").forward(request, response);
		
		}else if (option.equals("updateForm")) {
			Integer id1 = Integer.parseInt(id);
			User userBuscar=  dao.buscarUser(id1);
			request.setAttribute("user", userBuscar);
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}else if (option.equals("update")) {
			if ((pais != null) && (nome != null) && (email != null) && (id != null)) {
				if (!nome.equals("")){
					 dao = new UserDAO();
					 Integer id1 = Integer.parseInt(id);
					User user1 = new User(nome, email, telefone,pais);
					user1.setId(id1);
					dao.updateUser(user1);		
				}
			} 
			}else if (option.equals("delete")) {
			if (id != null) {
				 Integer id1 = Integer.parseInt(id);
				dao = new UserDAO();
				dao.removeUser(id1);
			}
		
		}else if (option.equals("insert")) {
			if ((pais != null) && (nome!= null) && (email != null)) {
				if (!nome.equals("")){
				 dao = new UserDAO();
				User user = new User(nome, pais, email, telefone);
				 dao.addUser(user);
				}
			}
			
		}else  {
			dao = new UserDAO();
			ArrayList<User> lista = dao.getListUser();
			request.setAttribute("lista", lista);
			System.out.println(lista);
//			request.setAttribute("lista", dao.getListUser());
			request.setAttribute("lista", dao.getListUser());
			request.getRequestDispatcher("/").forward(request, response);
		}
		
		request.setAttribute("lista", dao.getListUser());
		request.getRequestDispatcher("/").forward(request, response);
	
			
	}

	
	
		
	}
	
	
	
	
