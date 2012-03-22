package br.com.srnimbus.amadorpro.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TELEFONE")
@SequenceGenerator(name = "TB_TELEFONE_ID_TELEFONE_seq", sequenceName = "TB_TELEFONE_ID_TELEFONE_seq", allocationSize = 1)
public class Telefone {

	// "TB_TELEFONE","ID_TELEFONE"
	// "TB_TELEFONE","PRINCIPAL"
	// "TB_TELEFONE","DESC_TELEFONE"

// <vai em cima da declaracao da classe>  @NamedNativeQuery(name = "chaos", query = "select id, size, name, lower( nickname ) as nickname from CHAOS where id= ?", resultClass = Telefone.class)
//	@SQLInsert(sql = "INSERT INTO CHAOS(size, name, nickname, id) VALUES(?,upper(?),?,?)")
//	@SQLUpdate(sql = "UPDATE CHAOS SET size = ?, name = upper(?), nickname = ? WHERE id = ?")
//	@SQLDelete(sql = "DELETE CHAOS WHERE id = ?")
//	@SQLDeleteAll(sql = "DELETE CHAOS")
//	@Loader(namedQuery = "chaos")
	
	
//	@NamedQuery(name="night.moreRecentThan", query="select n from Night n where n.date >= :date")
//	public class Night {
//	    ...
//	}
//
//	public class MyDao {
//	    doStuff() {
//	        Query q = s.getNamedQuery("night.moreRecentThan");
//	        q.setDate( "date", aMonthAgo );
//	        List results = q.list();
//	        ...
//	    }
//	    ...
//	} 
	
	private int id;
	private boolean principal;
	private String telefone;

	@Id
	@Column(name = "ID_TELEFONE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_TELEFONE_ID_TELEFONE_seq")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "PRINCIPAL")
	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	@Column(name = "DESC_TELEFONE")
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
