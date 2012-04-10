package test.classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDataBase {

	public void desativarCooperativas(String cooperativa) throws DataBaseException {

		Connection conn = null;
		Statement statement = null;
		String query = "delete from stb_BancodadosAdminServidor where numcooperativa =" + cooperativa;

		try {
			SQLServerDataSource ds = criaDataSource();
			conn = obtemConexao(ds);
			statement = conn.createStatement();
			statement.execute(query);
			Cooperativas.getInstance().removeCooperativa(cooperativa);
		} catch (SQLException sqe) {
			sqe.printStackTrace();
			throw new DataBaseException("Erro ao descadastrar cooperativa ");
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqe) {
				sqe.printStackTrace();
				throw new DataBaseException("Erro ao fechar conexao com servidor ", sqe.getErrorCode());
			}
		}
	}

	private Connection obtemConexao(SQLServerDataSource ds) {
		return null;
	}

	private SQLServerDataSource criaDataSource() {
		return null;
	}

}
