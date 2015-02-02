/**
 * Created by peter on 29/12/14.
 */
import services.PrimeService
import services.ListOfPrimes

def org = params['number']

def primeService = new PrimeService()

def loadPrimes() {

    def entities = ListOfPrimes.findAll { sort asc by "start" }
    logger['root'].info("Loaded " + entities.size() + " chunk of data")
    logger['root'].info("from ALL " + ListOfPrimes.count() + " entities")

    def primes = entities.collect { it.list }.flatten()

    primes
}

def primes = loadPrimes()

def list = primeService.findPrimes(org, primes)

request['primes'] = list
if (!localMode) request['geo'] = geo

forward '/WEB-INF/pages/prime.gtpl'






