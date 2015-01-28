/**
 * Created by peter on 27/01/15.
 */
def org = params['number']
BigInteger number = org as BigInteger
BigDecimal max = Math.sqrt(number)+1

def list = []
int a=2
while ( a < max && number > 1) {
    while (number % a == 0) {
        list.add(a)
        number = number / a
    }
    a++
}
if (number > 1) list.add(number)

request['primes']=list
if (!localMode ) request['geo']=geo
forward '/WEB-INF/pages/prime.gtpl'