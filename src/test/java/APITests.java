import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class APITests {
    @Test
    void Test(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        response.getStatusCode();
        System.out.println("Status code "+ response.getStatusCode());
        System.out.println("Respons : "+ response.asString());
        System.out.println("Body : "+ response.getBody().asString());
        System.out.println("Time taken : "+ response.getTime());
        System.out.println("Header : "+response.getHeader("content-type"));

        //add sessions
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

}
