package adclass2;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.fgv.entidade.Usuario;


public class TestSpringBeans {
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
