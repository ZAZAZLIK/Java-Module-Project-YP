import java.util.Scanner;

    class Avto {
        String naimAvto;
        int speedAvto;
        Avto(String naimAvto, int speedAvto) {
            this.naimAvto = naimAvto;
            this.speedAvto = speedAvto;
        }
        int distanceDey() {
            return speedAvto * 24;
        }
    }
    class Race {
        Avto leader;
        void defineLeader(Avto[] avtos) {
            leader = avtos[0];
            for (Avto car : avtos) {
                if (car.distanceDey() > leader.distanceDey()) {
                    leader = car;
                }
            }
        }
    }
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Avto[] avtos = new Avto[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите наименование автомобиля №" + (i + 1));
            String nameAvto = scanner.nextLine();
            int speedAvto;
            while (true) {
                System.out.println("Введите скорость автомобиля №" + (i + 1));
                if (scanner.hasNextInt()) {
                    speedAvto = scanner.nextInt();
                    if (speedAvto < 0 || speedAvto > 250) {
                        System.out.println("Неверная скорость. Поробуйте снова пожалуйста.");
                    } else {
                        break;
                    }
                }
            }
            scanner.nextLine();
            avtos[i] = new Avto(nameAvto, speedAvto);
        }
        Race race = new Race();
        race.defineLeader(avtos);
        System.out.println(race.leader.naimAvto + " - лучшая машина в моменте");
    }
}