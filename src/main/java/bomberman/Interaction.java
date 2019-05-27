package bomberman;

import bomberman.attributes.CellEntity;

import java.util.function.Consumer;

public class Interaction<T> {
    private Class<T> klass;
    private Consumer<T> consumer;

    Interaction(Class<T> klass, Consumer<T> consumer){
        this.klass = klass;
        this.consumer = consumer;
    }

    public void execute(CellEntity cellEntity) {
        consumer.accept(klass.cast(cellEntity));
    }

    public boolean appliesTo(CellEntity cellEntity) {
        return klass.isAssignableFrom(cellEntity.getClass());
    }
}
