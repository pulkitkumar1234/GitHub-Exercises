public class Ninth {

    public static void main(String args[]) {
        System.out.println("All House prices:");
        for (House house : House.values())
            System.out.println(house + " costs " + house.getPrice() + " thousand dollars.");
    }

    enum House {
        Antella(900), Mannat(2), Jannat(50), Swarg(15), Mandir(12);
        private int price;

        House(int price) {
            price = this.price;
        }

        int getPrice() {
            return price;
        }
    }

}

