import java.util.LinkedList;
import java.util.Queue;



 /* public  class  Stack {

        static Queue<Integer> q1 = new LinkedList<Integer>();
        static Queue<Integer> q2 = new LinkedList<Integer>();

        static int current_size;

        Stack() {
            current_size = 0;
        }

         void push(int x) {
            current_size++;

            q2.add((x));
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }

            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;

        }

         int pop(int x) {
            if (q1.isEmpty()) return -1;


            current_size--;
            return q1.remove();


        }

         int peek(int x) {
            if (q1.isEmpty()) {
                return -1;
            }
            return q1.peek();
        }



        public static void main(String[] args){

            Stack s = new Stack();

            s.push(10);
            s.pop(20);
            s.peek(30);

            System.out.println("Current Poped Value on the stack is " +  s.pop(30) );



        }

  }*/

