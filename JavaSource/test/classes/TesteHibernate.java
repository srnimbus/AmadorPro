package test.classes;

import br.com.srnimbus.dominio.Telefone;
import br.com.srnimbus.util.HibernateUtil;

//Classe de teste para mapeamento e conexao Hibernate
public class TesteHibernate {

	public static void main(String[] args) {
		// for (int j = 0; j <= 100; j++) {

		Telefone telefone = new Telefone();
		// telefone.setPrincipal(true);
		// telefone.setTelefone("12345678");

		// HibernateUtil.insert(telefone);
		// HibernateUtil.update(telefone);
		// HibernateUtil.delete(telefone);

		Telefone telefone2 = (Telefone) (HibernateUtil
				.load(Telefone.class, 208));

		System.out.println(telefone2.getTelefone());

		// }

	}

}
