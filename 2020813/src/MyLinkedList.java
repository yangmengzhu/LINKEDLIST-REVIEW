
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class MyLinkedList {
    public Node head;
   public void addFirst(int data){
       Node node=new Node(data);
       if(this.head==null){
           this.head=node;
           return;
       }
       node.next=this.head;
       this.head=node;
   }
   public void addLast(int data){
       Node node=new Node(data);
       Node cur=this.head;
       if(this.head==null){
           this.head=node;
           return;
       }
       while(cur.next!=null){
           cur=cur.next;
       }
       cur.next=node;
   }
   public void display(){
       Node cur=this.head;
       while(cur!=null){
           System.out.print(cur.data+" ");
       }
       System.out.println();
   }
   public int size(){
       int count=0;
       Node cur=this.head;
       while(cur!=null){
           count++;
           cur=cur.next;
       }
       return count;
   }
   private Node searchIndex(int index){
       if(index<0||index>size()){
           throw new RuntimeException("index位置不合法");
       }
       Node cur=this.head;
       while(index-1>0){
           cur=cur.next;
           index--;
       }
       return cur;
   }
  public void addIndex(int index,int data){
       Node node=new Node(data);
       if(index==0){
           addFirst(data);
           return;
       }
       if(index==this.size()){
           addLast(data);
           return;
       }
       Node prev=searchIndex(index);
       node.next=prev.next;
       prev.next=node;
  }
  public boolean contains(int key){
      Node cur=this.head;
      while(cur!=null){
          if(cur.data==key){
              return true;
          }
          cur=cur.next;
      }
      return false;
  }
  private Node searchPrev(int key){
       Node prev=this.head;
       while(prev.next!=null){
           if(prev.next.data==key){
               return prev;
           }
           prev=prev.next;
       }
       return null;
  }
  public void remove(int key){
      if(this.head==null){
          return;
      }
      if(this.head.data==key){
          this.head=this.head.next;
          return;
      }
      Node prev=searchPrev(key);
      if(prev==null){
          return;
      }
      Node del=prev.next;
      prev.next=del.next;
  }
   public void removeAll(int key){
       Node cur=this.head.next;
       Node prev=this.head;
       if(this.head==null){
           return;
       }
       while(cur!=null){
          if(cur.data==key){
              prev.next=cur.next;
              cur=cur.next;
          }else{
              prev=cur;
              cur=cur.next;
          }
       }
       if(this.head.data==key){
           this.head=this.head.next;
       }
   }
   public void clear(){
       this.head=null;
   }
    //反转链表
    public Node reverse(Node node){
        Node cur=this.head;
        Node prev=null;
        Node newHead=null;

        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }
    //找中间节点
    public Node middle(Node node){
       Node slow=this.head;
       Node fast=this.head;
       if(this.head==null){
           return null;
       }
       while(fast!=null&& fast.next!=null){
           fast=fast.next.next;
           slow=slow.next;
       }
       return slow;
    }
    //倒数第k个节点
    public Node findK(Node node,int k){
       Node fast=this.head;
       Node slow=this.head;
       if(k<=0){
           throw new RuntimeException("k不合法");
       }
       while(k-1>0) {
           if (fast.next != null) {
               fast = fast.next;
               k--;
           } else {
               System.out.println("没有这个节点");
               return null;
           }
       }
       while(fast.next!=null){
           fast=fast.next;
           slow=slow.next;
       }
       return slow;
    }
    //分割链表
    public Node split(Node node,int x){
       if(this.head==null){
           return null;
       }
       Node cur=this.head;
       Node bs=null;
       Node be=null;
       Node as=null;
       Node ae=null;
       while(cur!=null){
           if(cur.data<x){
               if(bs==null){
                  bs=cur;
                  be=cur;
               }else{
                  be.next=cur;
                  be=be.next;
               }
           }else{
              if(as==null){
                  as=cur;
                  ae=cur;
              }else{
                  ae.next=cur;
                  ae=ae.next;
              }
           }
           cur=cur.next;
       }
       if(bs==null){
           return as;
       }
       be.next=as;
       if(ae!=null) {
           ae.next = null;
       }
       return bs;
    }
    public Node removeRepete(Node node){
       Node cur=this.head;
       Node newHead=new Node(-1);
       Node tmp=newHead;
       if(this.head==null){
           return null;
       }
       while(cur!=null){
           if(cur.next!=null&&cur.data==cur.next.data){
               while(cur.next!=null&&cur.data==cur.next.data){
                   cur=cur.next;
               }
               cur=cur.next;
           }else{
               tmp.next=cur;
               tmp=tmp.next;
               cur=cur.next;
           }
       }
       tmp.next=null;
       return newHead.next;
    }
    public boolean huiwen(Node node){
       Node slow=this.head;
       Node fast=this.head;
       if(this.head==null){
           return false;
       }
       if(this.head.next==null){
           return true;
       }
       //找到中间节点
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node cur=slow.next;
        //反转链表后半部分
        while(cur!=null){
            Node curNext=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        while(slow!=head){
            if(head.data!=slow.data){
                return false;
            }
            if(this.head.next==slow){
                return true;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;
    }
    public Boolean loop(Node node){
       Node slow=this.head;
       Node fast=this.head;
       while(fast!=null&&fast.next!=null){
           fast=fast.next.next;
           slow=slow.next;
           if(fast==slow){
               return true;
           }
       }
    return false;
    }
    public Node func(Node node){
        Node slow=this.head;
        Node fast=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
               break;
            }
        }
        if(fast==null&&fast.next==null){
            return null;
        }
        slow=this.head;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
       return slow;
    }
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
    }
}
