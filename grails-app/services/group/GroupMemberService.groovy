package group

import base.CrawlerService
import common.CommonService
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class GroupMemberService {

    CommonService commonService
    CrawlerService crawlerService

    def fetchGroupMemberByGroupId(long groupId) {
        def rawUrl = "http://www.douban.com/group/" + groupId + "/members?start="
        def groupMemberDouMailList = []
        String selector = ".name a"
        for (int i = 0; i <10 ; i++) {
            def url = rawUrl + 35 * i
            commonService.sleepRandomTime(500,2500)
            Document document = Jsoup.connect(url).timeout(10000).get()
            def groupMemberList = document.select(selector)
            if (groupMemberList.size()<=0) {
                continue
            }
            groupMemberList.each { groupMember ->
                def groupMemberHomePage = groupMember.attr("href")
                def groupMemberId = groupMemberHomePage.split("people/")[1].replaceAll("/","")
                def groupMemberDouMail = "http://www.douban.com/doumail/write?to=" + groupMemberId
                groupMemberDouMailList << groupMemberDouMail
            }
        }
        return groupMemberDouMailList
    }

    def fetchGroupsByCategory () {
        def groupExplore
        def groupCulture
        def groupTravel
        def groupEnt
        def groupFashion
        def groupLife
        def groupTech
    }
}
