public class Television {
    private boolean isOn;
    private int volume;
    private int channel = 1;
    private int counter=0;

    private int checker =1;

    public boolean isTelevisionOn() {
        return isOn;
    }

    public void toggleSwitch() {
        isOn = !isOn;
    }
    public void increaseVolume(){
        if(isOn) {
            if(volume>=0 && volume<10){
                     volume++;}
        }
    }
    public void decreaseVolume() {
        if (isOn) {
            if(volume>0 && volume<10){
            volume--;}
        }
    }
    public int getVolume(){
        return volume;
    }
    public void goToPreviousChannel(){

        if(isOn){
                if(channel<30 && channel>1) {
                    channel--;
                    counter=channel;
                    if(channel==1)checker=30;
                }else if(counter<=1){
                    channel = checker;
                    checker--;
                    counter--;
                }
        }
    }
    public void goToNextChannel(){
            if(isOn){
                counter+=1;
                if(counter<30 && counter>0) {
                    channel++;
                }else if(counter>30){
                    checker++;
                    channel = checker ;
                }
            }
    }

    public String goToChannelOfYourChoice(int userChannel){
       String result = "";
        if(userChannel>0 && userChannel<=30) {
            channel = userChannel;
            result += channel;
        }else if(userChannel>30){
            result = String.format("channel %d not found",userChannel);
        }
        return result;
    }
    public int getChannel() {
        if (isOn){
            return channel;
        }else{
            return 1;
        }
    }
}
