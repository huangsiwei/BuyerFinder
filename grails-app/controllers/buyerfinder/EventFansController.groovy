package buyerfinder

import eventfan.EventFansService

class EventFansController {

    EventFansService eventFansService

    def index() {
        redirect(action: "demo")
    }

    def demo () {

    }

    def showEventFans () {
        def eventId = params.long("eventId")
        def eventFansDouMailList = eventFansService.fetchEventFansByEventId(eventId)
        [eventFansDouMailList:eventFansDouMailList]
    }
}
