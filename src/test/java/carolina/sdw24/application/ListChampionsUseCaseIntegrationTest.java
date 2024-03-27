package carolina.sdw24.application;

import carolina.sdw24.domain.model.Champions;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import java.util.List;

@SpringBootTest
public class ListChampionsUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    public void testListChampions() {
        List<Champions> champions = listChampionsUseCase.findAll();

        Assertions.assertEquals(12,champions.size());
    }
}