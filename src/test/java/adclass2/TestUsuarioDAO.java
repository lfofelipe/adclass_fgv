package adclass2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fgv.dao.UsuarioDAO;
import br.com.fgv.dao.UsuarioDAOJPA;
import br.com.fgv.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration
public class TestUsuarioDAO {
	
	EntityManager em;
	ClassPathXmlApplicationContext ctx;
	@Autowired
	UsuarioDAO usuDAO;	
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext();
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("EntityManagerFactory");
		em = emf.createEntityManager();
		usuDAO = new UsuarioDAOJPA(em);
	}
	@After
	public void finaliza(){
		ctx.close();
	}
	
	@Test
	public void TestSalvar(){
		Usuario usu = new Usuario();
		usu.setLogin("lols");
		usu.setNome("lelele");
		usu.setSenha("luis931120");

		Usuario u = usuDAO.salvar(usu);
		System.out.println(u);
	}
}
