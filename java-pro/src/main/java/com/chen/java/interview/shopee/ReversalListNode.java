package com.chen.java.interview.shopee;

/**
 * <p>链表反转</p>
 * 给定链表顺序：1，2，3，4，5
 * 要求输出：5，4，3，2，1
 *
 * @author pengzhenchen 2021/07/10 6:28 下午
 */
public class ReversalListNode{

    public static void main(String[] args){

        Node origin =
                new Node(5,
                new Node(4,
                new Node(3,
                new Node(2,
                new Node(1,
                null)))),true);

        System.out.println("原始链表：");
        print(origin);
        System.out.println("\n反转后：");
        print(reversalListNode(origin));
    }

    private static Node reversalListNode(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        Node next = cur.next;
        pre.next = null;
        head.isHead = false;
        while(next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        cur.isHead = true;
        return cur;
    }

    private static void print(Node list){
        if(list == null){
            return;
        }
        print(list.next);
        if (list.isHead){
            System.out.print(list.val);
        }else{
            System.out.print(list.val+",");
        }


    }
}

class Node {

    public int val;
    public Node next;
    public boolean isHead;

    public Node(int val, Node next){
        this.val = val;
        this.next = next;
        this.isHead = false;
    }
    public Node(int val, Node next, boolean isHead){
        this.val = val;
        this.next = next;
        this.isHead = isHead;
    }
}