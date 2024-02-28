public class BrokenClass {
    public BrokenClass() {
        try {
            throwException();
        } catch (Exception e) {
            // I'm violating my one rule ... for now
        }
    }

    private void throwException() throws ArgumentNullException {
        ArgumentNullException.throwIfNull(null, "someVariableName");
    }
}
