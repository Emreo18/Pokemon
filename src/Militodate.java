
public class Militodate {
	public static String Militodatemethod(long mili) {
		if (mili < 60) {
			return mili + "s";
		}
		if (mili < 3600) {
			long temp1 = mili;
			long temp = 0;
			while (temp1 < 3600 && temp1 >= 60) {
				temp++;

				temp1 -= 60;
			}
			return temp + " m " + Militodatemethod(temp1);
		}
		if (mili < 86400 && mili >= 3600) {
			long temp1 = mili / 1000;
			long temp2 = 0;
			while (temp1 >= 3600) {
				temp2++;

				temp1 -= 3600;

			}
			return temp2 + " h " + Militodatemethod(temp1);
		}

		if (mili > 86400 && mili < 604800) {
			long temp1 = mili;
			long temp2 = 0;
			while (temp1 > 86400) {
				temp1 -= 86400;
				temp2++;
			}
			return temp2 + " d " + Militodatemethod(temp1);
		}
		long temp1 = mili;
		long temp2 = 0;
		while (temp1 >= 604800) {

			temp1 -= 604800;
			temp2++;

		}
		return temp2 + " t " + Militodatemethod(temp1);
	}

}
