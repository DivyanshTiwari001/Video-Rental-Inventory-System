class Video{
        // Properties
        private String videoName;
        private boolean checkOut;
        private int rating;
    
        // Constructor
        Video(String videoName){
            this.videoName = videoName;
            checkOut = false;
            rating  = 0;
        }
    
        // Member Functions
    
        public String getName(){
            return videoName;
        } 
    
        public void doCheckOut(){
            checkOut = true;
        }
    
        public void doReturn(){
            checkOut = false;
        }
    
        public void receiveRating(int rating){
            this.rating = rating;
        }
    
        public int getRating(){
            return rating;
        }
    
        public boolean getCheckOut(){
            return checkOut;
        }
}
