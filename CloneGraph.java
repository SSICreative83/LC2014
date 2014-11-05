/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return dfs(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }
    
    public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        if(node == null)    return null;
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        if(!map.containsKey(node)){
            map.put(node, newNode);
            for(UndirectedGraphNode n : node.neighbors){
                if(!map.containsKey(n))
                    newNode.neighbors.add(dfs(n, map));
                else
                    newNode.neighbors.add(map.get(n));
            }
        }
        
        return newNode;
    }
    
    public UndirectedGraphNode bfs(UndirectedGraphNode root, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
       // if(root == null)    return null;
       return null;
    }
}
