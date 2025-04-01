import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryOfSql {
    public static String GetActiveLoansQuery = """
                SELECT LoanId,LoanStatusId FROM ListOfBalance.dbo.InsLoan
                where LoanStatusId='1'
                """;



    public Map<String,String> getActiveLoans() throws SQLException, ClassNotFoundException {
        DataBaseAccess dataBaseAccess = new DataBaseAccess();
        dataBaseAccess.connectSQL();
        dataBaseAccess.getInstance().createStatement();
        PreparedStatement preparedStatement = dataBaseAccess.connection.prepareStatement(GetActiveLoansQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        Map<String,String> dBData=new HashMap<>();

        while (resultSet.next()) {
            dBData.put(resultSet.getString("LoanId"),resultSet.getString("LoanStatusId"));
        }

        return dBData;
    }
}

