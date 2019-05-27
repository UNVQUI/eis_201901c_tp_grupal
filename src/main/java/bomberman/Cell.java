package bomberman;

import bomberman.attributes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cell {

    private List<CellEntity> entityList = new ArrayList<>();
    private GameMap map;

    public Cell() {}

    public Cell(GameMap map) {
        this.map = map;
    }

    public void put(CellEntity entity) {
        entityList.add(entity);
    }

    public boolean has(CellEntity entity) {
        return entityList.contains(entity);
    }

    public void moveToHere(Cell origin, Bomberman bomberman) {
        if (blocksMovement()) return;
        origin.remove(bomberman);
        this.put(bomberman);
        entitiesInteractWith(bomberman);
    }

    private void entitiesInteractWith(CellEntity bomberman) {
        assignableEntities(Interactible.class)
            .forEach(entity -> entity.interactWith(bomberman));
    }

    boolean blocksMovement() {
        return !assignableEntities(SolidEntity.class).isEmpty();
    }

    void remove(CellEntity entity) {
        entityList.remove(entity);
    }

    public Cell cellAt(Direction direction) {
        return map.getCellAt(direction.add(getPosition()));
    }

    private Position getPosition(){
        return map.getPositionFrom(this);
    }

    public void burnFromExplosion() {
        assignableEntities(Burnable.class)
            .forEach(burnable -> burnable.burnFromExplosion(this));
    }

    <T> List<T> assignableEntities(Class<T> klass){
        return entityList
            .stream()
            .filter(entity -> klass.isAssignableFrom(entity.getClass()))
            .map(klass::cast)
            .collect(Collectors.toList());
    }

    public void tick() {
        assignableEntities(Tickeable.class).forEach(tickeable -> tickeable.tick(this));
    }
}
