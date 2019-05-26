package bomberman;

import bomberman.attributes.CellEntity;

import java.util.List;

public class InteractionExecuter {
    private List<Interaction> interactions;

    InteractionExecuter(List<Interaction> interactions) {
        this.interactions = interactions;
    }

    void execute(CellEntity cellEntity){
        interactions
            .stream()
            .filter(interaction -> interaction.appliesTo(cellEntity))
            .forEach(interaction -> interaction.execute(cellEntity));
    }
}
