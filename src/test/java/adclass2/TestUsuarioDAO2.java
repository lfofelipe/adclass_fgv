package adclass2;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.fgv.dao.DAOException;
import br.com.fgv.dao.UsuarioDAO;
import br.com.fgv.entidade.Usuario;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration
public class TestUsuarioDAO2 {

	@Autowired
	@Qualifier("usuarioDAOJPA")
	UsuarioDAO usuDAO;

	@Test
	public void TestSalvar() {
		Usuario usu = new Usuario();
		usu.setLogin("lols");
		usu.setNome("lelele");
		usu.setSenha("luis931120");

		Usuario u = usuDAO.salvar(usu);
		Assert.assertNotNull(u.getId());
	}

	@Test
	public void TestBuscaPorID() {
		// criando novo usuario
		Usuario usu = new Usuario();
		usu.setLogin("test");
		usu.setNome("test");
		usu.setSenha("test");

		Usuario usuSalvo = usuDAO.salvar(usu);
		Integer idSalvo = usuSalvo.getId();

		Usuario usuBuscado = usuDAO.buscarPorId(idSalvo);
		Assert.assertEquals(usuSalvo, usuBuscado);

	}
	@Test
	@Transactional
	public void TestExcluir() throws DAOException {
		// criando novo usuario
		Usuario usu = new Usuario();
		usu.setLogin("test");
		usu.setNome("test");
		usu.setSenha("test");

		Usuario usuSalvo = usuDAO.salvar(usu);
		//Usuario usuExcluir = usuDAO.buscarPorId(usuSalvo.getId());
		usuDAO.excluir(usuSalvo);
		Usuario usuExcluido = usuDAO.buscarPorId(usuSalvo.getId());

		Assert.assertEquals(usuExcluido , null);
	}
	public void TestTestarTodos(){
		// criando novo usuario
		Usuario usu = new Usuario();
		usu.setLogin("test");
		usu.setNome("test");
		usu.setSenha("test");
		//salvando usuario
		Usuario usuSalvo = usuDAO.salvar(usu);
		//buscar no banco
		List<Usuario> todos = usuDAO.buscarTodos();
		//verificar se é igual
		Assert.assertTrue(todos.size()>0);
	}
}
