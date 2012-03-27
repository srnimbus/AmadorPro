package test.classes;

import br.com.srnimbus.amadorpro.dominio.Telefone;
import br.com.srnimbus.amadorpro.exception.AmadorProDAOException;
import br.com.srnimbus.amadorpro.util.HibernateUtil;

//Classe de teste para mapeamento e conexao Hibernate
public class TesteHibernate {

	public static void main(String[] args) throws AmadorProDAOException {
		for (int j = 0; j <= 100; j++) {

			Telefone telefone = new Telefone();
			// telefone.setId(208);
			telefone.setPrincipal(false);
			telefone.setTelefone("12345678");

			HibernateUtil.insert(telefone);

		}
		// HibernateUtil.update(telefone);
		// HibernateUtil.delete(telefone);

		// Telefone telefone2 = (Telefone) (HibernateUtil
		// .load(Telefone.class, 208));

		// }

		// List<Object> telefones = null;
		// try {
		// telefones = HibernateUtil.findAll(Endereco.class.getName());
		// } catch (AmadorProException e) {
		// }
		// for (Object tel : telefones)
		// System.out.println(((Telefone) tel).getTelefone());

		// Telefone tel = (Telefone) HibernateUtil.load(Telefone.class, 210);
		// System.out.println(tel.getTelefone());

		// System.out.println(TimeZone.getDefault());

	}
}
