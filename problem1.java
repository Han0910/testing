public class problem1 {
    public static void main(String[] args) {
        try{
            Phone phone = new HanPhone();
            phone.name = "Han";
            phone.model = "Nguyen";

            App app1 = new CanvasApp();
            app1.name = "abc";
            app1.version = 90;
            App app2 = new GameApp();
            app2.name = "def";
            app2.version = 90;
            App app3 = new App();
            app3.name = "hig";
            app3.version = 90;

            phone.installApp(app1);
            phone.installApp(app2);
            phone.installApp(app3);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
abstract class Phone{
    String name;
    String model;

    public abstract String getAppHub();
    public abstract String getOS();

    public void installApp(App app) throws IncompatibleAppException {
        // check if app is compatible with Apple
        if (this.getOS().equals("Apple"))
            if (!(app instanceof AppleCompatible)){
                throw new IncompatibleAppException("App is not compatible with phone");
            } else {
                System.out.println("Visit " + getAppHub() + " to get more apps");
                System.out.println(((AppleCompatible) app).saveMoney());
            }
        // check if app is compatible with Android
        if (this.getOS().equals("Android"))
            if (!(app instanceof AndroidCompatible)){
                throw new IncompatibleAppException("App is not compatible with phone");
            } else {
                System.out.println("Visit " + getAppHub() + " to get more apps");
                System.out.println(((AndroidCompatible) app).saveTime());
            }
        // check if app is compatible with Han
        if (this.getOS().equals("Han")){
            if(app instanceof AppleCompatible){
                System.out.println("Visit " + getAppHub() + " to get more apps");
                System.out.println(((AppleCompatible) app).saveMoney());
            }
             else if (app instanceof AndroidCompatible){
                System.out.println("Visit " + getAppHub() + " to get more apps");
                System.out.println(((AndroidCompatible) app).saveTime());
            }
            else{
                throw new IncompatibleAppException("App is not compatible with phone");
            }
        }
        // check app is compatible to both Apple and Android
        if (app instanceof AppleCompatible && app instanceof AndroidCompatible){
            System.out.println(((AppleCompatible) app).saveMoney());
            System.out.println(((AndroidCompatible) app).saveTime());
        }
    }
}
class ApplePhone extends Phone{
    public String getAppHub() {
        return "App Store";
    }
    public String getOS(){
        return "Apple";
    }
}
class AndroidPhone extends Phone{
    public String getAppHub() {
        return "Play Store";
    }
    public String getOS(){
        return "Android";
    }
}
class HanPhone extends Phone{
    public String getAppHub() {
        return "Han Store";
    }
    public String getOS(){
        return "Han";
    }
}
class App {
    String name;
    int version;

    public String toString(){
        return name + ": " + version;
    }
}
class CanvasApp extends App implements AppleCompatible{
    public String saveMoney(){
        return "Save enough money to install " + toString();
    }
}
class GameApp extends App implements AndroidCompatible{
    public String saveTime(){
        return "Save enough time to install " + toString();
    }
}

interface AppleCompatible{
    public String saveMoney();
}
interface AndroidCompatible{
    public String saveTime();
}
class IncompatibleAppException extends Exception{
    public IncompatibleAppException(String str){
        super(str);
    }
}