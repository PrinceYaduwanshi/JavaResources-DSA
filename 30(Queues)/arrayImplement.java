public class arrayImplement{

    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        static int front;//for circular 

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;//for circular
        }

        public boolean isEmpty(){
            return rear == -1;
        }

        // for cicular
        public boolean isFull(){
            return (rear+1)%size == front; //both pointer reach at same position
        }

        // Add 
        // public void enqueue(int data){
        //     if( rear == size-1){
        //         System.out.println("Queue is Full");
        //         return;
        //     }
        //     rear = rear+1;
        //     arr[rear] = data;
        // }


        // circular
        public void enqueue(int data){
            if( isFull()){
                System.out.println("Queue is Full");
                return;
            }
            if( front == -1){
                front =0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        // Remove
        // public int dequeue(){
        //     if( isEmpty()){
        //         System.out.println("Queue is Empty");
        //         return -1;
        //     }
        //     int front = arr[0];
        //     for(int i=0 ; i<rear ; i++){
        //         arr[i] = arr[i+1];//elements shifted to left
        //     }
        //     rear = rear-1;
        //     return front;
        // }



        // circular 
        public int dequeue(){
            if( isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = arr[front];
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front+1)%size;
            }
            
            return result;
        }

        // peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

    }
    

    public static void main(String args[]){
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.dequeue());
        q.enqueue(6);
        System.out.println(q.dequeue());
        q.enqueue(7);
        System.out.println(q.dequeue());

        while( !q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.dequeue();
        }
        System.out.println();
    }
}