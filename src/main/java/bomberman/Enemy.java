package bomberman;

import bomberman.attributes.Burnable;
import bomberman.attributes.CellEntity;
import bomberman.attributes.Interactible;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Enemy implements CellEntity, Burnable, Interactible {

    InteractionExecuter interactions = new InteractionExecuter(
        Arrays.asList(
            new Interaction<>(Bomberman.class, Bomberman::kill)
        )
    );

    public void interactWith(CellEntity anotherEntity) {
        interactions.execute(anotherEntity);
    }

    @Override
    public void burnFromExplosion(Cell cell) {
        cell.remove(this);
    }
}
