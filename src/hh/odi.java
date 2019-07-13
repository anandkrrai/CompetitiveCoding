
package hh;

import java.util.Scanner;

public class odi {
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double rr1 = sc.nextDouble();
		int khuliStrike = sc.nextInt();
		int bandStrike = sc.nextInt();
		sc.nextLine();
		String timeline = sc.nextLine();
		double rr2 = sc.nextDouble();
		String[] Timeline_runs = timeline.trim().split("\\s+");

		int totalRuns = 0;
		for (String s : Timeline_runs) {
			if (s.equals("0") || s.equals("W")) {
				totalRuns += 0;
			} else if (s.equals("1")) {
				totalRuns += 1;
			} else if (s.equals("2")) {
				totalRuns += 2;
			} else if (s.equals("3")) {
				totalRuns += 3;
			} else if (s.equals("4")) {
				totalRuns += 4;
			} else if (s.equals("5")) {
				totalRuns += 5;
			} else if (s.equals("6")) {
				totalRuns += 6;
			}
		}

		double num = (rr2 * Timeline_runs.length - totalRuns * 6);
		double den = (rr1 - rr2);

		int b = (int) (num / den);

		double myNUmber = rr1 * b;

		int r = (int) myNUmber / 6;
		int total = r + totalRuns;

		int bachiHUiBall = 6 - (b % 6);
		boolean strike = true;

		char[] myTimeline_runs = new char[Timeline_runs.length];
		for (int i = 0; i < Timeline_runs.length; ++i) {
			myTimeline_runs[i] = Timeline_runs[i].charAt(0);
		}

		for (char ch : myTimeline_runs) {
			switch (ch) {

			case '1': {
				if (strike) {
					khuliStrike += 1;
				} else {
					bandStrike += 1;
				}
				strike = !strike;

				break;
			}
			case '2': {
				if (strike) {
					khuliStrike += 2;
				} else {
					bandStrike += 2;
				}
				break;
			}
			case '3': {
				if (strike) {
					khuliStrike += 3;
				} else {
					bandStrike += 3;
				}
				strike = !strike;
				break;
			}
			case '4': {
				if (strike) {
					khuliStrike += 4;
				} else {
					bandStrike += 4;
				}
				break;
			}
			case '5': {
				if (strike) {
					khuliStrike += 5;
				} else {
					bandStrike += 5;
				}
				strike = !strike;
				break;
			}
			case '6': {
				if (strike) {
					khuliStrike += 6;
				} else {
					bandStrike += 6;
				}
				break;
			}
			case 'W': {
				if (strike) {
					khuliStrike = 0;
				} else {
					bandStrike = 0;
				}
				break;
			}
			default: {
				break;
			}

			}

			bachiHUiBall--;
			if (bachiHUiBall == 0) {
				bachiHUiBall = 6;
				strike = !strike;
			}
		}
		print(strike, khuliStrike, bandStrike, total);

		sc.close();
	}

	private static void print(boolean strike, int onstrike, int offstrike, int total) {
		System.out.print(total + " ");
		if (strike) {
			System.out.print(onstrike + " " + offstrike);
		} else {
			System.out.print(offstrike + " " + onstrike);
		}
	}

}
