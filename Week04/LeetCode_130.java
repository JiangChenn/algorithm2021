public class LeetCode_130 {
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        int m =board.length;//行数
        int n =board[0].length;//列数
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //只遍历该矩阵的边缘，找到边缘中的o,对于边缘上的o，下一步找到和边缘上的o相连的o，这种o肯定不是被封闭的。
                boolean isEdge=i==0||j==0||i==m-1||j==n-1;
                if(isEdge&&board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //先改此时剩下的O，再把#还原回去，这个顺序不能错

                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        //深度优先遍历找和边界o相连的o并单独标记，这些O是不满足被封闭条件的
        //先对边界进行处理，再判断具体值，不然可能因为判断的顺序出错
        if(i<0||j<0||board[i][j]=='X'||i>=board.length||j>=board[0].length||board[i][j]=='#'){
            return;
        }
        board[i][j]='#';
        dfs(board,i-1,j);//上
        dfs(board,i+1,j);//下
        dfs(board,i,j-1);//左
        dfs(board,i,j+1);//右
    }
}
