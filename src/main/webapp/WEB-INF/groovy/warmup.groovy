import services.ListOfPrimes

/**
 * Created by peter on 28/01/15.
 */
def cachePrimes(primes){

    def number_of_chunks=primes.size()/10_000+1

    for(int a=0;a<number_of_chunks;a++){
        memcache['primes'+a]=primes[a*10_000,(a+1)*10_000-1]
    }
    memcache['primes_count']=number_of_chunks;
}

def loadPrimes() {
    def cached=getPrimesFromCache()
    if(cached) return cached

    def entities = ListOfPrimes.findAll { sort asc by "start" }
    def primes = entities.collect { it.list }.flatten()

    cachePrimes(primes)
    primes
}
def getPrimesFromCache(){
    if('primes_count' in memcache){
        def number_of_chunks=memcache['primes_count']
        def primes=[]
        for (int a=0;a<number_of_chunks;a++){
            if('primes'+a in memcache){
                primes.add(memcache['primes'+a])
            }else{
                return null
            }
        }
        primes.flatten()
    }
}
loadPrimes()

print "OK"