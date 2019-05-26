package bomberman;

import bomberman.attributes.CellEntity;
import bomberman.attributes.Interactible;

import java.util.Arrays;

public class Power implements CellEntity, Interactible {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    InteractionExecuter interactions = new InteractionExecuter(
            Arrays.asList(
                    new Interaction<>(Bomberman.class, bomberman -> bomberman.getPower(this))
            )
    );

    public void interactWith(CellEntity anotherEntity) {
        interactions.execute(anotherEntity);
    }
}
