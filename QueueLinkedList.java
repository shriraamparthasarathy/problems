public class QueueLinkedList 
{ 
    static class Qnode
    {
        int key;
        Qnode next;
        Qnode(int key)
        {
            this.key=key;
            this.next=null;
        }
    }
    static class Queue
    {
        Qnode front,rear;
        Queue()
        {
            this.front=null;
            this.rear=null;
        }
        void enqueue(int key)
        {
            Qnode temp=new Qnode(key);
            if(this.front==null)
                this.front=this.rear=temp;
            else
            {
                this.rear.next=temp;
                this.rear=temp;
            }
        }
        void dequeue()
        {
            if(this.front==null)
            {
                 System.out.println("NULL");
                 return;
             }       
            Qnode temp=this.front.next;
            this.front=temp;
            if(this.front==null)
                this.rear=null;
        }
    }
    public static void main(String[] args) 
    { 
        Queue q = new Queue();
        q.enqueue(10); 
        q.enqueue(20); 
        q.dequeue(); 
        q.dequeue(); 
        q.enqueue(30); 
        q.enqueue(40); 
        q.enqueue(50); 
        q.dequeue(); 
        System.out.println("Queue Front : " + q.front.key); 
        System.out.println("Queue Rear : " + q.rear.key); 
    } 
} 
