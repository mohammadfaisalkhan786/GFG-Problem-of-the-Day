
class Solution {
    ArrayList<Integer> maximumValue(Node node) {
       ArrayList<Integer> list = new ArrayList<>();
       if(node == null) 
       return list;
       Queue<Node> q = new LinkedList<>();
       q.add(node);
       while(!q.isEmpty()){
           int size = q.size();
           int max = Integer.MIN_VALUE;
           for(int i =0; i < size; i++){
               Node root = q.poll();
               if(root.left != null) q.add(root.left);
               if(root.right != null) q.add(root.right);
               max = Math.max(max, root.data);
           }
           list.add(max);
       }
       return list;
    }
}
