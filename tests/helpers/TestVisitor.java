package tests.helpers;

import java.util.List;

import ast.AST;
import visitor.ASTVisitor;

public class TestVisitor extends ASTVisitor {
    private List<AST> expected;
    private int index;
    private int count;

    public TestVisitor(final List<AST> expected) {
        this.expected = expected;
        this.index = 0;
        this.count = 0;
    }

    private Object test(AST t) {
        try {
            expected.get(index).getClass().cast(t);

            index++;
            count ++;
            return testKids(t);
        } catch (ClassCastException exception) {
            return String.format(
                "Expected [%s] but got [%s]", 
                expected.get(index).getClass().getSimpleName(),
                t.getClass().getSimpleName()
            );
        }
    }

    private Object testKids(AST t) {
        for (AST kid : t.getKids()) {
            Object result = kid.accept(this);

            if(result != null) {
                return result;
            }
        }

        return null;
    }

    @Override
    public Object visitProgramTree(AST t) {
        return count == this.expected.size() ? test(t) : String.format("Expected [%d] nodes but counted [%d] nodes", this.expected.size(), this.count);
    }

    @Override
    public Object visitBlockTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitFunctionDeclTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitCallTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitDeclTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitIntTypeTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitBoolTypeTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitFormalsTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitActualArgsTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitIfTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitWhileTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitReturnTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitAssignTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitIntTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitIdTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitRelOpTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitAddOpTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitMultOpTree(AST t) {
        return test(t);
    }
 
    @Override
    public Object visitScientificTypeTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitStringTypeTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitScientificTree(AST t) {
        return test(t);
    }

    @Override 
    public Object visitStringTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitForAllTree(AST t) {
        return test(t);
    }

    @Override
    public Object visitRangeExpTree(AST t) {
        return test(t);
    }
}
