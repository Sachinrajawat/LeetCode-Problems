/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat=new int[m][n];
        ListNode temp=head;
        int top=0,bottom=m-1,left=0,right=n-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                if(temp!=null){
                    mat[top][i]=temp.val;
                    temp=temp.next;
                }
                else mat[top][i]=-1;
            }
            for(int i=top+1;i<=bottom;i++){
                if(temp!=null){
                    mat[i][right]=temp.val;
                    temp=temp.next;
                }
                else mat[i][right]=-1;
            }
        if(bottom!=top){
            for(int i=right-1;i>=left;i--){
                if(temp!=null){
                    mat[bottom][i]=temp.val;
                    temp=temp.next;
                }
                else mat[bottom][i]=-1;
            }
        }
        if(right!=left){
            for(int i=bottom-1;i>top;i--){
                if(temp!=null){
                    mat[i][left]=temp.val;
                    temp=temp.next;
                }
                else mat[i][left]=-1;
            }
        }
        top++;
        bottom--;
        left++;
        right--;
        }
        return mat;
    }
}