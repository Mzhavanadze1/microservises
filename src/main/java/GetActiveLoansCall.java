import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class GetActiveLoansCall {
RequestSpecification requestSpecificationActiveLoans=GetActiveLoans.getLoanIsActiveRequest();
public ArrayList<GetActiveLoanModel> getActiveLoans(){
    Response response =requestSpecificationActiveLoans
            .when()
            .get();
response.then().spec(GetActiveLoans.getTransactionsResponse());

ArrayList<GetActiveLoanModel> ActiveLoans=new ArrayList<>();
for(int i=0;i<response.jsonPath().getList("$").size();i++){
    LinkedHashMap<String,Object> IsActive=(LinkedHashMap<String, Object>) response.jsonPath().getList("$").get(i);
    GetActiveLoanModel getActiveLoanModel=new GetActiveLoanModel();
    getActiveLoanModel.setIsActive(IsActive.get("identifier").toString());
    getActiveLoanModel.setLoanId(IsActive.get("loanStatus").toString());
    ActiveLoans.add(getActiveLoanModel);



}
    return ActiveLoans;
}
}
