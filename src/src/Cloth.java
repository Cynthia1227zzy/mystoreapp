package src;

public class Cloth {
    private String name;
    private int temperature;
    private double height;
    private double weight;
    private String personality;
    private boolean bAddNewCloth = false;
    public Cloth(String n, int t, double h, double w, String p){
        name = n;
        temperature = t;
        height = h;
        weight = w;
        personality = p;
    }
    public void display(){
        System.out.printf("name:%s,temperature:%s,height(cm):%4f,weight(kgs):%4f,personality:%s", name, temperature, height, weight, personality);
    }

}