import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.airhacks.quarkee.application.Application;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class ApplicationServiceTest {



  @Test
  public void addApplicationTest(){
      
      Application app = new Application();
      app.setName("application 1");
      app.setOwner("viglesias");
      app.setUuid(UUID.randomUUID().toString());
      RestAssured.given().header("Content-type","application/json").body(app)
                 .when().post("/applications")
                 .then().statusCode(201);   

  }  


  @Test
  public void findByOwnerApplicationTest(){
	  
	  Application app = new Application();
      app.setName("application 1");
      app.setOwner("viglesias");
      app.setUuid(UUID.randomUUID().toString());
      app.persist();
      
      Application app2 = new Application();
      app2.setName("application 2");
      app2.setOwner("viglesias");
      app2.setUuid(UUID.randomUUID().toString());
	  app2.persist();
      
      String owner = "vmiglesias";
      given()
      	.pathParam("owner",owner)
      	.when().get("/applications/{owner}")
      	.then()
      	   .statusCode(200);
      	   	
  }  
  
  
}