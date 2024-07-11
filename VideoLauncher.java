import java.util.Scanner;

public class VideoLauncher {
    int MAX_CAPACITY = 10;
    public void showMenu(){
        System.out.println("MAIN MENU");
        System.out.println("-".repeat(8));
        System.out.println("-".repeat(8));
        System.out.println("1. Add Video : ");
        System.out.println("2. Check Out Video : ");
        System.out.println("3. Return Video : ");
        System.out.println("4. Receive Rating : ");
        System.out.println("5. List Inventory : ");
        System.out.println("6. Exit : ");
        System.out.print("Enter your chioce (1..6): ");
    }
    public void inventoryHandler(){
        Scanner sc = new Scanner(System.in);
        VideoStore st = new VideoStore(MAX_CAPACITY);
        boolean terminateHandler = false; 
        String name;
        while(!terminateHandler){
            showMenu();
            int choice = sc.nextInt();
            // clearing the buffer
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the video you want to add: ");
                    name = sc.nextLine();
                    st.addVideo(name);
                    break;
                case 2:
                    System.out.print("Enter the name of the video you want to check out: ");
                    name = sc.nextLine();
                    st.doCheckOut(name);
                break;
                case 3:
                    System.out.print("Enter the name of the video you want to return: ");
                    name = sc.nextLine();
                    st.doReturn(name);
                    break;
                case 4:
                    System.out.print("Enter the name of the video you want to rate: ");
                    name = sc.nextLine();
                    System.out.print("Enter the rating for this video: ");
                    int rate = sc.nextInt();
                    st.receiveRating(name, rate);
                    break;
                case 5:
                    st.listInventory();
                    break;
                case 6:
                    terminateHandler = true;
                    break;
            }
            System.out.println("");
        }
        System.out.println("Exiting...!! Thanks for using the application");
        sc.close();
    }
    public static void main(String[] args) {
        VideoLauncher vl = new VideoLauncher();
        vl.inventoryHandler();
    }
    
}
