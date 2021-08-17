public class Leetcode1603 {

    class ParkingSystem {

        int capBig, capMedium, capSmall;

        public ParkingSystem(int big, int medium, int small) {
            capBig = big;
            capMedium = medium;
            capSmall = small;
        }

        public boolean addCar(int carType) {

            switch (carType) {
                case 1:
                    if (capBig == 0) {
                        return false;
                    }
                    capBig--;
                    return true;
                case 2:
                    if (capMedium == 0) {
                        return false;
                    }
                    capMedium--;
                    return true;
                case 3:
                    if (capSmall == 0) {
                        return false;
                    }
                    capSmall--;
                    return true;
                default:
                    return true;
            }
        }
    }
}
