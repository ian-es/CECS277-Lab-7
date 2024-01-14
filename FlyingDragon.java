class FlyingDragon extends Dragon{
  private int swoops;
  /** Constructs a flying dragon using variables from Dragon super class
  @param n name of dragon
  @param mHp maximum HP of dragon
  */
  public FlyingDragon(String n, int mHp, int sw){
    super(n, mHp); 
    swoops = sw;
  }
  /** Generates swooping damage between 5 and 10 and inflicts it on the Hero
  @param h the hero
  @return Message displaying damage done to hero
  @return Message when there are no attacks left
  */
  @Override
  public String specialAttack(Hero h){ 
    if (swoops != 0){
      int damage = (int) ( ( Math.random() * 10-5+1  ) + 5);
      h.takeDamage(damage);
      swoops--;
      return  this.getName() + " swoops the hero for " + damage + " damage!";
    }

    return "No swoops left!";
  }

  /** Displays a FlyingDragon
  @return name, current hp of dragon, and number of swoops left
  */
  @Override
  public String toString(){
    return super.toString() + "\nSwoops: " + swoops;
  }
}