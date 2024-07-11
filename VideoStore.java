class VideoStore{
    private Video[] store;
    private int capacity = 0;
    private int currentInventorySize = 0;

    VideoStore(int capacity){
        this.capacity = capacity;
        store = new Video[capacity];
    }

    public void addVideo(String videoName){
        if(currentInventorySize == capacity){
            System.err.println("Inventory is Full");
            return;
        }
        store[currentInventorySize++] = new Video(videoName); 
        System.out.println("Video \"" + videoName + "\" added successfully.");
    }

    public void doCheckOut(String videoName){
        for(int i=0;i<currentInventorySize;i++){
            if(store[i].getName().equals(videoName)){
                if(store[i].getCheckOut()==true){
                    System.out.println("\""+videoName + "\" is currently rented to someone.");
                    return;
                }
                store[i].doCheckOut();
                System.out.println("Video \""+videoName+ "\" checked out successfully.");
                break;
            }
        }
    }

    public void doReturn(String videoName){
        for(int i=0;i<currentInventorySize;i++){
            if(store[i].getName().equals(videoName)){
                if(store[i].getCheckOut()==false){
                    System.err.println("Invalid request to return video "+videoName);
                    return;
                }
                store[i].doReturn();
                System.out.println("Video \""+videoName+"\" returned successfully.");
                break;
            }
        }
    }

    public void receiveRating(String videoName,int rating){
        for(int i=0;i<currentInventorySize;i++){
            if(store[i].getName().equals(videoName)){
                store[i].receiveRating(rating);
                System.out.println("Rating \"" +rating+"\" has been mapped to Video \""+videoName+"\"."); 
                break;
            } 
        }
    }

    public void listInventory(){
        System.out.println("-".repeat(84));
        System.out.printf("|%-35s|%-25s|%-20s|\n","Video Name","Checkout Status","Rating");
        System.out.println("-".repeat(84));
        for(int i=0;i<currentInventorySize;i++){
            System.out.printf("|%-35s|%-25s|%-20s|\n",store[i].getName(),store[i].getCheckOut(),store[i].getRating());
            System.out.println("-".repeat(84));
        }
    }
}
