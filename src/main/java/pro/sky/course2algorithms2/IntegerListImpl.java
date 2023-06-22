package pro.sky.course2algorithms2;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{
    private final Integer[] storage;
    private int size;
    public IntegerListImpl(){
        storage = new Integer[10];
    }
    public IntegerListImpl(int initSize){
        storage = new Integer[initSize];
    }
    @Override
    public Integer add(Integer item) {
        validateItem(item);
        validateSize();
        storage[size++]= item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index==size){
            storage[size++]= item;
            return item;
        }
        System.arraycopy(storage,index,storage,index+1,size-index);
        storage[index]=item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index]= item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index= indexOf(item);

        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];

        if (index!=size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[]storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy,item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i=0; i<size; i++){
            if (storage[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i=size-1; i>=0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        size=0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }
    private void validateItem(Integer item){
        if(item == null){
            throw new NullItemException();
        }
    }
    private void validateSize(){
        if(size == storage.length){
            throw new StorageIsFullException();
        }
    }
    private void validateIndex(int index){
        if(index <0 || index > size){
            throw new InvalidIndexException();
        }
    }
    private void sort(Integer[]arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private boolean binarySearch(Integer[]arr,Integer item){
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }
    public static void sortBubble(int[] arr){
        int[ ] array = generateRandomArray();
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void swapElements(int[] arr, int j, int i) {
    }

    public static void sortSelection(int[] arr) {
        int[ ] array = generateRandomArray();
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    public static void sortInsertion(int[] arr) {
        int[ ] array = generateRandomArray();
        long start = System.currentTimeMillis();

        for (int z = 1; z < arr.length; z++) {
            int temp = arr[z];
            int j = z;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}


