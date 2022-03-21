import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqresApi {
    static String BASE_URI = "https://reqres.in";
    static private String id;

    @Test
    public void newClient() {
        RestAssured.baseURI = BASE_URI;
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .body("{ \"name\":\"Pepa\",\"job\":\"klicnik\"}")
                .post("/api/users");
        System.out.println(response.prettyPrint());
        assertEquals(response.getStatusCode(), 201, "Status code not 200 but "+response.getStatusCode());
        assertEquals(response.jsonPath().get("name"), "Pepa", "Wrong name saved!");
        id = response.jsonPath().get("id");
        System.out.println(id);
    }

    @Test
    public void getUser() {
        String path = "/api/users/"+id;
        System.out.println(path);
        RestAssured.baseURI = BASE_URI;
        Response response = RestAssured
                .given()
                .get(path);
        System.out.println(response.prettyPrint());
    }

}
