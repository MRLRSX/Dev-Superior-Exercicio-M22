package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Conexao;

public class Program_01 {
	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = Conexao.getConnection();
			preparedStatement = connection.prepareStatement(
					"UPDATE seller SET basesalary = basesalary + ? WHERE departmentid = ?",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setDouble(1, 1000.00);
			preparedStatement.setInt(2, 4);

			int rowsAffected = preparedStatement.executeUpdate();

			System.out.println("Done! id: " + rowsAffected);

		} catch (SQLException error) {
			error.printStackTrace();
		} finally {
			Conexao.closeStatement(preparedStatement);
			Conexao.closeResultSet(resultSet);

		}
	}
}
