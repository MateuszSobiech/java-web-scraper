import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("------------------------------");
        System.out.println("1. Załaduj dane podstawowe");
        System.out.println("2. Podaj dane do wyszukania ofert pracy");
        Scanner scanner = new Scanner(System.in);
        String startAnswer = scanner.nextLine();

        if (startAnswer.equals("1")) {
            fistOption();
        } else if (startAnswer.equals("2")) {
            secondOption(scanner);
        } else {
            System.out.println("------------------------------");
            System.out.println("Podano błędną wartość, program został zamknięty");
        }
    }

    public static void fistOption() throws IOException {
        String connectUrl = ConnectUrlService.baseUrl;
        String numberOfOffers = JsoupService.getNumberOfOffers(connectUrl);

        JsoupService.showOffers(connectUrl);
        showEndInfo(connectUrl, numberOfOffers);
    }

    public static void secondOption(Scanner scanner) throws IOException {
        System.out.println("------------------------------");
        System.out.println("Podaj nazwę języka programowania:");
        String language = scanner.nextLine();
        System.out.println("Podaj nazwę miasta: (NIE MOŻE POSIADAĆ POLSKICH ZNAKÓW)");
        String city = scanner.nextLine();

        String connectUrl = new ConnectUrlService(language, city).getConnectUrl();
        String numberOfOffers = JsoupService.getNumberOfOffers(connectUrl);

        JsoupService.showOffers(connectUrl, language);
        showEndInfo(connectUrl, numberOfOffers);
    }

    public static void showEndInfo(String connectUrl, String numberOfOffers) {
        System.out.println("------------------------------");
        System.out.printf("Mamy dla Ciebie %s ofert%n", numberOfOffers);
        System.out.printf("Link: %s%n", connectUrl);
    }
}
