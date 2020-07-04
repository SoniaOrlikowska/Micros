package mariusz;

public class Task {
    private String problem;
    private String answer;

    public Task(String problem, String answer){
        this.problem = problem;
        this.answer = answer;
    }

    public String getProblem(){
        return this.problem;
    }

    public String getAnswer(){
        return this.answer;
    }
}
//    4+5=|9
//  String a = "4+5=";
//  String b = "9";
//  Task task = new Task(a,b);
//  zadanie.setText(task.getProblem);
//  String answer;
// if(answer.equals(task.getAnswer){ hura}
// tokenizacja