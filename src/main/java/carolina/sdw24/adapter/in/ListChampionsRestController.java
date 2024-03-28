package carolina.sdw24.adapter.in;

import carolina.sdw24.application.ListChampionsUseCase;
import carolina.sdw24.domain.model.Champion;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Campeões", description = "API de campeões do League of Legends")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase) {

    @CrossOrigin
    @GetMapping
    public List<Champion> findAllChampions(){
        return useCase.findAll();
    }
}
