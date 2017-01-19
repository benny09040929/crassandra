package cassandraDAO

import com.datastax.driver.core.{Cluster, QueryOptions, Session}

/**
 * Created by TB690275 on 2017/1/19.
 */
class Cassandra {

  protected def cassandra_session:Session = {
    val cluster = new Cluster.Builder().
      addContactPoint("192.168.56.130").         //       local docker cassandra
      withPort(9042).
      withQueryOptions(new QueryOptions()
      .setConsistencyLevel(QueryOptions.DEFAULT_CONSISTENCY_LEVEL)
      ).build
    val session = cluster.connect()
    session
  }

}
