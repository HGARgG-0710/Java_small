public class BeerSong {
    public static void main(String[] args) {
        byte beerNum = 99;
        boolean anyBeerLeft = true;

        String[] wordForms = { "бутылка", "бутылки", "бутылки", "бутылки" };
        byte[] checkNumbers = { 1, 2, 3, 4 };
        byte[] extraNumbers = { 11, 12, 13, 14 };

        while (anyBeerLeft) {
            String word = "бутылок";

            for (byte i = 0; i < wordForms.length; i++) {
                if (((beerNum % 10) == checkNumbers[i]) && ((beerNum % extraNumbers[i]) != 0)) {
                    word = wordForms[i];
                }
            }

            System.out.println(beerNum + " " + word + " " + "пива на стене!");
            System.out.println(beerNum + " " + word + " " + "пива!");
            System.out.println("Возьми одну!");
            System.out.println("Пусти по кругу!");

            beerNum--;

            if (beerNum > 0) {
                if ((word.equals("бутылки"))
                        && ((beerNum % 10) == 1))
                    word = "бутылка";
                else if ((word.equals("бутылок"))
                        && ((beerNum % 10) == 4)
                        && (beerNum != 14))
                    word = "бутылки";
                else if ((word.equals("бутылка"))
                        && ((beerNum % 10) == 0))
                    word = "бутылок";

                System.out.println(beerNum + " " + word + " " + "пива на стене!");
                System.out.println(" ");
            } else {
                System.out.println("Нет бутылок пива на стене!");
                anyBeerLeft = false;
            }
        }
    }
}