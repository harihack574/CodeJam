package Jam;

import java.util.Scanner;

public class CenterOfMass {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = in.nextInt();
			int p[][] = new int[n][3];
			int v[][] = new int[n][3];

			for (int k = 0; k < n; k++) {
				for (int j = 0; j < 3; j++) {
					p[k][j] = in.nextInt();
				}
				for (int j = 0; j < 3; j++) {
					v[k][j] = in.nextInt();
				}
			}

			double[][] avgP = new double[1][3];
			double[][] avgV = new double[1][3];
			for (int a = 0; a < n; a++) {
				avgP[0][0] += p[a][0];
				avgP[0][1] += p[a][1];
				avgP[0][2] += p[a][2];
			}

			for (int a = 0; a < n; a++) {
				avgV[0][0] += v[a][0];
				avgV[0][1] += v[a][1];
				avgV[0][2] += v[a][2];
			}

			avgP[0][0] = avgP[0][0] * 1.0 / n;
			avgP[0][1] = avgP[0][1] * 1.0 / n;
			avgP[0][2] = avgP[0][2] * 1.0 / n;

			avgV[0][0] = avgV[0][0] * 1.0 / n;
			avgV[0][1] = avgV[0][1] * 1.0 / n;
			avgV[0][2] = avgV[0][2] * 1.0 / n;

			double modV = Math.pow(avgV[0][0], 2) + Math.pow(avgV[0][1], 2)
					+ Math.pow(avgV[0][2], 2);
			double dot = avgP[0][0] * avgV[0][0] + avgP[0][1] * avgV[0][1]
					+ avgP[0][2] * avgV[0][2];

			double solution = 0;
			double minDistance1 = Math.pow(avgP[0][0], 2)
					+ Math.pow(avgP[0][1], 2) + Math.pow(avgP[0][2], 2);
			minDistance1 = Math.sqrt(minDistance1);
			double t = 0;
			if (modV == 0) {
				solution = minDistance1;
			}

			else {
				t = -(dot) / modV;
				if (t < 0) {
					solution = minDistance1;
					t = 0;
				} else {
					double solP[][] = new double[1][3];
					solP[0][0] = (avgP[0][0]) + t * (avgV[0][0]);
					solP[0][1] = (avgP[0][1]) + t * (avgV[0][1]);
					solP[0][2] = (avgP[0][2]) + t * (avgV[0][2]);

					solution = Math.pow(solP[0][0], 2)
							+ Math.pow(solP[0][1], 2) + Math.pow(solP[0][2], 2);

					solution = Math.sqrt(solution);

				}
			}

			System.out.println("Case #" + i + ": " + (float)solution + " " + (float)t);

		}
		in.close();
	}
}
