package semanticlib;
/**
  * SemType implements a representation of types for supporting
  * typechecking of simple languages.
  */

public interface SemType {
  public static final SemType intType = new IntType();
  public static final SemType booleanType = new BooleanType();
  public static final SemType unknownType = new UnknownType();
  
  static class IntType implements SemType {
    public String toString() { return "int"; }
  }
  static class BooleanType implements SemType {
    public String toString() { return "boolean"; }
  }
  static class UnknownType implements SemType {
    public String toString() { return "unknown"; }
  }
}
