public class Main {
    public static void main(String[] args) {
        //int n=1000;
        //SortTestHelper sortTestHelper=new SortTestHelper();
        //Integer[] arr=sortTestHelper.generateRandomArray(n,0,n);
        //int[] arr=sortTestHelper.generateNearlyOrderedArray(10000,10);
        //Integer[] arr2=arr.clone();
        //Integer[] arr3=arr.clone();
        /*double startTime=System.nanoTime();
        MergeSort mergeSort=new MergeSort();
        mergeSort.mergeSort(arr,n);
        sortTestHelper.isSorted(arr,n);
        double endTime=System.nanoTime();
        double time=(endTime-startTime)/1000000000.0;
        System.out.println("Merge Sort: "+time+" s");*/
        /*startTime=System.nanoTime();
        InsertionSort insertionSort=new InsertionSort();
        insertionSort.insertionSort(arr2,n);
        sortTestHelper.isSorted(arr2,n);
        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("Insertion Sort: "+time+" s");
        ShellSort shellSort=new ShellSort();
        startTime=System.nanoTime();
        shellSort.shellSort(arr3,n);
        sortTestHelper.isSorted(arr3,n);
        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("Shell Sort: "+time+" s");*/
        /*startTime=System.nanoTime();
        QuickSort quickSort=new QuickSort();
        quickSort.quickSort(arr2,n);
        sortTestHelper.isSorted(arr2,n);
        endTime=System.nanoTime();
        time=(endTime-startTime)/1000000000.0;
        System.out.println("Quick Sort: "+time+" s");*/
        /*int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.add( i , (int)(Math.random()*N) );
        assert indexMaxHeap.testIndexes();*/
        /*// 使用1000000的数据规模
        int n = 1000000;

        // 虽然isConnected只需要O(1)的时间, 但由于union操作需要O(n)的时间
        // 总体测试过程的算法复杂度是O(n^2)的

        // 100万数据对于UF1来说太慢了, 不再测试
        //UnionFindTestHelper.testUF1(n);

        // 对于UF2来说, 其时间性能是O(n*h)的, h为并查集表达的树的最大高度
        // 这里严格来讲, h和logn没有关系, 不过大家可以简单这么理解
        // 我们后续内容会对h进行优化, 总体而言, 这个h是远小于n的
        // 所以我们实现的UF2测试结果远远好于UF1, n越大越明显:)

        // 100万数据对于UF2来说也是很慢的, 不再测试
        //UnionFindTestHelper.testUF2(n);

        // 对于UF3来说, 其时间性能依然是O(n*h)的, h为并查集表达的树的最大高度
        // 但由于UF3能更高概率的保证树的平衡, 所以性能更优
        UnionFindTestHelper.testUF3(n);

        // UF4虽然相对UF3进行有了优化, 但优化的地方出现的情况较少,
        // 所以性能更优表现的不明显, 甚至在一些数据下性能会更差
        UnionFindTestHelper.testUF4(n);

        // UF5虽然相对UF4进行有了优化, 但优化的地方出现的情况较少,
        // 所以性能更优表现的不明显, 甚至在一些数据下性能会更差
        UnionFindTestHelper.testUF5(n);*/

        //并查集测试
        /*int n=10000;
        Integer[] a=new Integer[n];
        for(int i=0;i<n;i++){
            a[i]=(int)(Math.random()%n);
        }
        QuickSort.quickSort(a,n);
        for(int i=1;i<n;i++){
            if(a[i]<a[i-1])
                throw new IllegalArgumentException("Sorted Error!");
        }
        System.out.println("Done!");*/

        /*// 使用两种图的存储方式读取testG1.txt文件
        String filename = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2 , filename );
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
        filename = "testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename);
        System.out.println("test G2 in Sparse Graph:");
        g3.show();

        System.out.println();

        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename);
        System.out.println("test G2 in Dense Graph:");
        g4.show();*/

        // TestG1.txt
        String filename1 = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.getCcount());
        System.out.println();

        // TestG2.txt
        String filename2 = "testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.getCcount());
    }
}
class UnionFindTestHelper {

    // 我们的测试类不允许创建实例
    private UnionFindTestHelper(){}

    // 测试第一版本的并查集, 测试元素个数为n
    public static void testUF1( int n ){

        UnionFind1 uf = new UnionFind1(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF1, " + 2*n + " ops, " + (endTime-startTime) + "ms");
    }

    // 测试第二版本的并查集, 测试元素个数为n, 测试逻辑和之前是完全一样的
    // 思考一下: 这样的冗余代码如何消除?
    // 由于这个课程不是设计模式课程, 在这里就不过多引入相关的问题讲解了。留作给大家的思考题:)
    public static void testUF2( int n ){

        UnionFind2 uf = new UnionFind2(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF2, " + 2*n + " ops, " + (endTime-startTime) + "ms");
    }

    // 测试第三版本的并查集, 测试元素个数为n, 测试逻辑和之前是完全一样的
    public static void testUF3( int n ){

        UnionFind3 uf = new UnionFind3(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF3, " + 2*n + " ops, " + (endTime-startTime) + "ms");
    }

    // 测试第四版本的并查集, 测试元素个数为n, 测试逻辑和之前是完全一样的
    public static void testUF4( int n ){

        UnionFind4 uf = new UnionFind4(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF4, " + 2*n + " ops, " + (endTime-startTime) + "ms");
    }

    // 测试第五版本的并查集, 测试元素个数为n, 测试逻辑和之前是完全一样的
    public static void testUF5( int n ){

        UnionFind5 uf = new UnionFind5(n);

        long startTime = System.currentTimeMillis();

        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for( int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.unionElements(a,b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < n ; i ++ ){
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.isConnected(a,b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println("UF5, " + 2*n + " ops, " + (endTime-startTime) + "ms");
    }
}
