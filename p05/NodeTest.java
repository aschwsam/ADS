package p05;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
/**
 * Created by stephan on 29.03.17.
 */
public class NodeTest {
    HashMap<String, Node> nodes;
    @Before
    public void setup(){
        nodes=new HashMap<String,Node>();
    }
    @Test
    public void shouldsetEdges(){
        Node myNode=new Node("Zürich",nodes.size());
        nodes.put("Zürich",myNode);
        assertEquals(myNode,nodes.get("Zürich"));
        assertNotEquals(myNode,nodes.get("Zuerich"));
        assertEquals(0,nodes.get("Zürich").getIndex());
    }



}
