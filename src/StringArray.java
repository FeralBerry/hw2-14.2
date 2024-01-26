import java.util.Arrays;

public class StringArray implements StringList{
    private int index = 10;
    private String[] stringList = new String[index];
    @Override
    public String add(String item) {
        int i = 0;
        int j = 0;
        String[] old = this.stringList;
        for(; i < this.index; ++i){
            if(this.stringList[i] == null){
                this.stringList[i] = item;
                return item;
            }
        }
        this.index += 5;
        this.stringList = new String[this.index];
        for (; j < this.stringList.length; j++) {
            if(j < old.length){
                this.stringList[j] = old[j];
            }
        }
        j = 0;
        for (; j < this.stringList.length; j++) {
            if(this.stringList[j] == null){
                this.stringList[j] = item;
                return item;
            }
        }
        return item;
    }
    @Override
    public String add(int index, String item) throws IndexAddExceptions {
        if(this.stringList.length < index){
            throw new IndexAddExceptions("Элемента с таким индексом нет!");
        }
        String[] firstArray = Arrays.copyOfRange(this.stringList, 0, index);
        String[] secondArray = Arrays.copyOfRange(this.stringList, index, this.stringList.length);
        String[] newArray = new String[this.stringList.length + 1];
        this.index += 1;
        this.stringList = new String[this.index];
        System.arraycopy(firstArray, 0, newArray, 0, firstArray.length);
        newArray[index] = item;
        for (int i = 0; i < secondArray.length; i++){
            newArray[index + i + 1] = secondArray[i];
        }
        System.arraycopy(newArray, 0, this.stringList, 0, newArray.length);
        return item;
    }

    @Override
    public String set(int index, String item) throws IndexAddExceptions {
        if(this.stringList.length < index){
            throw new IndexAddExceptions("Элемента с таким индексом нет!");
        }
        this.stringList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) throws NotHaveItemExceptions {
        for (int i = 0; i < this.stringList.length; i++){
            if(this.stringList[i].equals(item)){
                String[] firstArray = Arrays.copyOfRange(this.stringList, 0, i);
                String[] secondArray = new String[]{};
                if(i + 1 <= this.stringList.length){
                    secondArray = Arrays.copyOfRange(this.stringList, i + 1, this.stringList.length);
                }
                System.arraycopy(firstArray, 0, this.stringList, 0, firstArray.length);
                System.arraycopy(secondArray, 0, this.stringList, i, secondArray.length);
                return item;
            }
        }
        throw new NotHaveItemExceptions("Нет такого элемента!");
    }

    @Override
    public String remove(int index) throws NotHaveItemExceptions {
        if(this.stringList.length < index){
            throw new NotHaveItemExceptions("Нет элемента с таким индексом!");
        } else {
            String item = this.stringList[index];
            String[] firstArray = Arrays.copyOfRange(this.stringList, 0, index);
            String[] secondArray = new String[]{};
            if(index + 1 <= this.stringList.length){
                secondArray = Arrays.copyOfRange(this.stringList, index + 1, this.stringList.length);
            }
            System.arraycopy(firstArray, 0, this.stringList, 0, firstArray.length);
            System.arraycopy(secondArray, 0, this.stringList, index, secondArray.length);
            return item;
        }
    }
    @Override
    public boolean contains(String item) {
        for (String s : this.stringList) {
            if (s.equals(item)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < this.stringList.length; i++) {
            if(item != null){
                if(this.stringList[i].equals(item)){
                    return i;
                }
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(String item) {
        for (int i = this.stringList.length - 1; i > 0; i--) {
            if(this.stringList[i] != null){
                if(this.stringList[i].equals(item)){
                    System.out.println(i);
                    return i;
                }
            }
        }
        return -1;
    }
    @Override
    public String get(int index) throws NotHaveItemExceptions {
        if(this.stringList.length < index){
            throw new NotHaveItemExceptions("Нет элемента с таким индексом!");
        } else {
            return this.stringList[index];
        }
    }
    @Override
    public boolean equals(StringList otherList) throws NotHaveItemExceptions {
        int index = 0;
        for (int i = 0; i < this.stringList.length; i++) {
            if(this.stringList[i] == null){
                index = i;
                break;
            }
        }
        String[] newString = Arrays.copyOfRange(this.stringList, 0, index);
        System.out.println(Arrays.toString(newString));
        if(newString.length == otherList.size()) {
            for (int i = 0; i < otherList.size(); i++) {
                if(!newString[i].equals(otherList.get(i))){
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    @Override
    public int size() {
        int count = 0;
        for (String s : stringList) {
            if (s != null) {
                count++;
            }
        }
        return count;
    }
    @Override
    public boolean isEmpty() {
        for (String s : stringList) {
            if (s != null) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void clear() {
        this.stringList = new String[]{};
    }
    @Override
    public String[] toArray() {
        return this.stringList;
    }
}
