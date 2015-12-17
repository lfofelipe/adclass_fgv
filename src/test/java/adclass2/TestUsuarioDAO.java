package adclass2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fgv.dao.UsuarioDAO;
import br.com.fgv.entidade.Usuario;

public class TestUsuarioDAO {
	@Test
	public void TestUsuarioDAO(){
		Usuario usu = new Usuario();
		usu.setLogin("lfofelipe");
		usu.setNome("luis felipe");
		usu.setSenha("luis931120");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
	//Usuario usu = (Usuario)ctx.getBean("Usuario");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("EntityManagerFactory");
		EntityManager em = emf.createEntityManager();
		UsuarioDAO usuDAO = new UsuarioDAO(em);
		usuDAO.salvar(usu);
		System.out.println(usuDAO.buscarTodos());
		ctx.close();
	}
}
