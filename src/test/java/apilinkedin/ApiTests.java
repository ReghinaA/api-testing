package apilinkedin;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

/**
    GET request
*/

    @Test
    public void getCategories() {
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

/**
    GET request
*/

    @Test
    public void getProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        var response =
                given().
                        queryParam("id", 2).

                        when().
                        get(endpoint).

                        then();
        response.log().body();
    }

/**
    POST request - we will add a new product - Water Bottle
*/
    @Test
    public void createProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        String body = """
                {
                "name": "Water Bottle",
                "description": "Blue water bottle. Holds 64 ounces",
                "price": 12,
                "category_id": 4
                }
                """;
        var response = given().body(body).when().post(endpoint).then();
        response.log().body(); // we will see log in output
    }


    /**
     * PUT request - we are updating the price (from 12 to 15.04) and description from Blue to Purple-green
     */

    @Test
    public void updateProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/update.php";
        String body = """
                {
                "id": 19,
                "name": "Water Bottle",
                "description": "Purple-green water bottle. Holds 64 ounces",
                "price": 15.04,
                "category_id": 4
                }
                """;
        var response = given().body(body).when().put(endpoint).then();
        response.log().body();
    }

    /**
     * DELETE request - we are deleting the product Water Bottle
     */

    @Test
    public void deleteProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body = """
                {
                "id": 19
                }
                """;
        var response = given().body(body).when().delete(endpoint).then();
        response.log().body();
    }
}

