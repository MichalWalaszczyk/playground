
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();
        Integer N = new Integer(s);
        List<Chamber> chambers = new ArrayList<Chamber>();
        Integer numberOfUnaccessibleChambers = 0;
        for (int i = 0; i < N; i++) {
            String stringChamber = r.readLine();
            String[] stringArray = stringChamber.split(" ");
            if (stringArray.length == 2) {
                chambers.add(new Chamber(new Integer(stringArray[0]), new Integer(stringArray[1])));
            } else {
                chambers.add(new Chamber(new Integer(stringArray[0])));
            }
        }
        goThroughtAccessibleChambers(chambers, chambers.get(0));
        for (Chamber chamber : chambers) {
            if (Boolean.FALSE.equals(chamber.accessible)) {
                ++numberOfUnaccessibleChambers;
            }
        }
        System.out.println(numberOfUnaccessibleChambers);
    }

    public static class Chamber {

        public Integer accessibleChamber1;
        public Integer accessibleChamber2;
        public Boolean accessible;

        public Chamber(Integer accessibleChamber1) {
            this.accessibleChamber1 = accessibleChamber1;
            this.accessible = Boolean.FALSE;
        }

        public Chamber(Integer accessibleChamber1, Integer accessibleChamber2) {
            this.accessibleChamber1 = accessibleChamber1;
            this.accessibleChamber2 = accessibleChamber2;
            this.accessible = Boolean.FALSE;
        }
    }

    public static void goThroughtAccessibleChambers(List<Chamber> chambers, Chamber chamber) {
        if (Objects.equals(chamber.accessible, Boolean.FALSE)) {
            chamber.accessible = Boolean.TRUE;
            if (chamber.accessibleChamber1 != null) {
                goThroughtAccessibleChambers(chambers, chambers.get(chamber.accessibleChamber1 - 1));
            }
            if (chamber.accessibleChamber2 != null) {
                goThroughtAccessibleChambers(chambers, chambers.get(chamber.accessibleChamber2 - 1));
            }
        }
    }
}
