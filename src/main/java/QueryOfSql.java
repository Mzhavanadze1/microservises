import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryOfSql {
    public static String GetActiveLoans = """
                SELECT LoanId,LoanStatusId FROM ListOfBalance.dbo.InsLoan
                where LoanStatusId='1'
                """;



    public List<GetActiveLoanModel> getActiveLoans(String query) throws SQLException, ClassNotFoundException {
        DataBaseAccess dataBaseAccess = new DataBaseAccess();
        dataBaseAccess.connectSQL();
        dataBaseAccess.getInstance().createStatement();
        PreparedStatement preparedStatement = dataBaseAccess.connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<GetActiveLoanModel> dBLoans = new ArrayList<>();
        while (resultSet.next()) {
            GetActiveLoanModel getActiveLoanModel = new GetActiveLoanModel();
            getActiveLoanModel.setLoanId(resultSet.getString("LoanId"));
            getActiveLoanModel.setIsActive(resultSet.getString("LoanStatusId"));
            dBLoans.add(getActiveLoanModel);
        }

        return dBLoans;
    }
}

