package carolina.sdw24;

import carolina.sdw24.application.AskChampionsUseCase;
import carolina.sdw24.application.ListChampionsUseCase;
import carolina.sdw24.domain.ports.ChampionsRepository;
import carolina.sdw24.domain.ports.GenerativeAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository) {
		return new ListChampionsUseCase(repository);
	}
	@Bean
	public AskChampionsUseCase provideAskChampionsUseCase(ChampionsRepository repository,
														  GenerativeAiService genAiService){
		return new AskChampionsUseCase(repository, genAiService);
	}
}
