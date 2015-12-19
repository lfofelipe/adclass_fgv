package adclass2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fgv.dao.DAOException;
import br.com.fgv.dao.UsuarioDAO;
import br.com.fgv.entidade.Usuario;
import br.com.fgv.service.ServiceException;
import br.com.fgv.service.UsuarioService;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration(defaultRollback=true, transactionManager="transactionManager")
public class TestUsuarioService {
	@Autowired
	UsuarioService usuarioService;

	@Autowired
	@Qualifier("usuarioDAOJPA")
	UsuarioDAO usuDAO;
	
	@Test(expected=ServiceException.class)
	public void TestNaoDeveSalvar() throws ServiceException, DAOException {
		Usuario usu = new Usuario();
		usu.setLogin("lols");
		usu.setNome("lelele");
		usu.setSenha("luis931120");

		usuDAO.salvar(usu);
		
		usuarioService.salvar(usu);

	}
	@Test
	public void TestDeveSalvar() throws ServiceException {
		Usuario usu = new Usuario();
		usu.setLogin("test11");
		usu.setNome("lelelea");
		usu.setSenha("luis931120");

	
		
		usuarioService.salvar(usu);
		

	}
	

}
