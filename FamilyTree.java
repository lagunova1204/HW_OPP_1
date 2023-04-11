import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> FamilyTree;

    public FamilyTree() {
        this.FamilyTree = new ArrayList<Human>();
    }

    public void addHuman(Human human) {
        this.FamilyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChild(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChild(human);
        }
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("Генеалогическое древо состоит из: \n");
        for (Human human : FamilyTree) {
            stb.append(human).append("\n");
        }
        return stb.toString();
    }

    public void printChildren() {
        for (Human humanTemp : FamilyTree) {
            if (humanTemp.getChildren().isEmpty()) {
                System.out.printf("%s (%d) не имеет детей!\n ", humanTemp.getFullName(), humanTemp.getBirthYear());
            } else {
                System.out.printf("%s (%d) имеет следующих детей:\n %s\n", humanTemp.getFullName(), humanTemp.getBirthYear(), humanTemp.getChildren());
            }
        }
    }
}