class FireDragon extends Dragon{
  private int fireShots;

  /** Default constructor for fire dragon
  @param n name of dragon
  @param mHp initial hp
  */
  public FireDragon(String n, int mHp, int fs){
    super(n, mHp);
    fireShots = fs;
  }

  /** Generates fire damage between 9 and 5 and inflicts it on the Hero
  @param h Hero to be attacked
  @return String detailing who attacked, how, and how much damage
  */
  @Override
  public String specialAttack(Hero h){
    if (fireShots != 0){
      int damage = (int) ( ( Math.random() *(9-5+1))+ 5);
      h.takeDamage(damage);
      fireShots--;
      return  this.getName() + " engulfs you in flames for " + damage + " damage!";
    }
    return "No fireshots left!";
  }

  /** Displays a FireDragon
  @return name, current hp of dragon, and number of fire shots left
  */
  @Override
  public String toString(){
    return super.toString() + "\nFireshots: " + fireShots;
  }
}