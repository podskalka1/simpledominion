package sk.uniba.fmph.dcs;

public class GameCardType {
    private int plusActions;
    private int plusBuys;
    private int plusCards;
    private int plusCoins;
    private int points;
    private int cost;
    private boolean isAction;
    private String name;
    private String description;
    
    private GameCardType(int pa, int pb, int pca, int pco, int p, int c, boolean isA, String n, String d) {
        plusActions = pa;
        plusBuys = pb;
        plusCards = pca;
        plusCoins = pco;
        points = p;
        cost = c;
        isAction = isA;
        name = n;
        description = d;
    }
    
    public int getPlusActions() {return plusActions;}
    public int getPlusBuys() {return plusBuys;}
    public int getPlusCards() {return plusCards;}
    public int getPlusCoins() {return plusCoins;}
    public int getPoints() {return points;}
    public boolean isAction() {return isAction;}
    public String getName() {return name;}
    public String getDescription() {return description;}

    public int getCost(){return cost;}
    public boolean isTreasure(){
        return (this.isAction()&&(this.getPlusCoins()>0));
    }
    public boolean isVictory(){
        return (this.isAction()&&(this.getPoints()>0));
    }
    
    public static final GameCardType GAME_CARD_TYPE_MARKET = new GameCardType(1, 1, 1, 1, 0, 5, true, "Market", "+1 Action; +1 Buy; +1 Card; +1 Coin");
    public static final GameCardType GAME_CARD_TYPE_ESTATE = new GameCardType(0, 0, 0, 0, 1, 2, false, "Estate", "+1 Point");
    public static final GameCardType GAME_CARD_TYPE_COPPER = new GameCardType(0, 0, 0, 1, 0, 0, false, "Copper", "+1 Coin");
    public static final GameCardType GAME_CARD_TYPE_SMITHY = new GameCardType(0, 0, 3, 0, 0, 4, true, "Smithy", "+3 Cards");
    public static final GameCardType GAME_CARD_TYPE_VILLAGE = new GameCardType(2, 0, 1, 0, 0, 3, true, "Village", "+2 Actions; +1 Card");
    public static final GameCardType GAME_CARD_TYPE_FESTIVAL = new GameCardType(2, 1, 0, 2, 0, 5, true, "Festival", "+2 Actions; +1 Buy; +2 Coins");
    public static final GameCardType GAME_CARD_TYPE_LABORATORY = new GameCardType(1, 0, 2, 0, 0, 5, true, "Laboratory", "+1 Action; +2 Cards");

}


