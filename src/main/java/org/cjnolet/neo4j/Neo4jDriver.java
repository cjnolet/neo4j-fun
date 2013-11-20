package org.cjnolet.neo4j;

import java.net.URI;
import java.util.ArrayList;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.CouchbaseConnectionFactoryBuilder;

public class Neo4jDriver {
 
  public static void main(String args[]) {

        ArrayList<URI> nodes = new ArrayList<URI>();

    // Add one or more nodes of your cluster (exchange the IP with yours)
    nodes.add(URI.create("http://192.168.1.11:8091/pools"));
    

    // Try to connect to the client
    CouchbaseConnectionFactoryBuilder cfb = new CouchbaseConnectionFactoryBuilder();
    cfb.setOpTimeout(10000); // wait up to 10 seconds for an operation to succeed
    cfb.setOpQueueMaxBlockTime(5000); 
    CouchbaseClient client = null;
    try {
      client = new CouchbaseClient(cfb.buildCouchbaseConnection(nodes, "mybucket", ""));
    } catch (Exception e) {
      System.err.println("Error connecting to Couchbase: " + e.getMessage());
      System.exit(1);
    }
    


    // Set your first document with a key of "hello" and a value of "couchbase!"
    int timeout = 0; // 0 means store forever
    
    long start = System.currentTimeMillis();
    for(int i = 0; i < 10000; i++) {
      client.("hello" + i, timeout, "couchbase!");
      client.get("hello" + i);
    }
    long end = System.currentTimeMillis() - start;

    System.out.println("500000 results in " + end + "ms.");
    // Return the result and cast it to string
    String result = (String)client.get("hello0");
    System.out.println(result);
    
    // Shutdown the client
    client.shutdown();
  }
}
