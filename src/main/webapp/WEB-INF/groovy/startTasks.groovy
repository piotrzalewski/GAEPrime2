/**
 * Created by peter on 27/01/15.
 */

def org = params['number']?: 0
print org
for(a in 0..99) {
    Long num=(org as Long)+a
    queues['create'].add url: "/table/"+num, taskName:"list_"+num, method:"GET"

}
print "OK"