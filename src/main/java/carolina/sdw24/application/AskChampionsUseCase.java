package carolina.sdw24.application;

import carolina.sdw24.domain.exception.ChampionNotFoundException;
import carolina.sdw24.domain.model.Champion;
import carolina.sdw24.domain.ports.ChampionsRepository;
import carolina.sdw24.domain.ports.GenerativeAiService;

public record AskChampionsUseCase(ChampionsRepository repository, GenerativeAiService genAiApi){
    public String askChampion(Long championId,String question){

        Champion champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);
        String objective = """
                Atue como uma assistente com a habilidade de se comportar como os campeões do jogo League of Legends.
                Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, o nome do Campeão e sua respectiva lore (história):
                Pergunta: %s
                Nome do Campeão: %s
                Função: %s
                Lore (História): %s
                """;

        return genAiApi.generateContent(objective, championContext);
    }
}
