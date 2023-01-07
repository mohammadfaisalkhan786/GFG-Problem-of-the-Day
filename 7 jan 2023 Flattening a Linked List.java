class GfG
{
    Node Join(Node x, Node y){
    if(x == null )
        return y;
        if(y == null)
        return x;
        Node Output; 
        if(x.data <=y.data){
            Output = x;
            Output.bottom = Join(x.bottom, y);
        }
        else{
            Output = y;
             Output.bottom = Join(x,y.bottom);
        }
        return Output;
    }
    Node flatten(Node root){
    if(root == null || root.next == null)
    return root;
    root.next = flatten(root.next);
     root = Join(root,root.next);
     return root;
    }
}
