package br.edu.ifg.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.dao.AnimalDAO;
import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.dao.UsuarioDAO;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.entity.OrdemServico;
import br.edu.ifg.entity.Usuario;
import br.edu.ifg.exception.ValidacaoException;
import br.edu.ifg.util.Utils;

@WebServlet("/ordem-servico")
public class OrdemServicoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private OrdemServicoDAO ordemServicoDAO;
	private ClienteDAO clienteDAO;
	private AnimalDAO animalDAO;
	private UsuarioDAO usuarioDAO;
	
	public OrdemServicoServlet() {
		this.ordemServicoDAO = new OrdemServicoDAO();
		this.clienteDAO = new ClienteDAO();
		this.animalDAO = new AnimalDAO();
		this.usuarioDAO = new UsuarioDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer clienteId = Integer.valueOf(req.getParameter("clienteId"));
		Integer animalId = Integer.valueOf(req.getParameter("animalId"));
		Date data = Utils.stringToDate(req.getParameter("data"));
		
		if (clienteId == null || animalId == null || data == null) {
			throw new ValidacaoException("Preencha os campos obrigatórios!");
		}
		
		Cliente cliente = this.clienteDAO.encontrar(clienteId);
		Animal animal = this.animalDAO.encontrar(animalId);
		Usuario usuario = this.usuarioDAO.encontrar(1);
		
		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setCliente(cliente);
		ordemServico.setAnimal(animal);
		ordemServico.setDataServico(data);
		
		ordemServico.setDataCad(new Date());
		ordemServico.setUsuarioCad(usuario);
		
		ordemServicoDAO.salvar(ordemServico);
	}



	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Alterar ordem de servico
	}



	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Alterar ordem de servico
	}
}
