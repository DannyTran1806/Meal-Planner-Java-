package mealplanner.util;


public final class Parsers {
    private Parsers() {}

    public static String[] splitCommaTrim(String raw){
        return raw.split("\\s*,\\s*");
    }

}
