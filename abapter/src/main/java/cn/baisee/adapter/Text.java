package cn.baisee.adapter;

public class Text implements Socket{
    private Grammar grammar;

    public Text(Grammar grammar) {
        this.grammar = grammar;
    }


    public void show() {
        grammar.showshi();
    }
}
