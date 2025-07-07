class Super {
    int num = 20;

    public void display() {
        System.out.println("super class method");
    }
}

public class ThisUse extends Super {
    int num;

    public ThisUse(int num) {
        this.num = num;
    }

    public void display() {
        System.out.println("display method");
    }

    public void show() {
        this.display();
        //This will call the display method of the current object o of ThisUse class, as it overrides the display method in Super class.

        display();
        //This will also call the display method in ThisUse class, as it overrides the display method in Super class.

        System.out.println(this.num);
        //This will print the num variable of the current object o, which is set to 10.
        System.out.println(num);
        //This will also print the num variable of the current object o, which is set to 10.
    }

    public static void main(String[] args) {
        ThisUse o = new ThisUse(10);
        //This will create an object of ThisUse class with the constructor setting num to 10.
        // object o will also inherit num from Super class as 20, but it will override it with its own valur of 10.
        //object o will also inherit display method from Super class, but it will override it with its own display method.
        //So, when we call display method, it will call the display method in ThisUse class.

        o.show();
        //This will call the show method in ThisUse class.
    }
}
