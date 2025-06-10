public class LiskovSubstitutionPrinciple {
    
    // BAD EXAMPLE - Violates LSP
    static class BadBird {
        public void fly() {
            System.out.println("Flying...");
        }
    }
    
    static class BadPenguin extends BadBird {
        @Override
        public void fly() {
            throw new UnsupportedOperationException("Penguins can't fly!"); 
            // VIOLATION: Breaks expected behavior
        }
    }
    
    // GOOD EXAMPLE - Follows LSP
    static abstract class Bird {
        public abstract void move();
    }
    
    static class FlyingBird extends Bird {
        @Override
        public void move() {
            fly();
        }
        
        public void fly() {
            System.out.println("Flying...");
        }
    }
    
    static class NonFlyingBird extends Bird {
        @Override
        public void move() {
            walk();
        }
        
        public void walk() {
            System.out.println("Walking...");
        }
    }
    
    static class Eagle extends FlyingBird {
        // Can substitute FlyingBird anywhere
    }
    
    static class Penguin extends NonFlyingBird {
        // Can substitute NonFlyingBird anywhere
        
        public void swim() {
            System.out.println("Swimming...");
        }
    }

    // Demonstration method
    public static void demonstrateLSP() {
        System.out.println("=== LSP Demonstration ===");
        
        // This works - LSP is followed
        Bird eagle = new Eagle();
        Bird penguin = new Penguin();
        
        eagle.move();   // Output: Flying...
        penguin.move(); // Output: Walking...
        
        // Both can be used interchangeably as Bird objects
        Bird[] birds = {new Eagle(), new Penguin()};
        for (Bird bird : birds) {
            bird.move(); // Works without breaking
        }
        
        System.out.println("\n=== Bad Example (would cause runtime exception) ===");
        // This would break at runtime - LSP violation
        // BadBird badPenguin = new BadPenguin();
        // badPenguin.fly(); // Throws UnsupportedOperationException
    }
    
    public static void main(String[] args) {
        demonstrateLSP();
    }
}
