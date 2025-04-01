import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Steps {
    public static void compareLoansStatus() throws SQLException, ClassNotFoundException, IOException {
        GetActiveLoansCall getActiveLoansCall = new GetActiveLoansCall();
        QueryOfSql queryOfSql = new QueryOfSql();
        Map<String, String> apiActiveLoans = getActiveLoansCall.getActiveLoans();
        Map<String, String> dBActiveLoans = queryOfSql.getActiveLoans();

        List<String> misMatchedLoans = new ArrayList<>();
        dBActiveLoans.forEach((dBLoanId, dBStatus) -> {
            String apiStatus = apiActiveLoans.get(dBLoanId);
            if (!dBStatus.equals(apiStatus)) {
                String message = String.format("LoanId: %s, DBStatus: %s, APIStatus: %s", dBLoanId, dBStatus, apiStatus);
                misMatchedLoans.add(message);
            }
        });
        if (misMatchedLoans.size() > 0) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("MismatchedLoans.txt"));
            for (String misMatchedLoan : misMatchedLoans) {
                writer.write(misMatchedLoan);
                writer.newLine();
            }
            writer.flush();
            System.out.println("MistMatch loan count: " + misMatchedLoans.size());
        }
        Assert.assertTrue(misMatchedLoans.isEmpty());


    }
}
