package de.htwsaar.esch.Codeopolis.DomainModel;

public class StringProcessorTestDrive {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();
        processor.add("  String  ");
        processor.add("Test");
        processor.add("filtrage");
        processor.add("ich heiße Valentin");
        processor.add("conversion");

        System.out.println("--- 1. CHAÎNES D'ORIGINE ---");
        processor.forEach(System.out::println);

        System.out.println("\n--- 2. FILTRAGE ---");
        LinkedList<String> plusDeCinq = processor.filter(str -> str.length() > 5);
        System.out.print("Plus de 5 caractères : ");
        plusDeCinq.forEach(s -> System.out.print("[" + s + "] "));
        System.out.println();
        LinkedList<String> commenceMaj = processor.filter(str -> !str.isEmpty() && Character.isUpperCase(str.charAt(0)));
        System.out.print("Commence par une majuscule : ");
        commenceMaj.forEach(s -> System.out.print("[" + s + "] "));
        System.out.println();

        System.out.println("\n--- 3. TRANSFORMATIONS ---");
        processor.applyToAll(String::trim);
        processor.applyToAll(String::toUpperCase);
        System.out.println("Après Trim + Passage en Majuscules :");
        processor.forEach(System.out::println);
        processor.applyToAll(str -> new StringBuilder(str).reverse().toString());
        System.out.println("\nAprès Inversion :");
        processor.forEach(System.out::println);

        System.out.println("\n--- 4. CONVERSIONS ---");
        LinkedList<Integer> longueurs = processor.mapToInt(String::length);
        System.out.print("Longueurs de chaque chaîne : ");
        longueurs.forEach(len -> System.out.print(len + " "));
        System.out.println();
        LinkedList<Integer> compteA = processor.mapToInt(str -> {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == 'A' || c == 'a') count++;
            }
            return count;
        });
        System.out.print("Nombre de 'A' dans chaque chaîne : ");
        compteA.forEach(c -> System.out.print(c + " "));
        System.out.println();

        System.out.println("\n--- 5. AFFICHAGES SPECIFIQUES ---");
        System.out.println("Avec un astérisque devant :");
        processor.forEach(str -> System.out.println(" * " + str));
        System.out.println("\nAvec la longueur entre parenthèses :");
        processor.forEach(str -> System.out.println(str + " (" + str.length() + ")"));
    }
}
