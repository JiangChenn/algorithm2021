public class lc_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode cur = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                cur=cur.next;
                l1=l1.next;
            }else{
                cur.next=l2;
                cur=cur.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            cur.next=l2;
        }
        else{
            cur.next=l1;
        }
        return head.next;
    }
}

