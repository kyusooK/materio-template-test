package materiotemplate.common;

import io.cucumber.spring.CucumberContextConfiguration;
import materiotemplate.SalesApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { SalesApplication.class })
public class CucumberSpingConfiguration {}
