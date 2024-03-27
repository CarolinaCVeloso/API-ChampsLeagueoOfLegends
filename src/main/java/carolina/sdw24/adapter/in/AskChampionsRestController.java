package carolina.sdw24.adapter.in;

import carolina.sdw24.application.AskChampionsUseCase;
import carolina.sdw24.application.ListChampionsUseCase;
import carolina.sdw24.domain.model.Champion;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Campeões", description = "Endpoints do domínio de campeões do League of Legends")
@RestController
@RequestMapping("/champions")

public record AskChampionsRestController(AskChampionsUseCase useCase) {

    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request){
        String answer = useCase.askChampion(championId,request.question());
        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question){}
    public record AskChampionResponse(String answer){}
}
