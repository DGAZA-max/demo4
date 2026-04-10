package calculator5;

public enum OperatorType {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private String operatorType;

    OperatorType(String operatorType){
        this.operatorType = operatorType;
    }
}
