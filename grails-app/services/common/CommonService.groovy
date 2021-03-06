package common

class CommonService {

    def sleepRandomTime(int min, int max) {
        sleep(new Random().nextInt(max - min) + min)
    }

    def getYesterDayTime(int hours, int min, int sec) {
        def yesterDayTime = (new Date() - 2)
        yesterDayTime.setHours(hours)
        yesterDayTime.setMinutes(min)
        yesterDayTime.setSeconds(sec)
        return yesterDayTime
    }

    def setDateAndTime(String dateStr, int hours, int min, int sec) {
        def date = Date.parse("yyyy-MM-dd", dateStr)
        date.setHours(hours)
        date.setMinutes(min)
        date.setSeconds(sec)
        return date
    }

}
