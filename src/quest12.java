public class quest12 {
    int a, b;

    public quest12(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void print(){
        System.out.println(a + b);
    }
    static class classTwo extends quest12{
        int po = 3;

        public classTwo(int i){
            super(i, i+1);
        }

        public void print(){
            System.out.println(po*po);
        }
    }

    public static void main(String[] args) {
        quest12 obj = new classTwo(10);
        obj.print();
    }
}
