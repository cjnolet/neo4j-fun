package org.cjnolet.neo4j;

import com.orientechnologies.orient.core.db.graph.OGraphDatabase;
import com.tinkerpop.blueprints.GraphQuery;
import com.tinkerpop.blueprints.TransactionalGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Neo4jDriver {
  
  public static void main(String args[]) throws InterruptedException, IOException {
//    
//    // System.setProperty("net.sf.ehcache.skipUpdateCheck", "true");
//    //
//    //
//    // CacheConfiguration cacheConfiguration = new CacheConfiguration();
//    // cacheConfiguration.setName("mycache");
//    // cacheConfiguration.setOverflowToOffHeap(true);
//    //
//    // cacheConfiguration.setMaxBytesLocalHeap(1l);
//    // cacheConfiguration.setMaxBytesLocalOffHeap(1000000000l);
//    //
//    // Cache cache = new Cache(cacheConfiguration);
//    // CacheManager.getInstance().addCache(cache);
//    //
//    // cache.getCacheEventNotificationService().registerListener(new CacheEventListener() {
//    // @Override
//    // public Object clone() throws CloneNotSupportedException {
//    // return super.clone();
//    // }
//    //
//    // @Override
//    // public void notifyElementRemoved(Ehcache ehcache, Element element) throws CacheException {
//    // System.out.println(element.getObjectKey() + " expired");
//    // }
//    //
//    // @Override
//    // public void notifyElementPut(Ehcache ehcache, Element element) throws CacheException {
//    // }
//    //
//    // @Override
//    // public void notifyElementUpdated(Ehcache ehcache, Element element) throws CacheException {
//    // System.out.println(element.getObjectKey() + " expired");
//    // }
//    //
//    // @Override
//    // public void notifyElementExpired(Ehcache ehcache, Element element) {
//    // System.out.println(element.getObjectKey() + " expired");
//    // }
//    //
//    // @Override
//    // public void notifyElementEvicted(Ehcache ehcache, Element element) {
//    // System.out.println(element.getObjectKey() + " expired");
//    // }
//    //
//    // @Override
//    // public void notifyRemoveAll(Ehcache ehcache) {
//    // }
//    //
//    // @Override
//    // public void dispose() {
//    // }
//    // });
//    //
//    // for(int i = 0; i < 500000; i++) {
//    // cache.put(new Element("myid" + i, "myval", false, 0, 1));
//    // }
//    
//    TransactionalGraph graph = new OrientGraph("memory:test", "guest", "guest");
////    OGraphDatabase odb = (OGraphDatabase) ((OrientGraph) graph).getRawGraph();
////    odb.setUseCustomTypes(true);
////    odb.createVertexType("Person");
////    odb.createVertexType("Address");
//    Vertex vPerson = graph.addVertex("class:Person");
//    vPerson.setProperty("firstName", "John");
//    vPerson.setProperty("lastName", "Smith");
//    
//    Vertex vAddress = graph.addVertex("class:Address");
//    vAddress.setProperty("street", "Van Ness Ave.");
//    vAddress.setProperty("city", "San Francisco");
//    vAddress.setProperty("state", "California");
//    
//    long start = System.currentTimeMillis();
//    for(int i = 0; i < 500000; i++) {
//      Vertex v = graph.addVertex("class:Address");
//    }
//    long end = System.currentTimeMillis();
//    
//    System.out.println("Finished adding in " + (end - start) + "ms");
//    
//    start = System.currentTimeMillis();
//    graph.commit();
//    end = System.currentTimeMillis();
//    
//    System.out.println("Finished committing in " + (end - start) + "ms");
//
//    
//    start = System.currentTimeMillis();
//    Iterable<Vertex> query = graph.query().has("street", "Van Ness Ave.").vertices();
//    for(Vertex v : query) {
//      System.out.println(v);
////      v.setProperty("state", "Maryland");
////      graph.removeVertex(v);
//    }
//    end = System.currentTimeMillis();
//    
//    
//    System.out.println("Finished querying in " + (end - start) + "ms");
    
    
    MemcachedClient c=new MemcachedClient(new InetSocketAddress("localhost", 11211));

    // Store a value (async) for one hour
    c.set("someKey", 3600, "myobject");
    // Retrieve a value (synchronously).
    System.out.println(c.get("someKey"));

  }
}
