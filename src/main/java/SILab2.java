import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//http://graphonline.ru/en/?graph=VnlFneKePotWltJp
class Angle {
    int degrees;
    int minutes;
    int seconds;

    public Angle(int degrees, int minutes, int seconds) {
        this.degrees = degrees;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getDegrees() {
        return degrees;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {



    public List<Integer> function(List<Angle> angleList) {
        List<Integer> result = new ArrayList<>(); // 0

        for(int i = 0; i < angleList.size(); i++) { // 1
            int deg = angleList.get(i).getDegrees(); //2
            int min = angleList.get(i).getMinutes(); //2
            int sec = angleList.get(i).getSeconds(); //2
            if (deg >= 0 && deg < 360) { //3
                if (min < 0 || min > 59) //4
                    throw new RuntimeException("The minutes of the angle are not valid!"); //5
                else {
                    if (sec < 0 || sec > 59) //6
                        throw new RuntimeException("The seconds of the angle are not valid"); //7
                    else
                        result.add(deg * 3600 + min * 60 + sec); //8
                }
            } else if (deg == 360) { //9
                if (min == 0 && sec == 0) //10
                    result.add(deg * 3600 + min * 60 + sec); //11
                else
                    throw new RuntimeException("The angle is greater then the maximum"); //12
            } else {
                throw new RuntimeException("The angle is smaller or greater then the minimum"); //13
            }
        }
        return result; //SUM

    } //EXIT
}

