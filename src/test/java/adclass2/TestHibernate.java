package adclass2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fgv.dao.UsuarioDAO;
import br.com.fgv.entidade.Usuario;

public class TestHibernate {

	public static void main(String[] args) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("adclass2");
		//gerenciador de Entidades
		//EntityManager em = emf.createEntityManager();
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("EntityManagerFactory");
		EntityManager em = emf.createEntityManager();
		
		
		Usuario usu = new Usuario();
		usu.setNome("asdasdr");
		usu.setLogin("clebiru");
		usu.setSenha("77384");
		UsuarioDAO usuDAO = new UsuarioDAO(em);
		//usuDAO.salvar(usu);
		//Usuario usuMod = usuDAO.buscarPorId(2);
		//usuMod.setLogin("outro");
		usuDAO.salvar(usu);
		//usuDAO.excluir(usuMod);
		//System.out.println(usuMod);
		
		ctx.close();
	}

}
