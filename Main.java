import java.util.Scanner; 
class Permutacio
  {
    Scanner scanner = new Scanner(System.in);
    
    Permutacio(int size)
    {
      permutacioMatrix = new int[3][size+1];
      this.size = size;
    }
    
    public int[][] permutacioMatrix;
    private int size = 0;

    public void feltoltes()
    {
      System.out.println("Irja be a permutaciot ");
      int tempolaryNumber = 0;
      for(int y = 1;y<=2;y++)
    {
    for (int z = 1;z<=size;z++)
      {
        System.out.println("Irja be az "+y+"-sor " + z + "elemet");
        tempolaryNumber = scanner.nextInt();
        permutacioMatrix[y][z] = tempolaryNumber;
      }
    }
    }

    public void kiiras()
      {
      System.out.println("A permutacio: ");
      for(int y = 1;y<=2;y++)
      {
      for (int z = 1;z<=size;z++)
        {
          System.out.print(permutacioMatrix[y][z]+" ");
        }
       System.out.println(" ");
      }
      }
  }
class Main {
  private static int[][] osszeadas(int[][] matrix1,int[][] matrix2,int size)
  {
    int[][] matrix = new int[3][size+1];
      fillFirst(matrix, size);
    int matrixNumber = 0;
      for (int k = 1;k<=size;k++)
      {
        matrixNumber = matrix2[2][k];
        matrix[2][k] = matrix1[2][matrixNumber];
      }
    return matrix;
  }
  private static void fillFirst(int[][] matrix,int size)
  {
    for(int i= 1;i<=size;i++)
      {
        matrix[1][i] = i;
      }
  }
  private static int inversiokNumber(int[][] matrix,int size)
  {
    int inversioNumber = 0;
    int tempolaryNumber = 0;
    
    for(int i=1;i<=size;i++)
      {
        tempolaryNumber = matrix[2][i];
        for(int j=i+1;j<=size;j++)
          {
            if(matrix[2][j]<tempolaryNumber)
            {
              inversioNumber++;
            }
          }
      }
    
    return inversioNumber;
  }
  private static int permutacioElojele(int inversioNumber)
  {
    if(inversioNumber%2==0)
    {
      return 1;
    }
    else
    {
      return -1;
    }
  }
  private static String paritasString(int elojelNumber)
  {
    if(elojelNumber == 1)
    {
      return "Paros";
    }
    else
    {
      return "Paratlan";
    }
  }
  private static int ciklusNumber(int[][] matrix,int size)
  {
   
    int cycleNumber = 0;
    boolean[] visited =new boolean[size+1];
    for(int i=1;i<=size;i++)
      {
        if(!visited[i])
        {
          int current = i;
          while(!visited[current])
            {
              visited[current] = true;
              current = matrix[2][current];
            }
            cycleNumber++;
        }
      }
    
    return cycleNumber;
  }
  private static void matrixDisplay(int[][] matrixToDisplay,int size)
  {
    for(int i=1;i<=2;i++)
    {
      for(int j=1;j<=size;j++)
        {
          System.out.print(matrixToDisplay[i][j]+ " ");
        }
      System.out.println(" ");
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); 
    
    System.out.println("Irja be a permutacio hosszat ");
    System.out.print("n = ");
    int n = scanner.nextInt();
    int osszeadottMatrix[][] = new int[3][n+1];
    
    System.out.println("Irja hany permutaciot akar");
    System.out.print("m = ");
    int m = scanner.nextInt();
    
    Permutacio[] permutacio;
    permutacio = new Permutacio[m];
    for (int i= 0;i<m;i++)
      {
      permutacio[i] = new Permutacio(n);
      System.out.println("Az "+i+" permutacio:");
    
    permutacio[i].feltoltes();
    permutacio[i].kiiras();
      }

    
    System.out.println("Irja be, hogy hanyat akar osszetenni ");
    System.out.print("Osszeadando = ");
    int osszeadando = scanner.nextInt();

    System.out.println("Irja be, az elso permutacio szamat ");
    int permutacioNumber = scanner.nextInt();
    
    osszeadottMatrix = permutacio[permutacioNumber].permutacioMatrix;
    
    for (int zoltan = 1;zoltan<osszeadando;zoltan++)
    {
      System.out.println("Irja be, az "+ zoltan +" osszeadando permutacio szamat ");
      permutacioNumber = scanner.nextInt();
     osszeadottMatrix = osszeadas(osszeadottMatrix,permutacio[permutacioNumber].permutacioMatrix,n);
    }
    matrixDisplay(osszeadottMatrix,n);


    for (int p=0;p<m;p++)
      {
    System.out.println("Hanyadrendure szeretned emelni az "+p+" permutaciot ");
    System.out.print("k = ");
    int k = scanner.nextInt();
    int [][] hatvanyMatrix = permutacio[p].permutacioMatrix;
    for(int t = 1;t<k;t++)
      {
        hatvanyMatrix = osszeadas(hatvanyMatrix,permutacio[p].permutacioMatrix,n);
      }
        System.out.println("Az "+p+" elem permutaciot "+k+"-ra emelve: ");
    matrixDisplay(hatvanyMatrix,n);
      }
     int inversiokSzama = 0; 
     int elojelErtek = 0;
    for (int o=0;o<m;o++)
      {
        inversiokSzama = inversiokNumber(permutacio[o].permutacioMatrix,n);
        elojelErtek = permutacioElojele(inversiokSzama);
      System.out.print("Az "+o+" elem inverzioi: ");
      System.out.println(inversiokSzama);
      System.out.print("Az "+o+" elem elojele: ");
      System.out.println(elojelErtek);
      System.out.print("Az "+o+" elem paritasa: ");
      System.out.println(paritasString(elojelErtek));
      System.out.print("Az "+o+" elem ciklusainak szama: ");
      System.out.println( ciklusNumber(permutacio[o].permutacioMatrix,n));
      
      }
   
  }
}