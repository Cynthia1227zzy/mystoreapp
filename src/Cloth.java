public class Cloth {
    private String name;
    private String price;
    private String gender;
    private int temperature;
    private double height;
    private double weight;
    private String personality;
    private boolean bAddNewCloth = false;
    public Cloth(String n, String pr,String g, int t, double h, double w, String p){
        name = n;
        price = pr;
        gender = g;
        temperature = t;
        height = h;
        weight = w;
        personality = p;
    }
    public void display(){
        System.out.printf("name:%s,price:%s,gender:%s,temperature:%s,height(cm):%4f,weight(kgs):%4f,personality:%s", name, price,gender, temperature, height, weight, personality);
    }

    public String getName(){
        return name;
    }
    public String getPr(){
        return price;
    }
    public String getGen(){
        return gender;
    }
    public int getTem(){
        return temperature;
    }
    public double getH(){return height; }
    public double getW(){return weight; }
    public String getPer(){return personality; }
}