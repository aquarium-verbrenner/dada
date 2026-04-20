import java.util.*;
import java.util.stream.Collectors;

public class CustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static RequestQueue requestQueue = new RequestQueue();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nKundenservice-Management-System:");
            System.out.println("1. Anfrage hinzufügen");
            System.out.println("2. Nächste Anfrage bearbeiten");
            System.out.println("3. Nächste Anfrage anzeigen");
            System.out.println("4. Anzahl der Anfragen in der Warteschlange anzeigen");
            System.out.println("5. Alle Anfragen anzeigen");
            System.out.println("0. Programm beenden");
            System.out.print("Wählen Sie eine Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addRequest();
                    break;
                case 2:
                    processNextRequest();
                    break;
                case 3:
                    peekNextRequest();
                    break;
                case 4:
                    getQueueSize();
                    break;
                case 5:
                    getAllRequests();
                    break;
                case 0:
                    System.out.println("Programm beendet.");
                    System.exit(0);
                default:
                    System.out.println("Ungültige Option. Bitte versuchen Sie es erneut.");
            }
        }
    }

    private static void addRequest() {
        System.out.print("Anfrage-ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Name des Kunden: ");
        String customerName = scanner.nextLine();
        System.out.print("Details der Anfrage: ");
        String requestDetail = scanner.nextLine();
        System.out.print("Priorität (hoch, mittel, niedrig): ");
        String priority = scanner.nextLine();

        CustomerRequest request = new CustomerRequest(id, customerName, requestDetail, priority);
        requestQueue.addRequest(request);
        System.out.println("Anfrage hinzugefügt: " + request);
    }

    private static void processNextRequest() {
        CustomerRequest request = requestQueue.processNextRequest();
        if (request != null) {
            System.out.println("Bearbeitete Anfrage: " + request);
        } else {
            System.out.println("Keine Anfragen in der Warteschlange.");
        }
    }

    private static void peekNextRequest() {
        CustomerRequest request = requestQueue.peekNextRequest();
        if (request != null) {
            System.out.println("Nächste Anfrage: " + request);
        } else {
            System.out.println("Keine Anfragen in der Warteschlange.");
        }
    }

    private static void getQueueSize() {
        int size = requestQueue.getQueueSize();
        System.out.println("Anzahl der Anfragen in der Warteschlange: " + size);
    }

    private static void getAllRequests() {
        List<CustomerRequest> requests = requestQueue.getAllRequests();
        if (!requests.isEmpty()) {
            System.out.println("Alle Anfragen:");
            requests.forEach(System.out::println);
        } else {
            System.out.println("Keine Anfragen in der Warteschlange.");
        }
    }
}
