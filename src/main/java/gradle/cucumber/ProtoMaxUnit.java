package gradle.cucumber;

public class ProtoMaxUnit extends Enemy {

    @Override
    public void wasKilledBy(Bomberman bomberman) {
        this.activateSomePower(bomberman);
    }

    public void activateSomePower(Bomberman bomberman){
        long randomValue =  Math.round(Math.random());
        bomberman.clean();
        if(randomValue == 1)
            bomberman.activateWallsJump();
        else
            bomberman.activateMultipleBombs();
    }

}

