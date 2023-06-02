public class KeywordsNotes {
    // Fields/Attributes/Properties: 
    // Static fields
    // Non-static fields = instance fields
    
    // Methods
    // Static methods
    // Non-static methods = instance methods

    public class Bicycle {
        // Java Keyword static field and methods
        
        // There is only one value for a static field (each object DOES NOT get it's own value for the field)
        // Calling static methods: className.methodName()
        // Static methods can only modify static fields.
        // Non-Static methods can modify any field (static and non-static).

        private int id;
        
        // Static field are created even if there are no instances (objects) of the class
        private static int numberOfBicycles = 0;

        public Bicycle(int startCadence, int startSpeed, int startGear) {
            numberOfBicycles++;
            id = numberOfBicycles;
        }

        public int getID() {
            return id;
        }

        public static int getNumberOfBicycles() {
            return numberOfBicycles;
        }
    }
    
    @SuppressWarnings("unused")
    public class Person {
        // Java Keyword final
        // Use only for fields, not local variables (usually)
        // final fields cant be modified(have their value changed) once they are initizalized
        private final String birthday = "2/20/98";
        private static final int maxPlayers = 25;
    }
        
}
