import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GetActiveLoansCall {
    RequestSpecification requestSpecificationActiveLoans = GetActiveLoans.getLoanIsActiveRequest();
    public Map<String,String> getActiveLoans() {
        List<Map<String,Object>> response =  requestSpecificationActiveLoans
                .when()
                .get()
                .then()
                .spec(GetActiveLoans.getActionLoansResponse())
                .extract()
                .body()
                .as(new TypeRef<List<Map<String,Object>>>() {});

        Map<String,String> apiData=new HashMap<>();
        for (Map<String, Object> loan :response ){
            apiData.put(loan.get("identifier").toString(),loan.get("loanStatus").toString());

        }
        return apiData;
    }
    }





