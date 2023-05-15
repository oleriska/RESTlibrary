package lt.viko.eif.o.sharapova.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class LibraryHateoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryHateoasApplication.class, args);
    }

}
