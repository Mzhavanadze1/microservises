import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Test {
    @org.testng.annotations.Test
    public void testApiAndDbLoansAreEqual() throws SQLException, ClassNotFoundException, IOException {
        Steps.compareLoansStatus();
    }

    }

