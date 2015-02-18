package eventfan

import common.CommonService
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class EventFansService {

    CommonService commonService

    def fetchEventFansByEventId(long eventId) {
        def rawUrl = "http://www.douban.com/event/" + eventId + "/wisher?start="
        def eventFansDouMailList = []
        String selector = ".obu dt .nbg"
        for (int i = 0; i <10 ; i++) {
            def url = rawUrl + 70 * i
            commonService.sleepRandomTime(500,2500)
            Document document = Jsoup.connect(url).timeout(10000).get()
            def eventFansList = document.select(selector)
            if (eventFansList.size()<=0) {
                continue
            }
            eventFansList.each { eventFan ->
                def eventFanHomePage = eventFan.attr("href")
                def eventFanId = eventFanHomePage.split("people/")[1].replaceAll("/","")
                def eventFanDouMail = "http://www.douban.com/doumail/write?to=" + eventFanId
                eventFansDouMailList << eventFanDouMail
            }
        }
        return eventFansDouMailList
    }
}
