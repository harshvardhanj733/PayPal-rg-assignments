class Super {
    static void show() {
        System.out.println("super class show method");
    }

    static class StaticMethods {
        void show() {
            System.out.println("sub class show method");
        }
    }

    public static void main(String[] args) {
        Super.show();
        //This will call the static method in Super class
        //So this will print "super class show method"

        new Super.StaticMethods().show();
        //This will first create a StaticMethods object
        //Then it will call the show method in StaticMethods class
        //So this will print "sub class show method"
    }
}
