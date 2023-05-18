import java.util.ArrayList;
import java.util.List;

public class RacingTrack {
    public static void main(String[] args) {
        List<Integer> positions = new ArrayList<>();
        positions.add(10);
        positions.add(15);
        positions.add(20);
        positions.add(5);

        List<Integer> speeds = new ArrayList<>();
        speeds.add(2);
        speeds.add(3);
        speeds.add(1);
        speeds.add(4);

        int overtakes = countOvertakes(positions, speeds);
        System.out.println("Количество обгонов: " + overtakes);
    }

    public static int countOvertakes(List<Integer> positions, List<Integer> speeds) {
        int overtakes = 0;
        int n = positions.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (speeds.get(i) > speeds.get(j) && positions.get(i) < positions.get(j)) {
                    overtakes++;
                }
            }
        }

        return overtakes;
    }
}