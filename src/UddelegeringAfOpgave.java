import java.util.Random;

public class UddelegeringAfOpgave {
    public static void main(String[] args) {
        System.out.println(hvemSkalGoereDet());
    }

    public static int getTal() {
        Random random = new Random();
        return random.nextInt(15 + 1);
    }

    public static String hvemSkalGoereDet() {
        int tal = getTal();
        if (tal <= 5) {
            return "Jens";
        } else if (tal > 5 && tal <= 10) {
            return "Mikkel"; }
        else {
            return "Mazza";
        }
    }
}

