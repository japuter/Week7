import java.util.ArrayList;
import java.util.Scanner;

public class SportsTimeTracker {
    private static final ArrayList<Activity> activities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Sports Time Tracker!");

        do {
            System.out.println("Enter a command (log, view, total, exit):");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "log":
                    logActivity(scanner);
                    break;
                case "view":
                    viewActivities();
                    break;
                case "total":
                    calculateTotalTime();
                    break;
                case "exit":
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }

    private static void logActivity(Scanner scanner) {
        System.out.println("Enter the activity name:");
        String name = scanner.nextLine();
        System.out.println("Enter the duration in minutes:");
        int duration = Integer.parseInt(scanner.nextLine());
        activities.add(new Activity(name, duration));
        System.out.println("Activity logged: " + name + " for " + duration + " minutes.");
    }

    private static void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
            return;
        }
        System.out.println("Logged Activities:");
        for (Activity activity : activities) {
            System.out.println(activity);
        }
    }

    private static void calculateTotalTime() {
        int total = activities.stream().mapToInt(Activity::getDuration).sum();
        System.out.println("Total time spent on sports: " + total + " minutes.");
    }

    static class Activity {
        private final String name;
        private final int duration;

        public Activity(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        public int getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return name + ": " + duration + " minutes";
        }
    }
}
