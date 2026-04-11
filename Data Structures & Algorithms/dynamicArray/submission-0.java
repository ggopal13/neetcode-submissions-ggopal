class DynamicArray {

    private int[] array;
    private int totalElements;
    private int capacity;


    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.totalElements = 0;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if(totalElements == capacity)
            resize();
        array[totalElements] = n;
        totalElements+=1;
    }

    public int popback() {
        int element = array[totalElements-1];
        array[totalElements-1] = 0;
        totalElements-=1;
        return element;
    }

    private void resize() {
        int[] newArray = new int[this.capacity*2];
        System.arraycopy(array,0,newArray,0,this.totalElements);
        this.array = newArray;
        this.capacity*=2;
    }

    public int getSize() {
        return this.totalElements;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
