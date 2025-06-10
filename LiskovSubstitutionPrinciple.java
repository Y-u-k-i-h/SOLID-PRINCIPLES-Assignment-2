public class LiskovSubstitutionAnimalExample {
    
    // BAD EXAMPLE - Violates LSP
    static class BadAnimal {
        public void makeSound() {
            System.out.println("Generic animal sound");
        }
    }
    
    static class BadFish extends BadAnimal {
        @Override
        public void makeSound() {
            throw new UnsupportedOperationException("Fish don't make sounds!"); 
            // VIOLATION: Breaks expected behavior
        }
    }
    
    // GOOD EXAMPLE - Follows LSP
    static abstract class Animal {
        public abstract void communicate();
    }
    
    static class SoundMakingAnimal extends Animal {
        @Override
        public void communicate() {
            makeSound();
        }
        
        public void makeSound() {
            System.out.println("Making sound...");
        }
    }
    
    static class SilentAnimal extends Animal {
        @Override
        public void communicate() {
            showBodyLanguage();
        }
        
        public void showBodyLanguage() {
            System.out.println("Using body language...");
        }
    }
    
    static class Dog extends SoundMakingAnimal {
        @Override
        public void makeSound() {
            System.out.println("Woof!");
        }
    }
    
    static class Fish extends SilentAnimal {
        @Override
        public void showBodyLanguage() {
            System.out.println("Swimming in patterns...");
        }
    }
    
    // Demonstration method
    public static void demonstrateLSP() {
        System.out.println("=== Good Example - LSP Followed ===");
        
        Animal dog = new Dog();
        Animal fish = new Fish();
        
        dog.communicate();  // Output: Woof!
        fish.communicate(); // Output: Swimming in patterns...
        
        // Both can be used interchangeably
        Animal[] animals = {new Dog(), new Fish()};
        for (Animal animal : animals) {
            animal.communicate(); // Never crashes!
        }
        
        System.out.println("\n=== Bad Example - LSP Violation ===");
        demonstrateBadExample();
    }
    
    public static void demonstrateBadExample() {
        BadAnimal dog = new BadAnimal();
        BadAnimal fish = new BadFish();
        
        System.out.println("Dog works:");
        dog.makeSound(); // Works fine
        
        System.out.println("Fish crashes:");
        try {
            fish.makeSound(); // BOOM!
        } catch (UnsupportedOperationException e) {
            System.out.println("💥 ERROR: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        demonstrateLSP();
    }
}
