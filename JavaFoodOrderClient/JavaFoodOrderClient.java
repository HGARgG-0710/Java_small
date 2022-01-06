import java.util.Scanner;

class Menu
{
	
	Scanner in = new Scanner(System.in);
	
	void makeAMenu(String[][] arrays, String[] names)
	{
		for(byte i = 0; i < arrays.length; i++)
		{
			System.out.println(names[i]);
			for(byte j = 0; j < arrays[i].length; j++)
				System.out.println((j + 1) + "." + arrays[i][j]);

			System.out.println(" ");
		}
	}
	
	void makeAnOrder(String randomOrNot, int[] coordinates, String[][] neededArrays, String[] neededNames)
	{
		switch(randomOrNot)
		{
			case "y":
				System.out.println("Очень хорошо! В таком случае, ничего более вводить не надо, мы сами позаботимся о выборе вашего заказа.");
				
				for(byte l = 0; l < coordinates.length; l++)
					coordinates[l] = (int) (Math.random() * neededArrays[l].length);

				break;
			
			case "n":
				System.out.println("Нет? Что ж, в таком случае мы выдадим Вам меню, а Вы введёте нужные четыре числа самостоятельно. Все с новой строки.");
				makeAMenu(neededArrays, neededNames);
				System.out.println("А теперь, попрошу, введите координаты Вашего заказа:");
				
				for(byte f = 0; f < 4; f++)
					coordinates[f] = in.nextInt() - 1; 
		}
	}
}

class Order
{
	String[] endings = new String[3];
	String[] changeableLetters = {"ые", "ие" , "ый", "ий", "ая", "яя"};
	byte endingIndex = 0;
	
	String returnOrder(int[] coord, String[] switchCondArr1, String[] switchCondArr2, String[][] Arrs)
	{		
		switch(((coord[3] + 1) % 4))
		{		
			case 0: endingIndex = 1; break;
			case 1: endingIndex = 5; break;
					
			case 2:
			case 3: 
				endingIndex = 3; 	
		}
				
		switch(endingIndex)
		{
			case 5:
				endings[0] = changeableLetters[endingIndex - 1];
					break;
			default:
				endings[0] = changeableLetters[endingIndex];
		}
		
		if(endingIndex != 5)
		{
			switch(switchCondArr1[coord[1]])
			{
				case "жёстк": 
				case "мягк": 
				case "вегетерианск": 
				case "веганск":
					endings[1] = changeableLetters[endingIndex];
					break;
				default:
					endings[1] = changeableLetters[endingIndex - 1];
			}
		}
		else
		{
			endings[1] = changeableLetters[endingIndex - 1];
		}
				
		switch(switchCondArr2[coord[2]])
		{
			case "Древн":
			case "Королевск": 
			case "Наивеличайш":
				endings[2] = changeableLetters[endingIndex];
				break;
			default:
				endings[2] = changeableLetters[endingIndex - 1];
		}
				
		String order = Arrs[0][coord[0]] + endings[0] + " " + Arrs[1][coord[1]] + endings[1] + " " + Arrs[2][coord[2]] + endings[2] + " " + Arrs[3][coord[3]];
		
		return order;
	}
}

public class JavaFoodOrderClient
{
	public static void main(String[] args)
	{	
		String[] countries = {
		"Израильск", "Уэльск", "Ирландск", "Британск", "Американск",
		"Российск", "Татарск", "Арабск", "Армянск", "Японск",
		"Казахск", "Грузинск", "Башкирск","Африканск", "Австралийск",
		"Палистинск", "Египетск", "Иранск", "Дагестанск", "Монгольск",
		"Индийск", "Немецк", "Французск", "Исландск", "Норвежск",
		"Датск", "Итальянск", "Португальск", "Бразильск", "Малазийск"};
		
		String[] species = {
		"слегка перчённ", "адски остр", "стандартн", "конфетн", "огромн", 
		"жёстк", "мягк", "вегетерианск", "веганск"};
		
		String[] titles = {
		"Убийственно Вкусн", "Легендарн", "Отравленн", "Бессмертн", 
		"Древн", "Королевск", "Наивеличайш", "Кавказски Чист"};
		
		String[] food = {
		"пицца", "рататуй", "чебупель", "пельмени",
		"паста", "бургер", "луковый суп", "роллы",
		"паэлья", "ролл", "борщ", "бургеры", 
		"фокачча", "цыплёнок", "краб", "сосиски"
		};
		
		String[][] allArrays = {countries, species, titles, food};
		String[] allNames = {"Страны", "Специи", "Титулы", "Блюда"};
		int[] orderCoordinates = new int[4];
		
		Menu menu = new Menu();
		
		System.out.println("Приветстую в моём шуточном Java-клиенте по \"заказу\" \"еды\" :D!");
		System.out.println("Если хотите получить случайный заказ бесплатно, то наберите y, в противном случае наберите n.");
		System.out.print("Введите y или n: ");
		String randomOrder = menu.in.next();
		
		menu.makeAnOrder(randomOrder, orderCoordinates, allArrays, allNames);
		
		Order theOrder = new Order();
		String order = theOrder.returnOrder(orderCoordinates, species, titles, allArrays);
		
		System.out.println("Итак, ваш заказ - это " + order + ".");
	}
}