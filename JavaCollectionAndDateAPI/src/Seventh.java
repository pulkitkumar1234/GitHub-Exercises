import java.sql.SQLOutput;
import java.util.Stack;

class SpecialStack<T> {
    private final int MAX;
    private final int MIN;
    private int CURR;
    private T t;
    //Just for Primitive Types
    private Integer minIValue=0;
    private Float minFValue=0.0f;
    private Double minDValue=0.0;
    private Long minLValue=0L;
    //
    private Stack<T> S=new Stack<>();

    public SpecialStack(int max) {
        MAX=max;
        MIN=0;
        CURR=MIN;
    }

    public boolean push(T t) {
        this.t=t;
        if(CURR<MAX) {
            /**** Minimum Value Finding ****/
            if(t instanceof Integer) {
                if(minIValue==0) {
                    minIValue=(Integer) t;
                    System.out.println(minIValue);
                } else {
                    if(minIValue>(Integer) t) {
                        minIValue=(Integer) t;
                        System.out.println(minIValue);
                    }
                }
            } else if(t instanceof Float) {
                if(minFValue==0) {
                    minFValue=(Float)t;
                } else {
                    if(minFValue>(Float) t) {
                        minFValue=(Float) t;
                    }
                }
            } else if(t instanceof Long) {
                if(minLValue==0) {
                    minLValue=(Long)t;
                } else {
                    if(minLValue>(Long)t) {
                        minLValue=(Long)t;
                    }
                }
            } else if(t instanceof Double) {
                if(minDValue==0) {
                    minDValue=(Double) t;
                } else {
                    if(minDValue>(Double) t) {
                        minDValue=(Double) t;
                    }
                }
            }
            /****                       ****/
            S.addElement(t);
            CURR++;
            return true;
        } else {
            return false;
        }
    }

    public boolean pop() {
        if(CURR==MIN) {
            return false;
        } else {
            S.removeElement(CURR);
            CURR--;
            return true;
        }
    }

    public boolean isFull() {
        if(CURR==MAX) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if(CURR==MIN) {
            return true;
        } else {
            return false;
        }
    }

    public T getMin() {
        if(CURR==MIN) {
            return null;
        } else {
            if(t instanceof Integer) {
                return (T)minIValue;
            } else if (t instanceof Float) {
                return (T)minFValue;
            } else if(t instanceof Double) {
                return (T)minDValue;
            } else if(t instanceof Long) {
                return (T)minLValue;
            }
        }
        return null;
    }

}

class Seventh {

    public static void main(String[] args) {

        SpecialStack<Integer> specialStack=new SpecialStack<>(5);
        System.out.println("Is Stack Empty: "+specialStack.isEmpty());
        specialStack.push(45);
        specialStack.push(25);
        System.out.println("Is Stack Empty: "+specialStack.isEmpty());
        System.out.println("Is Stack Full: "+specialStack.isFull());
        specialStack.push(45);
        specialStack.push(65);
        specialStack.push(11);
        System.out.println("Is Stack Full: "+specialStack.isFull());
        boolean t=specialStack.push(22);
        System.out.println("Status: "+t);
        System.out.println((Integer)specialStack.getMin());
    }

}
