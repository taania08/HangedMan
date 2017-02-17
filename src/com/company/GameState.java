package com.company;

public class GameState {

    private String word;
    private int attempts;
    private boolean [] success;

    public GameState() {

        Dictionary dictionary = new Dictionary();
        this.word = dictionary.getRandomWord();
        this.success = new boolean[word.length()];

    }

    public String getCurrentResult(){

        String result = "";

        for(int i = 0; i<word.length(); i++){
            if(success[i] == false){
                result = result + "_ ";
            }else{
                result = result + word.charAt(i);
            }
        }

        result = result + System.lineSeparator();
        result = result + "You have " + (10 - attempts) + " attempts left.";

        return result;
    }

    public void checkLetter(char letter){

        int coincidence = 0;

        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i) == letter) {
                success[i] = true;
                coincidence++;
            }
        }

        if(coincidence == 0){
            attempts++;
            System.out.println("This letter doesn't match.");
        }

        else{
            System.out.println("This letter matches!");
        }
    }

    public boolean isOver(){

        boolean pendingLetter = false;

        for(int i = 0; i<success.length; i++) {
            if (success[i] == false) {
                pendingLetter = true;
                break;
            }
        }

        if((pendingLetter == true && attempts == 10) || pendingLetter == false){
            return true;
        }else {
            return false;
        }
    }

    public boolean hasWon(){
        if(isOver() && attempts<10){
            return true;
        }else{
            return false;
        }
    }


}
