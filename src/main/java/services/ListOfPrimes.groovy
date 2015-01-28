package services

import groovyx.gaelyk.datastore.Entity
import groovyx.gaelyk.datastore.Indexed
import groovyx.gaelyk.datastore.Key
import groovyx.gaelyk.datastore.Unindexed

/**
 * Created by peter on 02/01/15.
 */
@Entity(unindexed = false)
class ListOfPrimes {
    @Key
    long index
    @Indexed
    long start
    @Indexed
    long size
    @Unindexed
    List<Long> list

}
