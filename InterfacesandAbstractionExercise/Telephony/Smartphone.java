package InterfacesandAbstractionExercise.Telephony;

import java.util.List;

public class Smartphone implements Callable,Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String url : urls) {
            boolean isInvalid = false;
            for (int i = 0; i < url.length(); i++) {
                if(Character.isDigit(url.charAt(i))){
                    isInvalid = true;
                    break;
                }
            }
            if(isInvalid){
                builder.append("Invalid URL!\n");
            } else {
                builder.append("Browsing: ");
                builder.append(url + "!\n");
            }
        }
        return builder.toString();
    }

    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        boolean notDigit = false;
        for (String number : numbers) {
            for (int i = 0; i < number.length(); i++) {
                if(!Character.isDigit(number.charAt(i))){
                    notDigit = true;
                    break;
                }
            }
            if(notDigit){
                builder.append("Invalid number!");
            }else {
                builder.append("Calling... " + number + "\n");
            }
        }
        return builder.toString();
    }
}
