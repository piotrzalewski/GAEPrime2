/**
 * Created by peter on 27/01/15.
 */
get "/prime/@number?", forward: "/prime.groovy"

get "/table/@number?", forward: "/createtable.groovy"
get "/prime2/@number?", forward: "/prime2.groovy"
all "/_ah/start", forward: "/start.groovy"
get "/startTasks/@number?", forward: "/startTasks.groovy"
