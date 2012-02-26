package test.classes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.srnimbus.dao.TelefoneDAO;
import br.com.srnimbus.util.HibernateUtil;

//Classe de teste para mapeamento e conexao Hibernate
public class TesteHibernate {

	public static void main(String[] args) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		for (int j = 0; j <= 100; j++) {
			Transaction t = sessao.beginTransaction();

			TelefoneDAO telefone = new TelefoneDAO();
			telefone.setPrincipal(true);
			int tel = (int) (Math.random() * 100000000);
			telefone.setTelefone(Integer.toString(tel));

			sessao.save(telefone);
			t.commit();
		}
		sessao.close();

	}

}
