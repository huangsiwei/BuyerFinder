package buyerfinder

import base.CrawlerService
import group.GroupMemberService

class GroupMemberController {

    GroupMemberService groupMemberService
    CrawlerService crawlerService

    def index() {
//        redirect(action: "demo")


    }

    def queryMoreGroupInfo() {
        String queryKey = params.queryKey
        String queryUrl = "http://www.douban.com/group/search?cat=1019&q=" + queryKey
        //TODO
    }

    def test () {
        def result = crawlerService.basicPageCrawler("http://www.douban.com/group/explore",".channel-group-rec .bd li",[".title",".num"])
    }

    def demo() {

    }

    def showGroupMember() {
        def groupId = params.long("groupId")
        def groupMemberDouMailList = groupMemberService.fetchGroupMemberByGroupId(groupId)
        [groupMemberDouMailList:groupMemberDouMailList]
    }

    def fetchGroupsByCategory () {
        def groupUrlList = [
                "http://www.douban.com/group/explore",
                "http://www.douban.com/group/explore/culture",
                "http://www.douban.com/group/explore/travel",
                "http://www.douban.com/group/explore/ent",
                "http://www.douban.com/group/explore/fashion",
                "http://www.douban.com/group/explore/life",
                "http://www.douban.com/group/explore/tech"
        ]
        groupUrlList.each {
            crawlerService.basicPageCrawler("http://www.douban.com/group/explore",".channel-group-rec .bd li",[".title",".num"])
        }
    }

}
