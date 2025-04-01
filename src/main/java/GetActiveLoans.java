import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class GetActiveLoans {
    public static String baseUrl="http://10.195.105.107:9104";

    public static RequestSpecification getLoanIsActiveRequest(){
        return given().baseUri(baseUrl)
                .basePath("/api/Loan/GetActiveLoans")
                .header("Authorization","application/json");

    }
    public static ResponseSpecification getActionLoansResponse(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }
}
