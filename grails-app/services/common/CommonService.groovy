package common

class CommonService {

    def sleepRandomTime(int min,int max){
        sleep(new Random().nextInt(max - min) + min)
    }

}
