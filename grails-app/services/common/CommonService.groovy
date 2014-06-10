package common

class CommonService {

    def sleepRandomTime(int min,int max){
        sleep(new Random().nextInt(max - min) + min)
    }

    def getYesterDayTime (int hours,int min,int sec) {
        def yesterDayTime = (new Date()-1)
        yesterDayTime.setHours(hours)
        yesterDayTime.setMinutes(min)
        yesterDayTime.setSeconds(sec)
        return yesterDayTime
    }

}
