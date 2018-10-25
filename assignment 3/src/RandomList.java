import java.util.ArrayList;

public class RandomList extends ArrayList<Comparable> {
    private ArrayList<Comparable> list;
    public RandomList(int n){
        list=new ArrayList<>();
        for (int i=0;i<n;i++)
            list.add(i);
    }

    public ArrayList<Comparable> getList() {
        return list;
    }

    public void setList(ArrayList<Comparable> list) {
        this.list = list;
    }
    public void printAll(){
        for (int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
        System.out.println();
    }
    @Override
    public int size(){
        return list.size();
    }
    @Override
    public Comparable<Integer> get(int index){
        return list.get(index);
    }
    @Override
    public Comparable set(int index, Comparable value){
        list.set(index,value);
        return value;
    }
    public void init(int n){
        if (n==0){
            for (int i=0;i<list.size();i++){
                list.set(i,i);
            }
        }else if (n==1){
            for (int i=0;i<list.size();i++){
                list.set(i,list.size()-i);
            }
        }else{
            for (int i=list.size()-1;i>=0;i--){
                int num=(int)(Math.random()*(i+1));
                Comparable randomat=list.get(num);
                list.set(num,list.get(i));
                list.set(i,randomat);
            }
        }
    }

}
