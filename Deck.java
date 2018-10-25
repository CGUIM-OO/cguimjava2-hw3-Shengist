import java.util.ArrayList;
import java.util.Random;
/**
 * Description: TODO:用來進行把排洗入牌堆的動作 
 */
//用來進行把排洗入牌堆的動作
class Deck{
	private ArrayList<Card> cards;
	private int i,j,k;
	private ArrayList<Card> usedCard; 
	private ArrayList<Card> nUsed;
	private int cardTimer;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		usedCard=new ArrayList<Card>();
		for(i=0;i<nDeck;i++) {
			for(j=1;j<5;j++) {
				for(k=1;k<14;k++){
				Card card=new Card(j,k);
				cards.add(card);
				}
			}
		}
		nUsed=cards;
		cardTimer = cards.size();
		//System.out.println(usedCard.size());
    }	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(Card value:cards) {
		 value.printCard();
		}
	}
	public Card getOneCard() {
		if(cardTimer>0){
			usedCard.add(nUsed.get(cardTimer-1));
			cardTimer--;
		}
		return nUsed.get(cardTimer);
	}
	public void shuffle() {
		Random rnd = new Random();
		for(int i = 0; i<usedCard.size(); i++) {
			int j = rnd.nextInt(i + 1);
			while(j>nUsed.size()) {
				j = rnd.nextInt(i + 1);
			}
			nUsed.add(j,usedCard.get(i));
			usedCard.remove(i);
		}
		
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}