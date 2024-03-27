package carolina.sdw24.application;

import carolina.sdw24.domain.exception.ChampionNotFoundException;
import carolina.sdw24.domain.model.Champion;
import carolina.sdw24.domain.ports.ChampionsRepository;

public record AskChampionsUseCase(ChampionsRepository repository) {
    public String askChampion(Long championId,String question){

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);
        // TODO : Evoluir a lógica para considerar a integração com IA

        return championContext;
    }
}
