package apilinkedin;

import models.Product;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*; // http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html
public class ApiTestsValidating {

    @Test
    public void getCategories(){
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }
// Verifying fields of response
    @Test
    public void getProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        given().
                queryParam("id", 2).
                when().
                get(endpoint).
                then().
                assertThat().
                statusCode(200).
                body("id", equalTo("2")).
                body("name", equalTo("Cross-Back Training Tank")).
                body("description", equalTo("The most awesome tank of 2013!")).
                body("price", equalTo("19.00")).
                body("category_id", equalTo("2")).
                body("category_name", equalTo("Active Wear - Women"));
    }
}
