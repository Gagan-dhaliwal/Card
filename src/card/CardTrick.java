/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 *@modifier Gaganpreet Kaur Dhaliwal
 */
import java.util.Random;
import java.util.Scanner;
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
             int randomValue = generateNumber(1, 13);
            String randomSuit = Card.SUITS[generateNumber(0, 3)];
            
            c.setValue(randomValue);
            c.setSuit(randomSuit);
            
            magicHand[i]=c;
        }
          
  
        //insert code to ask the user for Card value and suit, create their card
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a card value (1-13): ");
        int value = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter a card suit (Hearts, Diamonds, Spades, Clubs): ");
        String suit = scan.nextLine();

        Card userCard = new Card();
        userCard.setValue(value);  
        userCard.setSuit(suit);
        // and search magicHand here
        boolean matchFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                matchFound = true;
                break;
            }
        }
        
        Card luckyCard= new Card();
        luckyCard.setValue(9);
        luckyCard.setSuit("Clubs");
        
        boolean isluckyCard = (luckyCard.getValue() == userCard.getValue && luckyCard.getSuit().equalsIgnoreCase(userCard.getSuit()));
        
        //Then report the result here
        if (matchFound) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        if(isLuckyCard) {
            System.out.println("Winner!");
        }else {
            System.out.println("keep trying!");
        }
        
        System.out.println("The deck of randomly generated cards was:");
        for (int i = 0; i < magicHand.length; i++) {
            Card card = magicHand[i];
            System.out.println("Card " + (i + 1) + ": " + card.getValue() + " of " + card.getSuit());
        }
    
    }
    
    public static int generateNumber(int min, int max){
        Random rand= new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
