package adclass2;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fgv.dao.UsuarioDAO;
import br.com.fgv.entidade.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration
public class TestSpringBeans {
	@Autowired
	UsuarioDAO usuDAO;
	@Test
	public  void SpringTest() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/springbeans.xml");
	//Usuario usu = (Usuario)ctx.getBean("Usuario");
		BasicDataSource bds = (BasicDataSource) ctx.getBean("DataSourceADC");
	//System.out.println(usu);
		
	System.out.println("login: "+ bds.getUsername()+" senha: "+bds.getPassword());
	ctx.close();
	}

}
