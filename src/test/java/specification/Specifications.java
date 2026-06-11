package specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class Specifications {


    public static ResponseSpecification getSuccessSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification badRequestSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }


}
