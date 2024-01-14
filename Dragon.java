class Dragon{
  private String name;
  private int hp;
  private int maxHp;


  /** Default constructor for dragon to set name and initial HP
  @param n name to be set
  @param mHp max hp to be set
  */
  public Dragon(String n,int mHp){
    name = n;
    maxHp = mHp;
    hp = mHp;
  }

  /** Returns name of dragon
  @return name
  */
  public String getName(){
    return name;
  }

  /** Returns hp of dragon
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

  /** Generates attack damage between 7 and 3 and inflicts it on the Hero
  @param h Hero to be attacked
  @return String detailing who attacked, how, and how much damage
  */
  public String basicAttack(Hero h){
    int damage = (int)((Math.random()*(7-3+1))+3);
    h.takeDamage(damage);

    return name+" smashes you with its tail for "+damage+" damage!";
  }

  /** Generates attack damage between 8 and 4 and inflicts it on the Hero
  @param h Hero to be attacked
  @return String detailing who attacked, how, and how much damage
  */
  public String specialAttack(Hero h){
    int damage = (int)((Math.random()*(8-4+1))+4);
    h.takeDamage(damage);
    
    return name+" slashes you with its claws for "+damage+" damage!";
  }

  /** Displays a Dragon
  @return name and current hp of dragon
  */
  @Override
  public String toString(){
    return name+": "+hp+"/"+maxHp;
  }
  
}