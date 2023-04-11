import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.Random;
import java.util.*;

public class CatGPT implements Contract{

    public String name;
    public CatType breed;
    public ArrayList<String> actions;
    public ArrayList<String> items;
    public ArrayList<String> history;
    private ArrayList<String> grabactions;
    private ArrayList<String> dropactions;

    /** CatGPT constructor
     * @param name,breed
     * user can decide the name of the cat 
     */

    public CatGPT(String name){
        this.name = name;
        String Breed = this.actions.get(new Random().nextInt(CatType.values().length));;
        this.history = new ArrayList<String>();
        this.grabactions = new ArrayList<String>(Arrays.asList("is munching on", "playing with", "ripping apart the", "having the zoomies. Ignored your", "shows distate for", "is hissing at", "did nothing with your", "walked away", "took a nap. They don't want your", "waddled away. waddle waddle waddle til the very next day. rip your", "meow"));
        this.dropactions = new ArrayList<String>(Arrays.asList("ran away.", "refuses to drop the item", "dropped your item. Here.", "hissed at you", "... \n nothing happened", "meow meow meowwww" ));

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
     * @return CatAction
     * */ 
    public String drop(String item){
        String CatAction = this.dropactions.get(new Random().nextInt(this.dropactions.size()));
        System.out.println(this.name + " " + CatAction);
        this.history.add(this.name + " " + CatAction);
        return CatAction;
    }
    
    public void examine(String item){

    }
    public void use(String item){

    }
    public boolean walk(String direction){
        

    }
    public boolean fly(int x, int y){

    }
    public Number shrink(){

    }
    public Number grow(){

    }
    public void rest(){

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
    public void showOptions() {
        System.out.println("Available options for " + this.name + ":\n + undo() \n + grow() \n + rest() \n + shrink()\n + fly()\n + walk()\n + use() \n + examine()\n + ");
    }



    public static void main(String[] args) {
        CatGPT cat = new CatGPT("bean");
        cat.grab("apple");




    }
    
}
