package test.classes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.srnimbus.dao.TelefoneDAO;
import br.com.srnimbus.util.HibernateUtil;

//Classe de teste para mapeamento e conexao Hibernate
public class TesteHibernate {

	public static void main(String[] args) {
		int tel = 0;
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		for (int j = 0; j <= 100; j++) {
			tel = (int) (Math.random() * 100000000);

			TelefoneDAO telefone = new TelefoneDAO();
			telefone.setPrincipal(true);

			telefone.setTelefone(Integer.toString(tel));

			sessao.save(telefone);
			t.commit();
		}
		sessao.close();

	}

}
