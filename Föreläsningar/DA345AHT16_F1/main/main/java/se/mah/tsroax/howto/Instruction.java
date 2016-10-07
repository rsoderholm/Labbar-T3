package se.mah.tsroax.howto;

/**
 * Created by tsroax on 28/08/16.
 */
public class Instruction {
    private String whatToDo;
    private String content;

    public Instruction(String whatToDo, String content) {
        this.whatToDo = whatToDo;
        this.content = content;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public String getContent() {
        return content;
    }
}
