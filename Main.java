import java.util.*;
/*
Group 11
Ian Escalante
Julio Calderon

CECS 277 Lab 7
3/10/2022
*/

class Main {
  /** Dragon fighter game
  */
  public static void main(String[] args) {
    System.out.println("What is your name, challenger?");
    String name = CheckInput.getString();
    Hero h = new Hero(name,50);
    System.out.println("Welcome to dragon training, "+name);
    
    ArrayList<Dragon> dragons = new ArrayList<Dragon>();
    dragons.add(new Dragon("Gronckle", 10));
    dragons.add(new FireDragon("Fronckle", 16, 3));
    dragons.add(new FlyingDragon("Kronckle", 15, 5));
    System.out.println("You must defeat "+dragons.size()+" dragons.");
    
    while(h.getHp()!= 0 && dragons.size() != 0){
      System.out.println(h);
      
      // Display Dragons remaining, takes in which the user chooses to attack
      for (int i = 0; i < dragons.size(); i++){
        System.out.println((i + 1) + ". Attack " + dragons.get(i));
      }
      int dragonChoice = CheckInput.getIntRange(1,dragons.size());
      System.out.println("Attack with:\n1. Arrow (1 D12)\n2. Sword (2 D6)");

      //Takes in user's weapon choice
      int weaponChoice = CheckInput.getIntRange(1,2);
      if (weaponChoice == 1){
        System.out.println(h.arrowAttack(dragons.get(dragonChoice - 1)));
      } else {
        System.out.println(h.swordAttack(dragons.get(dragonChoice - 1)));
      }
      if (dragons.get(dragonChoice - 1).getHp() == 0){
        dragons.remove(dragonChoice - 1);
      } 

      //Prompts a random dragon to choose a random attack
      if(dragons.size() != 0){
        int attackingDragon = (int)((Math.random()*dragons.size())+1);
        int attackType = (int)((Math.random()*2)+1);
        if (attackType == 1){
          System.out.println(dragons.get(attackingDragon - 1).basicAttack(h));
        } else {
          System.out.println(dragons.get(attackingDragon - 1).specialAttack(h));
        }
      }
    }

    //check win/lose condition
    if (h.getHp() == 0){
      System.out.println("Sorry, you lost!");
    } else if (dragons.size() == 0){
      System.out.println("Congratulations! You have defeated all "+dragons.size()+" dragons, you have passed the trials.");
    }
  }

  
  
}