import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IBATest {
	public static void сheckNeighbor(int[][] A, int[][] B, int i,int j, int N, int M)
	{
	  if(B[i][j] == -1) return;
	  B[i][j] = -1;
	  if(i+1 < N)
		if(A[i+1][j] == A[i][j]) CheckNeighbor(A, B, i+1, j, N, M);
	  if(i-1 >= 0)
		if(A[i-1][j] == A[i][j]) CheckNeighbor(A, B, i-1, j, N, M);
	  if(j+1 < M)
		if(A[i][j+1] == A[i][j]) CheckNeighbor(A, B, i, j+1, N, M);
	  if(j-1 >= 0)
		if(A[i][j-1] == A[i][j]) CheckNeighbor(A, B, i, j-1, N, M);
	}

	public static int solution(int[][] A) {
	  if (A.length == 0) return 0;
	  int sum = 0;
	  int N = A.length;
	  int M = A[0].length;
	  if (N ==0 || M==0) return 0;
	  int[][] B = A.clone();
	  for(int i=0; i<N; i++) {
		for(int j = 0; j<M; j++) {
		  if (B[i][j] >= 0) {
			CheckNeighbor(A, B, i, j, N, M);
			sum ++;
		  }
		}
	  }
	  return sum;
	}
	
	
    public static long carParkingRoof(List<Long> cars, int k) {
		List<Long> sorted = cars.stream().sorted().collect(Collectors.toList());

        return IntStream.rangeClosed(0, sorted.size() - k + 1)
                .mapToLong(idx -> sorted.get(idx + k -1) - sorted.get(idx))
                .min()
                .orElseThrow(RuntimeException::new);
    }

    public static void main(String[] args) {
        List<Long> cars = Arrays.asList(6L, 2L, 12L, 7L);
        long r = carParkingRoof(cars, 3);
        System.out.println(r);
		
	int[][] A = {{5,4,4}, {4,3,4}, {3,2,4}, {2,2,2}, {3,3,4}, {1,4,4}, {4,1,1}};
	System.out.println(solution(A));
    }
}
