import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.*;

public class CatGPT implements Contract{

    public String name;
    public String breed;
    public ArrayList<String> actions;
    public ArrayList<String> items;
    public ArrayList<String> history;
    private ArrayList<String> grabactions;
    private ArrayList<String> dropactions;
    private ArrayList<String> treats;
    public int xLocation;
    public int yLocation;
    private double size;
    public ArrayList<String> catType = new ArrayList<>(List.of( "CRAZY_ORANGE", "TUXEDO", "CALICO", "TABBY", "PERSIAN", "MAINE_COON", "SIAMESE"));



    /** CatGPT constructor
     * @param name,size
     * user can decide the name of the cat 
     */

    public CatGPT(String name, double size){
        this.name = name;
        this.size = size;
        this.breed = this.catType.get(new Random().nextInt(this.catType.size()));
        this.history = new ArrayList<String>();
        this.grabactions = new ArrayList<String>(Arrays.asList("is munching on", "playing with", "ripping apart the", "having the zoomies. Ignored your", "shows distate for", "is hissing at", "did nothing with your", "walked away", "took a nap. They don't want your", "waddled away. waddle waddle waddle til the very next day. rip your"));
        this.dropactions = new ArrayList<String>(Arrays.asList("ran away.", "refuses to drop the item", "dropped your item. Here.", "hissed at you", "... \n nothing happened", "meow meow meowwww" ));
        this.actions = new ArrayList<String>(Arrays.asList("meow", "mrrrrr", "meow meow meooooow", "grrrr mwrrr", "hissss"));
        this.treats = new ArrayList<String>(Arrays.asList("candy", "fish", "kibble", "Fancy Feast", "Purina Wet Cat Food", "bird", "lizard", "BLUE Wilderness Adult Dry Cat Food", "Friskies Seafood Sensation"));
        this.xLocation = 0;
        this.yLocation = 0;
    }

    
    /** Random grab method for cat 
     * @param item
     * @return adds the action to the history
     * */ 
    public void grab(String item){
        System.out.println("you have given " + item + " to " + this.name);
        String CatAction = this.grabactions.get(new Random().nextInt(this.grabactions.size()));
        System.out.println(this.name + " " + CatAction + " " + item);
        this.history.add(this.name + " " + CatAction + " " + item);
    }


    /** Random drop method for cat 
     * @param item
     * @return CatAction describing what the cat has done
     * */ 
    public String drop(String item){
        String catAction = this.dropactions.get(new Random().nextInt(this.dropactions.size()));
        System.out.println(this.name + " " + catAction);
        this.history.add(this.name + " " + catAction);
        return catAction;
    }

    /** Method allows user to examine cat
     * @param bodyPart
     */
    
    public void examine(String bodyPart){
        if (bodyPart.contains("head") || bodyPart.contains("ears")){
            String catTalk = this.actions.get(new Random().nextInt(this.actions.size()));
            System.out.println(catTalk);
            this.history.add(catTalk);
        }
        if (bodyPart.contains("paws")){
            System.out.println("omg check out it's little beans! be careful they might scratch you");
            this.history.add("omg check out it's little beans! be careful they might scratch you");
            boolean scratch = new Random().nextBoolean();
            if (scratch == true){
                System.out.println(this.name + " scratched you! Better apologize :-(");
                this.history.add(this.name + " scratched you! Better apologize :-(");
            }
            else{
                System.out.println("hmmm" + this.name + " doesn't seem to mind...let's see what they have to say");
                System.out.println(this.actions.get(new Random().nextInt(this.actions.size())));
                this.history.add("hmmm" + this.name + " doesn't seem to mind...let's see what they have to say");
                this.history.add(this.actions.get(new Random().nextInt(this.actions.size())));
            }
        }
        if (bodyPart.contains("tail") || bodyPart.contains("belly")){
            boolean swish = new Random().nextBoolean();
            if (swish == true){
                System.out.println(this.name + " might not like that!");
                this.history.add(this.name + " might not like that!");
            }
            else{
                System.out.println("hmmm" + this.name + " doesn't seem to mind their fluffy tail...let's see what they have to say");
                System.out.println(this.actions.get(new Random().nextInt(this.actions.size())));
                this.history.add("hmmm" + this.name + " doesn't seem to mind their fluffy tail...let's see what they have to say");
                this.history.add(this.actions.get(new Random().nextInt(this.actions.size())));

            }
        if (bodyPart.contains("whiskers")){
            System.out.println("Please do not the cat.");
            this.history.add("Please do not the cat.");

        }
        else{
            throw new RuntimeException("Sorry, not a feature of this cat.");
        }
        }
    }

    // /**Map map mapppp */
    // public Map(int x, int y){
    //     this.grid = new String[x][y];
    //     this.x = x;
    //     this.y = y;
    // }

    /**Random use method that allows cat to play with item based on grab and drop method
     * @param item
     */


    public void use(String item){
        this.grab(item);
        this.drop(item);

    }

/**Random coordinate location method that walks one step
 * @param direction
 * @return boolean of whether the cat decided to walk
 */
    public boolean walk(String direction){
        boolean walkDecision = new Random().nextBoolean();
        if (walkDecision == true){
            if (direction.contains("north")){
                this.yLocation += 1;
                System.out.println(this.name + " moved north by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
                this.history.add(this.name + " moved north by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
            }
            if (direction.contains("south")) {
                this.yLocation -= 1;
                System.out.println(this.name + " moved South by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
                this.history.add(this.name + " moved South by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");

            }
            if (direction.contains("west")){
                this.xLocation -= 1;
                System.out.println(this.name + " moved West by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
                this.history.add(this.name + " moved West by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");

            }
            if (direction.contains("east")){
                this.xLocation += 1;
                System.out.println(this.name + " moved East by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
                this.history.add(this.name + " moved East by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");

            }
            if (direction.contains("southwest")){
                this.xLocation -= 1;
                this.yLocation -= 1;
                System.out.println(this.name + " moved South West by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
                this.history.add(this.name + " moved South West by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");

            }
            if (direction.contains("southeast")){
                this.xLocation += 1;
                this.yLocation -= 1;
                System.out.println(this.name + " moved South East by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
                this.history.add(this.name + " moved South East by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");

            }
            if (direction.contains("northwest")){
                this.xLocation -= 1;
                this.yLocation += 1;
                System.out.println(this.name + " moved North West by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
                this.history.add(this.name + " moved North West by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");

            }
            if (direction.contains("northeast")){
                this.xLocation += 1;
                this.yLocation += 1;
                System.out.println(this.name + " moved North East by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
                this.history.add(this.name + " moved North East by one step. \n Here are the coordinates" + "(" + this.xLocation + this.yLocation + ")");
            }
        
        if (walkDecision == false) {
          throw new RuntimeException("Sorry, this cat refuses to move for you.");  
        }
        }       
        return walkDecision;
    }

    /** Cat's can't fly!
    * @param x,y
    * @return RuntimeException message 
    */
    public boolean fly(int x, int y){
        System.out.println("Sorry a cat cannot fly.");
        this.history.add("Sorry a cat cannot fly.");
        return false;
    }

    /**Method to shrink the cat????
    * @param newSize
    * @return Number
    */
    public Number shrink(){
        this.size = this.size*.5;
        System.out.println(this.name + " shrunk and is now" + this.size + " pds.");
        this.history.add(this.name + " shrunk and is now" + this.size + " pds.");
        return this.size;
    }

    /** Method to feed the cat
     * @param 
    * @return Number
    */
    public Number grow(){
        String treat = this.treats.get(new Random().nextInt(this.treats.size()));
        System.out.println("You just gave " + this.name + " a " + treat);
        this.history.add("You just gave " + this.name + " a " + treat);
        this.size = this.size*1.2;
        System.out.println(this.name + " grew and is now" + this.size + " pds.");
        this.history.add(this.name + " grew and is now" + this.size + " pds.");
        return this.size;
    }

    /** Method to nap with the cat?! or let the cat nap on you :)
     * @param 
    * @return Number
    */
    public void rest(){
        boolean napDecision = new Random().nextBoolean();
        if (!napDecision == true){
            System.out.println(this.name + " doesn't want to loaf right now.");
            this.history.add(this.name + " doesn't want to loaf right now.");
        }
        else{
            System.out.println(this.actions.get(new Random().nextInt(this.actions.size())));
            System.out.println(this.name + " decided to nap with you! Loaf time :3");
            this.history.add(this.actions.get(new Random().nextInt(this.actions.size())));
            this.history.add(this.name + " decided to nap with you! Loaf time :3");
        }
        
    }

    /** Return to previous action in the history array list
     * @param num
     * @return RuntimeException message if the user tries to back past the length of transcript
     */
    public void undo(int num){
        if (num <= this.history.size()-1 ){
            System.out.println(this.history.get(this.history.size()-num-1));
            this.history.set(this.history.size()-num-1, this.history.get(this.history.size()-num-1));
        }
        else{
            throw new RuntimeException("Can't undo that far.");
        }        
    }

    

      /** Accessors */
    public void getTranscript(){
        System.out.println(this.history);
    }
    public void getBreed(){
        System.out.println(this.breed);
        this.history.add(this.breed);

    }
    public void showOptions() {
        System.out.println("Available options for " + this.name + ":\n + undo() \n + grow() \n + rest() \n + shrink()\n + fly()\n + walk()\n + use() \n + examine()\n + ");
        this.history.add("Available options for " + this.name + ":\n + undo() \n + grow() \n + rest() \n + shrink()\n + fly()\n + walk()\n + use() \n + examine()\n + ");
    
    }

    public void showDirections() {
        System.out.println("Available options for " + this.name + ":\n + north \n + east \n + south \n + west\n + southwest\n + southeast\n + northeast \n + northwest\n ");
        this.history.add("Available options for " + this.name + ":\n + north \n + east \n + south \n + west\n + southwest\n + southeast\n + northeast \n + northwest\n ");
 
    }

    public String toString() {
        return this.name + " is a " + this.breed + "and they weigh  " + this.size + " pds.";
    }



    public static void main(String[] args) {
        CatGPT bean = new CatGPT("bean", 10.75);
        bean.getBreed();
        bean.grab("apple");
        bean.use("feather");
        bean.examine("belly");
        bean.walk("southwest");
        bean.grow();
        bean.rest();
        bean.getTranscript();
        bean.undo(3);
        System.out.print(bean);






    }
    
}
