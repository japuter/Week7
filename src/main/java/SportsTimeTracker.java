import java.util.ArrayList;
import java.util.Scanner;

public class SportsTimeTracker {

    static class Activity {
        String sport;
        int duration; // in minutes
        String date;

        Activity(String sport, int duration, String date) {
            this.sport = sport;
            this.duration = duration;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Sport: " + sport + ", Duration: " + duration + " mins, Date: " + date;
        }
    }

    private ArrayList<Activity> activities = new ArrayList<>();

    public void logActivity(String sport, int duration, String date) {
        activities.add(new Activity(sport, duration, date));
    }

    public void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
        } else {
            for (Activity activity : activities) {
                System.out.println(activity);
            }
        }
    }

    public int calculateTotalTime() {
        int totalTime = 0;
        for (Activity activity : activities) {
            totalTime += activity.duration;
        }
        return totalTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SportsTimeTracker tracker = new SportsTimeTracker();
        while (true) {
            System.out.println("\n1. Log activity\n2. View activities\n3. Calculate total time\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.println("Enter sport name:");
                String sport = sc.nextLine();
                System.out.println("Enter duration (minutes):");
                int duration = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.println("Enter date (YYYY-MM-DD):");
                String date = sc.nextLine();
                tracker.logActivity(sport, duration, date);
                System.out.println("Activity logged.");
            } else if (choice == 2) {
                tracker.viewActivities();
            } else if (choice == 3) {
                int totalTime = tracker.calculateTotalTime();
                System.out.println("Total time spent on sports this week: " + totalTime + " minutes");
            } else if (choice == 4) {
                System.out.println("Exiting application.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
