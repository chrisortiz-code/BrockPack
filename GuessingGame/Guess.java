import BasicIO.*;
import Media.*;
import static java.lang.Math.*;

public class Guess{
    BasicForm bf;
    BasicForm bf2;
    int guess;
    int correct;
    int count;
    int button;
    String clue;
    
    public Guess(){
        buildForm();
        buildForm2();
        correct = (int)(random()*100);
        int button2 = bf2.accept();
        bf.hide();
        if (button2==0){
            bf.show();
        }
        if (button2==1){
            bf.close();
            bf2.close();
        }
 
        while(guess!=correct){
            button = bf.accept();
            if(button == 0){
                guess = bf.readInt("try"); 
                count+=1;
                if(guess<correct){
                clue = "Higher";
                }
                else if(guess>correct){
                clue = "Lower";
                }
                else if(guess==correct){
                clue= "Correct in "+ count +" guesses";
                }               
                bf.writeString("feedback", clue);

            }

        } 
        bf.close();
        bf2.close();
    } 
        private void buildForm(){
        bf = new BasicForm("Guess");
        bf2.addLabel("title","Guess a # between 1-100");
        bf2.addTextField("try","Guess:", 4);
        bf2.addTextField("feedback", 30);
        bf2.setEditable("feedback",false);
        
        
    }
        private void buildForm2(){
        bf2 = new BasicForm("Play", "Quit");
        bf2.addLabel("title","Guess a # between 1-100");
        bf2.addTextField("try","Guess:", 4);
        bf2.addTextField("feedback", 30);
        bf2.setEditable("feedback",false);

        
        
    }
}
