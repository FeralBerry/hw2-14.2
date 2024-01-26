public class Main {
    public static void main(String[] args) throws IndexAddExceptions, NotHaveItemExceptions {
        StringArray stringArray = new StringArray();
        System.out.println(stringArray.add("Привет мир!"));
        System.out.println(stringArray.add("Привет мир"));
        System.out.println(stringArray.add("Привет мир"));
        System.out.println(stringArray.add("Привет мир"));
        System.out.println(stringArray.add(0,"Привет мир"));
        System.out.println(stringArray.add(3,"3"));
        System.out.println(stringArray.remove("3"));
        System.out.println(stringArray.remove(1));
        StringArray stringList = new StringArray(){};
        System.out.println(stringArray.equals(stringList));
    }
}