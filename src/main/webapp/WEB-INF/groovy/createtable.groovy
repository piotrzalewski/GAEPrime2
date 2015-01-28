/**
 * Created by peter on 27/01/15.
 */
import services.ListOfPrimes
import services.PrimeService

def primeService = new PrimeService()
def org = params['number'] ?: 0

int SIZE = 100_000
Long start = (org as Long) * SIZE


def list = primeService.getTableOfPrimes(start + 1, start + SIZE)
def e = new ListOfPrimes()
e.list = list
e.size = SIZE
e.index = (org as Long)+1
e.start = start
e.save()
log.info("Ended:" + start)



if (!localMode) request['geo'] = geo

forward '/WEB-INF/pages/table.gtpl'
