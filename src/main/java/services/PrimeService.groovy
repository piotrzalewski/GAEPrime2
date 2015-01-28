package services

/**
 * Created by peter on 27/01/15.
 */
class PrimeService {
    def findPrimes(org,primes) {
//        def primes = loadPrimes()
        BigInteger number = org as BigInteger
        BigDecimal max = Math.sqrt(number) + 1

        def list = []
        def a = 0
        def p = primes[a]
        while (p < max && number > 1) {
            p = primes[a]
            if(!p) return [-1]
            while (number % p == 0) {
                list.add(p)
                number = number / p
            }
            a++
        }
        if (number > 1) list.add(number)
        list
    }

    def getTableOfPrimes(min, max) {
        def list = min..max
        def primes = list.findAll { x -> (2..Math.sqrt(x)).every { x % it != 0 } }
        if (min <= 2) primes = [2, *primes]
        primes
    }
}
