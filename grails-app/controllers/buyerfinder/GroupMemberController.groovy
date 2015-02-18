package buyerfinder

import group.GroupMemberService

class GroupMemberController {

    GroupMemberService groupMemberService

    def index() {
        redirect(action: "demo")
    }

    def demo() {

    }

    def showGroupMember() {
        def groupId = params.long("groupId")
        def groupMemberDouMailList = groupMemberService.fetchGroupMemberByGroupId(groupId)
        [groupMemberDouMailList:groupMemberDouMailList]
    }
}
