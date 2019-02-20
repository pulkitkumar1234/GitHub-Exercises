public class Ninth {
    enum House {
        Antella(900),Mannat(2),Jannat(50),Swarg(15),Mandir(12);
        private int price;
        House(int p) {
            price = p;
        }
        int getPrice() {
            return price;
        }
    }

        public static void main(String args[]){
            System.out.println("All House prices:");
            for (House c : House.values()) System.out.println(
                    c + " costs " + c.getPrice() + " thousand dollars.");
        }
   }

