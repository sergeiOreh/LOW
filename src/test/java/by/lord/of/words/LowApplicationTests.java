package by.lord.of.words;
import by.lord.of.words.config.PostgresContainer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = PostgresContainer.class)
public abstract class LowApplicationTests {

}
