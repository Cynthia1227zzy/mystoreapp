public class Store {
    private Cloth[] cloth;
    private int total = 0;

    public Store(int numberCloth) {
        cloth = new Cloth[numberCloth];
    }

    private boolean isFull() {
        return total == cloth.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }
    public int getSize() {
        return cloth.length;
    }
    public int getCount() {
        return total;
    }
    public boolean add(Cloth newCloth) {
        if (isFull()) {
            return false;
        } else {
            cloth[total] = newCloth;
            total ++;
            return true;
        }
    }
    public String deleteCloth(String clothName) {
        int nDelete = 0;
        String strResult = "";
        if (isEmpty() || clothName.isEmpty()) {
            strResult = "Store is empty or cloth name is empty!\n";
        } else {
            for (int i = 0; i < cloth.length; i ++) {
                if (cloth[i].getName().equals(clothName)) {
                    for (int j = i; j < cloth.length - 1; j ++) {
                        cloth[j] = cloth[j + 1];
                    }
                    nDelete ++;
                    total --;
                    strResult += "Successfully deleted " + clothName + "\n";
                }
            }
        }
        if (nDelete == 0) {
            strResult = "No cloth named " + clothName + " in the store!\n";
        }
        else {
            strResult +=  nDelete + " clothes deleted successfully!";
        }
        return strResult;
    }
    public String listClothes() {
        if (isEmpty()) {
            return "No cloth in the store";
        }
        String listOfClothes = "";
        for (int i = 0; i < total; i++) {
            listOfClothes += i+1 + ": " + cloth[i].getName() +" "+ cloth[i].getPr()+"yuan " + cloth[i].getGen() + " "+cloth[i].getTem()+"℃ " + cloth[i].getH()+"cm " + cloth[i].getW()+"kg " + cloth[i].getPer() + "\n";
        }
        return listOfClothes;
    }
    public String listCurrentCloth(int iSeq) {
        if (isEmpty()) {
            return "No cloth in the store";
        }
        if (iSeq > total) {
            return "No Products are in our current cloth line";
        }
        String listOfClothes = "";
        if (!cloth[iSeq - 1].getName().isEmpty()) {
            listOfClothes += iSeq + ": " + cloth[iSeq - 1].getName() + " "
                + cloth[iSeq - 1].getPr() + "yuan " + cloth[iSeq - 1].getGen() + " "
                + cloth[iSeq - 1].getTem() + "℃ " + cloth[iSeq - 1].getH() + "cm "
                + cloth[iSeq - 1].getW() + "kg " + cloth[iSeq - 1].getPer() + "\n";
        }
        return listOfClothes;
    }
    public String searchClothes(String strKey) {
        if (isEmpty()) {
            return "No cloth in the store";
        }
        String listOfClothes = "";
        for (int i = 0; i < total; i ++) {
            String strTemp = listCurrentCloth(i + 1);
            if (strTemp.contains(strKey)) {
                listOfClothes += strTemp;
            }
        }
        return listOfClothes;
    }
}