package test.classes;

import br.com.srnimbus.dominio.Telefone;
import br.com.srnimbus.util.HibernateUtil;

//Classe de teste para mapeamento e conexao Hibernate
public class TesteHibernate {

	public static void main(String[] args) {
		//for (int j = 0; j <= 100; j++) {

			Telefone telefone = new Telefone();
			telefone.setId(207);
			

			//HibernateUtil.insert(telefone);
			//HibernateUtil.update(telefone);
			HibernateUtil.delete(telefone);
			
			

		//}

	}

}
