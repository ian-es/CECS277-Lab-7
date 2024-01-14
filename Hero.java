class Hero{
  private String name;
  private int hp;
  private int maxHp;

  /** Default constructor for Hero
  @param n given name of hero
  @param mHp initial hp of hero
  */
  public Hero(String n, int mHp){
    name = n;
    maxHp = mHp;
    hp = mHp;
  }
  
  /** Gets current hp of hero
  @return current hp
  */
  public int getHp(){
    return hp;
  }

  /** Updates hp to reflect damage taken, minimum number is 0
  */
  public void takeDamage(int d){
    if (hp-d < 0){
      hp = 0;
    }
    else{
      hp = hp - d;
    }
  }

  /** Generates attack damage of 1d12 and inflicts it on the Dragon
  @param d Dragon to be attacked
  @return String detailing who was attacked, how, and how much damage
  */
  public String arrowAttack(Dragon d){
    int damage = (int)((Math.random()*(12-1+1))+1);
    d.takeDamage(damage);

    return "You hit the "+d.getName()+" with an arrow for "+damage+" damage.";
  }

  /** Generates attack damage of 2d6 and inflicts it on the Dragon
  @param d Dragon to be attacked
  @return String detailing who was attacked, how, and how much damage
  */
  public String swordAttack(Dragon d){
    int damage = (int)((Math.random()*(6-1+1))+1) + (int)((Math.random()*(6-1+1))+1);
    d.takeDamage(damage);
    
    return "You slash the "+d.getName()+" with your sword for "+damage+" damage.";
  }

  /** Displays a Hero
  @return name and current hp of hero
  */
  @Override
  public String toString(){
    return name+": "+hp+"/"+maxHp;
  }
  
}