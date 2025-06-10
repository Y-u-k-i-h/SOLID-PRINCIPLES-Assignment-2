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
}
